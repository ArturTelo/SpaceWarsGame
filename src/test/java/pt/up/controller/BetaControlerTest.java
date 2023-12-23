package pt.up.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.controller.game.AlphaController;
import pt.up.controller.game.BetaController;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.Barrier;
import pt.up.model.game.elements.CeiGro;
import pt.up.model.game.elements.Hero;
import pt.up.model.game.elements.Wall;
import pt.up.model.game.elements.enemy.Beta;
import pt.up.model.game.elements.enemy.EnemyShot;
import pt.up.model.game.space.Space;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BetaControlerTest {

    private Space space;
    private BetaController betaController;

    private pt.up.Space space1;

    @BeforeEach
    void setUp() {
        space = new Space(10,10);
        space.setBetas(new ArrayList<>(Arrays.asList(new Beta(2,3),new Beta(4,3))));
        space.setWalls(new ArrayList<>(Arrays.asList(new Wall(0,3),new Wall(6,3))));
        space.setCeiGro(new ArrayList<>(Arrays.asList(new CeiGro(5,0), new CeiGro(5,10))));
        betaController = new BetaController(space);
        space1= Mockito.mock(pt.up.Space.class);
    }

    @Test
    void changedirection() {
        betaController.setSide(1);
        betaController.changed=true;
        betaController.chagedirection();
        assertEquals(betaController.getSide(),0);
        assertFalse(betaController.getChanged());
        betaController.setSide(1);
        betaController.changed=false;
        betaController.chagedirection();
        assertEquals(betaController.getSide(),1);
        assertFalse(betaController.getChanged());
        betaController.setSide(0);
        betaController.changed=true;
        betaController.chagedirection();
        assertEquals(betaController.getSide(),1);
        assertFalse(betaController.getChanged());
        betaController.setSide(0);
        betaController.changed=false;
        betaController.chagedirection();
        assertEquals(betaController.getSide(),0);
        assertFalse(betaController.getChanged());
    }

    @Test
    void moveRight() throws IOException {
        betaController.setSide(1);
        betaController.setCountpositions(49);
        betaController.step(space1, GUI.ACTION.NONE,1000);
        assertEquals(space.getBetas().get(0).getPosition(),new Position(3,3));
        assertEquals(space.getBetas().get(1).getPosition(),new Position(5,3));
    }
    @Test
    void moveLeft() throws IOException {
        betaController.setSide(0);
        betaController.setCountpositions(49);
        betaController.step(space1, GUI.ACTION.NONE,1000);
        assertEquals(space.getBetas().get(0).getPosition(),new Position(1,3));
        assertEquals(space.getBetas().get(1).getPosition(),new Position(3,3));
    }
    @Test
    void moveRnDown() throws IOException {
        betaController.setSide(1);
        betaController.setCountpositions(50);
        betaController.step(space1, GUI.ACTION.NONE, 1000);
        assertEquals(space.getBetas().get(0).getPosition(), new Position(3, 3));
        assertEquals(space.getBetas().get(1).getPosition(), new Position(5, 3));
        betaController.step(space1, GUI.ACTION.NONE, 1301);
        assertEquals(space.getBetas().get(0).getPosition(), new Position(3, 3));
        assertEquals(space.getBetas().get(1).getPosition(), new Position(5, 3));
        betaController.step(space1, GUI.ACTION.NONE, 1602);
        assertEquals(space.getBetas().get(0).getPosition(), new Position(3, 4));
        assertEquals(space.getBetas().get(1).getPosition(), new Position(5, 4));
    }
    @Test
    void moveLnDown() throws IOException{
        betaController.setSide(0);
        betaController.setCountpositions(50);
        betaController.step(space1, GUI.ACTION.NONE, 1000);
        assertEquals(space.getBetas().get(0).getPosition(), new Position(1, 3));
        assertEquals(space.getBetas().get(1).getPosition(), new Position(3, 3));
        betaController.step(space1, GUI.ACTION.NONE, 1301);
        assertEquals(space.getBetas().get(0).getPosition(), new Position(1, 3));
        assertEquals(space.getBetas().get(1).getPosition(), new Position(3, 3));
        betaController.step(space1, GUI.ACTION.NONE, 1602);
        assertEquals(space.getBetas().get(0).getPosition(), new Position(1, 4));
        assertEquals(space.getBetas().get(1).getPosition(), new Position(3, 4));
    }
    @Test
    void createEnemyShot() throws IOException {
        betaController.createEnemyShot(0);
        assertEquals(space.getBetas().get(0).getPosition(),space.getEnemyShot().getPosition());
        assertTrue(space.getBetas().get(0).getIsShooting());
    }
    @Test
    void moveShotYFree(){
        space.setEnemyShot(new EnemyShot(5,5));
        betaController.moveShotY();
        assertEquals(space.getEnemyShot().getPosition(),new Position(5,6));
    }
    @Test
    void ShotColides(){
        space.setCeiGro(new ArrayList<>(Arrays.asList(new CeiGro(2,4))));
        space.setHero(new Hero(3,4));
        space.setBarriers(new ArrayList<>(Arrays.asList(new Barrier(4,4))));
        betaController.createEnemyShot(0);
        assertEquals(space.getBetas().get(0).getPosition(),space.getEnemyShot().getPosition());
        betaController.shotcolides(space.getBetas().get(0));
        assertFalse(space.getBetas().get(0).getIsShooting());
        space.getBetas().get(0).setPosition(new Position(3,3));
        betaController.createEnemyShot(0);
        assertEquals(space.getBetas().get(0).getPosition(),space.getEnemyShot().getPosition());
        betaController.shotcolides(space.getBetas().get(0));
        assertFalse(space.getBetas().get(0).getIsShooting());
        betaController.createEnemyShot(1);
        assertEquals(space.getBetas().get(1).getPosition(),space.getEnemyShot().getPosition());
        betaController.shotcolides(space.getBetas().get(1));
        assertFalse(space.getBetas().get(1).getIsShooting());
    }
}
