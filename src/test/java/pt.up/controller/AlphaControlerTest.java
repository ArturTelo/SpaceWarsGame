package pt.up.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.model.Position;
import pt.up.model.game.elements.Wall;
import pt.up.model.game.elements.enemy.Alpha;
import pt.up.controller.game.AlphaController;
import pt.up.model.game.space.Space;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pt.up.gui.GUI;

import static org.junit.jupiter.api.Assertions.*;


public class AlphaControlerTest {

    private Space space;
    private List<Alpha> alphas;
    private AlphaController alphaController;

    private pt.up.Space space1;
    @BeforeEach
    void setUp() {
        space = new Space(10,10);
        space.setAlphas(new ArrayList<>(Arrays.asList(new Alpha(2,3),new Alpha(4,3))));
        space.setWalls(new ArrayList<>(Arrays.asList(new Wall(0,3),new Wall(6,3))));
        alphaController = new AlphaController(space);
        space1= Mockito.mock(pt.up.Space.class);
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

}
