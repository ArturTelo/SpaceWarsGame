package pt.up.controller.Menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.controller.menu.HighScoresMenuController;
import pt.up.controller.menu.MainMenuController;
import pt.up.gui.GUI;
import pt.up.model.menu.HighScoresMenu;
import pt.up.model.menu.MainMenu;
import pt.up.states.GameState;
import pt.up.states.MainMenuState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

public class HighScoresControlerTest {
    HighScoresMenu highScoresMenu;
    HighScoresMenuController highScoresControler;

    @BeforeEach
    void setUp(){
        highScoresMenu = new HighScoresMenu();
        highScoresControler = new HighScoresMenuController(highScoresMenu);
    }
    @Test
    void stepESC() throws IOException {

        pt.up.Space spaceMock = Mockito.mock(pt.up.Space.class);
        highScoresControler.step(spaceMock, GUI.ACTION.ESC, 0);
        verify(spaceMock).setState(argThat(argument -> argument instanceof MainMenuState));
    }
    }
