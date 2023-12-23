package pt.up.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.controller.game.GammaController;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.Barrier;
import pt.up.model.game.elements.CeiGro;
import pt.up.model.game.elements.Hero;
import pt.up.model.game.elements.Wall;
import pt.up.model.game.elements.enemy.EnemyShot;
import pt.up.model.game.elements.enemy.Gamma;
import pt.up.model.game.space.Space;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GammaControlerTest {
    private Space space;
    private GammaController Controller;

    private pt.up.Space space1;
    @BeforeEach
    void setUp(){
        space = new Space(10,10);
        space.setGammas(new ArrayList<>(Arrays.asList(new Gamma(2,3),new Gamma(4,3))));
        space.setWalls(new ArrayList<>(Arrays.asList(new Wall(0,3),new Wall(6,3))));
        space.setCeiGro(new ArrayList<>(Arrays.asList(new CeiGro(5,0), new CeiGro(5,10))));
        Controller = new GammaController(space);
        space1= Mockito.mock(pt.up.Space.class);
    }

    @Test
    void changedirection() {
        Controller.setSide(1);
        Controller.changed=true;
        Controller.chagedirection();
        assertEquals(Controller.getSide(),0);
        assertFalse(Controller.getChanged());
        Controller.setSide(1);
        Controller.changed=false;
        Controller.chagedirection();
        assertEquals(Controller.getSide(),1);
        assertFalse(Controller.getChanged());
        Controller.setSide(0);
        Controller.changed=true;
        Controller.chagedirection();
        assertEquals(Controller.getSide(),1);
        assertFalse(Controller.getChanged());
        Controller.setSide(0);
        Controller.changed=false;
        Controller.chagedirection();
        assertEquals(Controller.getSide(),0);
        assertFalse(Controller.getChanged());
    }
    @Test
    void moveRight() throws IOException {
        Controller.setSide(1);
        Controller.setCountpositions(49);
        Controller.step(space1, GUI.ACTION.NONE,1000);
        assertEquals(space.getGammas().get(0).getPosition(),new Position(3,3));
        assertEquals(space.getGammas().get(1).getPosition(),new Position(5,3));
    }
    @Test
    void moveLeft() throws IOException {
        Controller.setSide(0);
        Controller.setCountpositions(49);
        Controller.step(space1,GUI.ACTION.NONE,1000);
        assertEquals(space.getGammas().get(0).getPosition(),new Position(1,3));
        assertEquals(space.getGammas().get(1).getPosition(),new Position(3,3));
    }
    @Test
    void moveRnDown() throws IOException {
        Controller.setSide(1);
        Controller.setCountpositions(50);
        Controller.step(space1,GUI.ACTION.NONE,1000);
        assertEquals(space.getGammas().get(0).getPosition(),new Position(3,3));
        assertEquals(space.getGammas().get(1).getPosition(),new Position(5,3));
        Controller.step(space1,GUI.ACTION.NONE,1301);
        assertEquals(space.getGammas().get(0).getPosition(),new Position(3,3));
        assertEquals(space.getGammas().get(1).getPosition(),new Position(5,3));
        Controller.step(space1,GUI.ACTION.NONE,1602);
        assertEquals(space.getGammas().get(0).getPosition(),new Position(3,4));
        assertEquals(space.getGammas().get(1).getPosition(),new Position(5,4));
    }
    @Test
    void moveLnDown() throws IOException{
        Controller.setSide(0);
        Controller.setCountpositions(50);
        Controller.step(space1,GUI.ACTION.NONE,1000);
        assertEquals(space.getGammas().get(0).getPosition(),new Position(1,3));
        assertEquals(space.getGammas().get(1).getPosition(),new Position(3,3));
        Controller.step(space1,GUI.ACTION.NONE,1301);
        assertEquals(space.getGammas().get(0).getPosition(),new Position(1,3));
        assertEquals(space.getGammas().get(1).getPosition(),new Position(3,3));
        Controller.step(space1,GUI.ACTION.NONE,1602);
        assertEquals(space.getGammas().get(0).getPosition(),new Position(1,4));
        assertEquals(space.getGammas().get(1).getPosition(),new Position(3,4));
    }

    @Test
    void createEnemShot() throws IOException {
        Controller.createEnemyShot(0);
        assertEquals(space.getGammas().get(0).getPosition(),space.getEnemyShot().getPosition());
        assertTrue(space.getGammas().get(0).getIsShooting());
    }
    @Test
    void moveShotYFree(){
        space.setEnemyShot(new EnemyShot(5,5));
        Controller.moveShotY();
        assertEquals(space.getEnemyShot().getPosition(),new Position(5,6));
    }
    @Test
    void ShotColides(){
        space.setCeiGro(new ArrayList<>(Arrays.asList(new CeiGro(2,4))));
        space.setHero(new Hero(3,4));
        space.setBarriers(new ArrayList<>(Arrays.asList(new Barrier(4,4))));
        Controller.createEnemyShot(0);
        assertEquals(space.getGammas().get(0).getPosition(),space.getEnemyShot().getPosition());
        Controller.shotcolides(space.getGammas().get(0));
        assertFalse(space.getGammas().get(0).getIsShooting());
        space.getGammas().get(0).setPosition(new Position(3,3));
        Controller.createEnemyShot(0);
        assertEquals(space.getGammas().get(0).getPosition(),space.getEnemyShot().getPosition());
        Controller.shotcolides(space.getGammas().get(0));
        assertFalse(space.getGammas().get(0).getIsShooting());
        Controller.createEnemyShot(1);
        assertEquals(space.getGammas().get(1).getPosition(),space.getEnemyShot().getPosition());
        Controller.shotcolides(space.getGammas().get(1));
        assertFalse(space.getGammas().get(1).getIsShooting());
    }
}
