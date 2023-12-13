package pt.up.controller.menu;

import pt.up.Space;
import pt.up.controller.Controller;
import pt.up.gui.GUI;
import pt.up.model.menu.HighScoresMenu;
import pt.up.model.menu.MainMenu;
import pt.up.states.MainMenuState;

import java.io.IOException;

public class HighScoresMenuController extends Controller<HighScoresMenu> {
    public HighScoresMenuController(HighScoresMenu highScoresMenu) {
        super(highScoresMenu);
    }

    @Override
    public void step(Space space, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case ESC:
                space.setState(new MainMenuState(new MainMenu()));
                break;
        }
    }
}
