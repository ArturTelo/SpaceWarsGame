package pt.up.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.controller.game.DeltaController;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.Barrier;
import pt.up.model.game.elements.CeiGro;
import pt.up.model.game.elements.Hero;
import pt.up.model.game.elements.Wall;
import pt.up.model.game.elements.enemy.Delta;
import pt.up.model.game.elements.enemy.EnemyShot;
import pt.up.model.game.space.Space;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DeltaControllerTest {
    private Space space;
    private DeltaController deltaController;

    private pt.up.Space space1;
    @BeforeEach
    void setUp(){
        space = new Space(10,10);
        space.setDeltas(new ArrayList<>(Arrays.asList(new Delta(2,3),new Delta(4,3))));
        space.setWalls(new ArrayList<>(Arrays.asList(new Wall(0,3),new Wall(6,3))));
        space.setCeiGro(new ArrayList<>(Arrays.asList(new CeiGro(5,0), new CeiGro(5,10))));
        deltaController = new DeltaController(space);
        space1= Mockito.mock(pt.up.Space.class);
    }

    @Test
    void changedirection() {
        deltaController.setSide(1);
        deltaController.changed=true;
        deltaController.chagedirection();
        assertEquals(deltaController.getSide(),0);
        assertFalse(deltaController.getChanged());
        deltaController.setSide(1);
        deltaController.changed=false;
        deltaController.chagedirection();
        assertEquals(deltaController.getSide(),1);
        assertFalse(deltaController.getChanged());
        deltaController.setSide(0);
        deltaController.changed=true;
        deltaController.chagedirection();
        assertEquals(deltaController.getSide(),1);
        assertFalse(deltaController.getChanged());
        deltaController.setSide(0);
        deltaController.changed=false;
        deltaController.chagedirection();
        assertEquals(deltaController.getSide(),0);
        assertFalse(deltaController.getChanged());
    }
    @Test
    void moveRight() throws IOException {
        deltaController.setSide(1);
        deltaController.setCountpositions(49);
        deltaController.step(space1, GUI.ACTION.NONE,1000);
        assertEquals(space.getDeltas().get(0).getPosition(),new Position(3,3));
        assertEquals(space.getDeltas().get(1).getPosition(),new Position(5,3));
    }
    @Test
    void moveLeft() throws IOException {
        deltaController.setSide(0);
        deltaController.setCountpositions(49);
        deltaController.step(space1,GUI.ACTION.NONE,1000);
        assertEquals(space.getDeltas().get(0).getPosition(),new Position(1,3));
        assertEquals(space.getDeltas().get(1).getPosition(),new Position(3,3));
    }
    @Test
    void moveRnDown() throws IOException {
        deltaController.setSide(1);
        deltaController.setCountpositions(50);
        deltaController.step(space1,GUI.ACTION.NONE,1000);
        assertEquals(space.getDeltas().get(0).getPosition(),new Position(3,3));
        assertEquals(space.getDeltas().get(1).getPosition(),new Position(5,3));
        deltaController.step(space1,GUI.ACTION.NONE,1301);
        assertEquals(space.getDeltas().get(0).getPosition(),new Position(3,3));
        assertEquals(space.getDeltas().get(1).getPosition(),new Position(5,3));
        deltaController.step(space1,GUI.ACTION.NONE,1602);
        assertEquals(space.getDeltas().get(0).getPosition(),new Position(3,4));
        assertEquals(space.getDeltas().get(1).getPosition(),new Position(5,4));
    }
    @Test
    void moveLnDown() throws IOException{
        deltaController.setSide(0);
        deltaController.setCountpositions(50);
        deltaController.step(space1,GUI.ACTION.NONE,1000);
        assertEquals(space.getDeltas().get(0).getPosition(),new Position(1,3));
        assertEquals(space.getDeltas().get(1).getPosition(),new Position(3,3));
        deltaController.step(space1,GUI.ACTION.NONE,1301);
        assertEquals(space.getDeltas().get(0).getPosition(),new Position(1,3));
        assertEquals(space.getDeltas().get(1).getPosition(),new Position(3,3));
        deltaController.step(space1,GUI.ACTION.NONE,1602);
        assertEquals(space.getDeltas().get(0).getPosition(),new Position(1,4));
        assertEquals(space.getDeltas().get(1).getPosition(),new Position(3,4));
    }

    @Test
    void createEnemShot() throws IOException {
        deltaController.createEnemyShot(0);
        assertEquals(space.getDeltas().get(0).getPosition(),space.getEnemyShot().getPosition());
        assertTrue(space.getDeltas().get(0).getIsShooting());
    }
    @Test
    void moveShotYFree(){
        space.setEnemyShot(new EnemyShot(5,5));
        deltaController.moveShotY();
        assertEquals(space.getEnemyShot().getPosition(),new Position(5,6));
    }
    @Test
    void ShotColides(){
        space.setCeiGro(new ArrayList<>(Arrays.asList(new CeiGro(2,4))));
        space.setHero(new Hero(3,4));
        space.setBarriers(new ArrayList<>(Arrays.asList(new Barrier(4,4))));
        deltaController.createEnemyShot(0);
        assertEquals(space.getDeltas().get(0).getPosition(),space.getEnemyShot().getPosition());
        deltaController.shotcolides(space.getDeltas().get(0));
        assertFalse(space.getDeltas().get(0).getIsShooting());
        space.getDeltas().get(0).setPosition(new Position(3,3));
        deltaController.createEnemyShot(0);
        assertEquals(space.getDeltas().get(0).getPosition(),space.getEnemyShot().getPosition());
        deltaController.shotcolides(space.getDeltas().get(0));
        assertFalse(space.getDeltas().get(0).getIsShooting());
        deltaController.createEnemyShot(1);
        assertEquals(space.getDeltas().get(1).getPosition(),space.getEnemyShot().getPosition());
        deltaController.shotcolides(space.getDeltas().get(1));
        assertFalse(space.getDeltas().get(1).getIsShooting());
    }
}

