package pt.up.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.model.Position;
import pt.up.model.game.elements.Barrier;
import pt.up.model.game.elements.CeiGro;
import pt.up.model.game.elements.Hero;
import pt.up.model.game.elements.Wall;
import pt.up.model.game.elements.enemy.Alpha;
import pt.up.controller.game.AlphaController;
import pt.up.model.game.elements.enemy.EnemyShot;
import pt.up.model.game.space.Space;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pt.up.gui.GUI;

import static org.junit.jupiter.api.Assertions.*;


public class AlphaControlerTest {

    private Space space;
    private AlphaController alphaController;

    private pt.up.Space space1;
    @BeforeEach
    void setUp() {
        space = new Space(10,10);
        space.setAlphas(new ArrayList<>(Arrays.asList(new Alpha(2,3),new Alpha(4,3))));
        space.setWalls(new ArrayList<>(Arrays.asList(new Wall(0,3),new Wall(6,3))));
        space.setCeiGro(new ArrayList<>(Arrays.asList(new CeiGro(5,0), new CeiGro(5,10))));
        alphaController = new AlphaController(space);
        space1= Mockito.mock(pt.up.Space.class);
    }

    @Test
    void changedirection() {
        alphaController.setSide(1);
        alphaController.changed=true;
        alphaController.chagedirection();
        assertEquals(alphaController.getSide(),0);
        assertFalse(alphaController.getChanged());
        alphaController.setSide(1);
        alphaController.changed=false;
        alphaController.chagedirection();
        assertEquals(alphaController.getSide(),1);
        assertFalse(alphaController.getChanged());
        alphaController.setSide(0);
        alphaController.changed=true;
        alphaController.chagedirection();
        assertEquals(alphaController.getSide(),1);
        assertFalse(alphaController.getChanged());
        alphaController.setSide(0);
        alphaController.changed=false;
        alphaController.chagedirection();
        assertEquals(alphaController.getSide(),0);
        assertFalse(alphaController.getChanged());
    }
    @Test
    void moveRight() throws IOException {
        alphaController.setSide(1);
        alphaController.setCountpositions(49);
        alphaController.step(space1,GUI.ACTION.NONE,1000);
        assertEquals(space.getAlphas().get(0).getPosition(),new Position(3,3));
        assertEquals(space.getAlphas().get(1).getPosition(),new Position(5,3));
    }
    @Test
    void moveLeft() throws IOException {
        alphaController.setSide(0);
        alphaController.setCountpositions(49);
        alphaController.step(space1,GUI.ACTION.NONE,1000);
        assertEquals(space.getAlphas().get(0).getPosition(),new Position(1,3));
        assertEquals(space.getAlphas().get(1).getPosition(),new Position(3,3));
    }
    @Test
    void moveRnDown() throws IOException {
        alphaController.setSide(1);
        alphaController.setCountpositions(50);
        alphaController.step(space1,GUI.ACTION.NONE,1000);
        assertEquals(space.getAlphas().get(0).getPosition(),new Position(3,3));
        assertEquals(space.getAlphas().get(1).getPosition(),new Position(5,3));
        alphaController.step(space1,GUI.ACTION.NONE,1301);
        assertEquals(space.getAlphas().get(0).getPosition(),new Position(3,3));
        assertEquals(space.getAlphas().get(1).getPosition(),new Position(5,3));
        alphaController.step(space1,GUI.ACTION.NONE,1602);
        assertEquals(space.getAlphas().get(0).getPosition(),new Position(3,4));
        assertEquals(space.getAlphas().get(1).getPosition(),new Position(5,4));
    }
    @Test
    void moveLnDown() throws IOException{
        alphaController.setSide(0);
        alphaController.setCountpositions(50);
        alphaController.step(space1,GUI.ACTION.NONE,1000);
        assertEquals(space.getAlphas().get(0).getPosition(),new Position(1,3));
        assertEquals(space.getAlphas().get(1).getPosition(),new Position(3,3));
        alphaController.step(space1,GUI.ACTION.NONE,1301);
        assertEquals(space.getAlphas().get(0).getPosition(),new Position(1,3));
        assertEquals(space.getAlphas().get(1).getPosition(),new Position(3,3));
        alphaController.step(space1,GUI.ACTION.NONE,1602);
        assertEquals(space.getAlphas().get(0).getPosition(),new Position(1,4));
        assertEquals(space.getAlphas().get(1).getPosition(),new Position(3,4));
    }

    @Test
    void createEnemShot() throws IOException {
        alphaController.createEnemyShot(0);
        assertEquals(space.getAlphas().get(0).getPosition(),space.getEnemyShot().getPosition());
        assertTrue(space.getAlphas().get(0).getIsShooting());
    }
    @Test
    void moveShotYFree(){
        space.setEnemyShot(new EnemyShot(5,5));
        alphaController.moveShotY();
        assertEquals(space.getEnemyShot().getPosition(),new Position(5,6));
    }
    @Test
    void ShotColides(){
        space.setCeiGro(new ArrayList<>(Arrays.asList(new CeiGro(2,4))));
        space.setHero(new Hero(3,4));
        space.setBarriers(new ArrayList<>(Arrays.asList(new Barrier(4,4))));
        alphaController.createEnemyShot(0);
        assertEquals(space.getAlphas().get(0).getPosition(),space.getEnemyShot().getPosition());
        alphaController.shotcolides(space.getAlphas().get(0));
        assertFalse(space.getAlphas().get(0).getIsShooting());
        space.getAlphas().get(0).setPosition(new Position(3,3));
        alphaController.createEnemyShot(0);
        assertEquals(space.getAlphas().get(0).getPosition(),space.getEnemyShot().getPosition());
        alphaController.shotcolides(space.getAlphas().get(0));
        assertFalse(space.getAlphas().get(0).getIsShooting());
        alphaController.createEnemyShot(1);
        assertEquals(space.getAlphas().get(1).getPosition(),space.getEnemyShot().getPosition());
        alphaController.shotcolides(space.getAlphas().get(1));
        assertFalse(space.getAlphas().get(1).getIsShooting());
    }
}
