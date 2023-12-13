package pt.up.controller.menu;

import pt.up.Space;
import pt.up.controller.Controller;
import pt.up.gui.GUI;
import pt.up.model.game.space.SpaceLoader;
import pt.up.model.menu.MainMenu;
import pt.up.states.GameState;

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
                if (getModel().isSelectedExit()) space.setState(null);
                if (getModel().isSelectedPlay()) space.setState(new GameState(new SpaceLoader().createSpace()));

        }
    }
}
