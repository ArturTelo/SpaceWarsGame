package pt.up.controller.menu;

import pt.up.Space;
import pt.up.controller.Controller;
import pt.up.gui.GUI;
import pt.up.model.game.space.SpaceLoader;
import pt.up.model.menu.CreditsMenu;
import pt.up.model.menu.GameOver;
import pt.up.model.menu.HighScoresMenu;
import pt.up.model.menu.MainMenu;
import pt.up.states.CreditsMenuState;
import pt.up.states.GameOverState;
import pt.up.states.GameState;
import pt.up.states.HighScoresMenuState;

import java.io.IOException;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void step(Space space, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedPlay()) {
                    space.setState(new GameState(new SpaceLoader().createSpace()));
                }
                if (getModel().isSelectedHighScore()) {
                    space.setState(new HighScoresMenuState(new HighScoresMenu()));
                }
                if (getModel().isSelectedCredits()) {
                    space.setState(new CreditsMenuState(new CreditsMenu()));
                }
                if (getModel().isSelectedExit()) {
                    space.setState(null);
                }
        }
    }
}
