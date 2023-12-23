package pt.up.controller.Menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.controller.game.GammaController;
import pt.up.controller.menu.MainMenuController;
import pt.up.gui.GUI;
import pt.up.model.game.elements.CeiGro;
import pt.up.model.game.elements.Wall;
import pt.up.model.game.elements.enemy.Gamma;
import pt.up.model.game.space.Space;
import pt.up.model.menu.MainMenu;
import pt.up.states.CreditsMenuState;
import pt.up.states.GameState;
import pt.up.states.HighScoresMenuState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

public class MainMenuControlerTest {
    MainMenu mainMenu;
    MainMenuController mainMenuController;
    pt.up.Space space1;
    Space space;

    @BeforeEach
    void setUp(){
        space= new Space(10,10);
        mainMenu = new MainMenu();
        mainMenuController = new MainMenuController(mainMenu);
        mainMenu.entries= new ArrayList<>(Arrays.asList("Play","Okay","Exit"));
        space1= Mockito.mock(pt.up.Space.class);

    }

    @Test
    void stepUP() throws IOException {
        mainMenuController.step(space1, GUI.ACTION.UP, 0);
        assertEquals(mainMenuController.getModel().currentEntry,2);
        mainMenu.currentEntry=1;
        mainMenuController.step(space1, GUI.ACTION.UP, 0);
        assertEquals(mainMenuController.getModel().currentEntry,0);
    }
    @Test
    void stepDOWN() throws IOException {
        mainMenuController.step(space1, GUI.ACTION.DOWN, 0);
        assertEquals(mainMenuController.getModel().currentEntry,1);
        mainMenu.currentEntry=2;
        mainMenuController.step(space1, GUI.ACTION.DOWN, 0);
        assertEquals(mainMenuController.getModel().currentEntry,0);
    }
    @Test
    void stepSELECTGame() throws IOException {

        pt.up.Space spaceMock = Mockito.mock(pt.up.Space.class);
        MainMenu mainMenu = new MainMenu();
        MainMenuController mainMenuController = new MainMenuController(mainMenu);
        mainMenu.entries = new ArrayList<>(Arrays.asList("Play", "HighScores", "Credits", "Exit"));

        mainMenuController.step(spaceMock, GUI.ACTION.SELECT, 0);
        verify(spaceMock).setState(argThat(argument -> argument instanceof GameState));

        /*mainMenuController.step(spaceMock, GUI.ACTION.SELECT, 0);
        verify(spaceMock).setState(argThat(argument -> argument instanceof CreditsMenuState));
        mainMenuController.step(spaceMock, GUI.ACTION.SELECT, 0);
        verify(spaceMock).setState(argThat(argument -> argument == null));*/

    }
    @Test
    void stepSELECTHighScores() throws IOException {

        pt.up.Space spaceMock = Mockito.mock(pt.up.Space.class);
        MainMenu mainMenu = new MainMenu();
        MainMenuController mainMenuController = new MainMenuController(mainMenu);
        mainMenu.entries = new ArrayList<>(Arrays.asList("Play", "HighScores", "Credits", "Exit"));
        mainMenu.currentEntry=1;
        mainMenuController.step(spaceMock, GUI.ACTION.SELECT, 0);
        verify(spaceMock).setState(argThat(argument -> argument instanceof HighScoresMenuState));

    }
    @Test
    void stepSELECTCredits() throws IOException {

        pt.up.Space spaceMock = Mockito.mock(pt.up.Space.class);
        MainMenu mainMenu = new MainMenu();
        MainMenuController mainMenuController = new MainMenuController(mainMenu);
        mainMenu.entries = new ArrayList<>(Arrays.asList("Play", "HighScores", "Credits", "Exit"));
        mainMenu.currentEntry=2;
        mainMenuController.step(spaceMock, GUI.ACTION.SELECT, 0);
        verify(spaceMock).setState(argThat(argument -> argument instanceof CreditsMenuState));
    }
    @Test
    void stepSELECTExit() throws IOException {

        pt.up.Space spaceMock = Mockito.mock(pt.up.Space.class);
        MainMenu mainMenu = new MainMenu();
        MainMenuController mainMenuController = new MainMenuController(mainMenu);
        mainMenu.entries = new ArrayList<>(Arrays.asList("Play", "HighScores", "Credits", "Exit"));
        mainMenu.currentEntry=3;
        mainMenuController.step(spaceMock, GUI.ACTION.SELECT, 0);
        verify(spaceMock).setState(argThat(argument -> argument == null));
    }
}
