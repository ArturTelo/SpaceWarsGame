package pt.up.controller.Menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.controller.menu.CreditsMenuController;
import pt.up.controller.menu.HighScoresMenuController;
import pt.up.gui.GUI;
import pt.up.model.menu.CreditsMenu;
import pt.up.model.menu.HighScoresMenu;
import pt.up.states.MainMenuState;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

public class CreditsMenuControlerTest {
    CreditsMenu creditsMenu;
    CreditsMenuController creditsControler;

    @BeforeEach
    void setUp(){
        creditsMenu = new CreditsMenu();
        creditsControler = new CreditsMenuController(creditsMenu);
    }
    @Test
    void stepESC() throws IOException {

        pt.up.Space spaceMock = Mockito.mock(pt.up.Space.class);
        creditsControler.step(spaceMock, GUI.ACTION.ESC, 0);
        verify(spaceMock).setState(argThat(argument -> argument instanceof MainMenuState));
    }
}
