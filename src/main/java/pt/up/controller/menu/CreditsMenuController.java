package pt.up.controller.menu;

import pt.up.Space;
import pt.up.controller.Controller;
import pt.up.gui.GUI;
import pt.up.model.menu.CreditsMenu;
import pt.up.model.menu.MainMenu;
import pt.up.states.MainMenuState;

import java.io.IOException;

public class CreditsMenuController extends Controller<CreditsMenu> {
    public CreditsMenuController(CreditsMenu creditsMenu) {
        super(creditsMenu);
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
