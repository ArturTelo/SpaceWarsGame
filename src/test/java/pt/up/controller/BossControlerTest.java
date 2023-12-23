package pt.up.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.controller.game.BetaController;
import pt.up.controller.game.BossController;
import pt.up.controller.game.GammaController;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.Barrier;
import pt.up.model.game.elements.CeiGro;
import pt.up.model.game.elements.Hero;
import pt.up.model.game.elements.Wall;
import pt.up.model.game.elements.enemy.*;
import pt.up.model.game.space.Space;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BossControlerTest {
    private Space space;
    private BossController Controller;
    private pt.up.Space space1;

    @BeforeEach
    void setUp(){
        space = new Space(10,10);
        space.setBoss(new Boss(2,3));
        space.setWalls(new ArrayList<>(Arrays.asList(new Wall(0,3),new Wall(10,3))));
        space.setCeiGro(new ArrayList<>(Arrays.asList(new CeiGro(5,0), new CeiGro(5,10))));
        Controller = new BossController(space);
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
        Controller.setCountpositions(74);
        Controller.step(space1, GUI.ACTION.NONE,1000);
        assertEquals(space.getBoss().getPosition(),new Position(3,3));
    }
    @Test
    void moveLeft() throws IOException {
        Controller.setSide(0);
        Controller.setCountpositions(74);
        Controller.step(space1,GUI.ACTION.NONE,1000);
        assertEquals(space.getBoss().getPosition(),new Position(1,3));
    }


    @Test
    void createEnemShot() throws IOException {
        Controller.createBossShot();
        assertEquals(space.getBoss().getPosition(),space.getBossShot().getPosition());
        assertTrue(space.getBoss().getIsShooting());
    }
    @Test
    void moveShotYFree(){
        space.setBossShot(new BossShot(5,5));
        Controller.moveBossShotY();
        assertEquals(space.getBossShot().getPosition(),new Position(5,6));
    }
    @Test
    void ShotColides(){
        space.setCeiGro(new ArrayList<>(Arrays.asList(new CeiGro(2,4))));
        space.setHero(new Hero(3,4));
        space.setBarriers(new ArrayList<>(Arrays.asList(new Barrier(4,4))));
        Controller.createBossShot();
        assertEquals(space.getBoss().getPosition(),space.getBossShot().getPosition());
        Controller.shotcolides(space.getBoss());
        assertFalse(space.getBoss().getIsShooting());
        space.getBoss().setPosition(new Position(3,3));
        Controller.createBossShot();
        assertEquals(space.getBoss().getPosition(),space.getBossShot().getPosition());
        Controller.shotcolides(space.getBoss());
        assertFalse(space.getBoss().getIsShooting());
        space.getBoss().setPosition(new Position(4,3));
        Controller.createBossShot();
        assertEquals(space.getBoss().getPosition(),space.getBossShot().getPosition());
        Controller.shotcolides(space.getBoss());
        assertFalse(space.getBoss().getIsShooting());
    }
}
