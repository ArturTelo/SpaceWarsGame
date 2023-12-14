package pt.up.controller.menu;

import pt.up.Space;
import pt.up.controller.Controller;
import pt.up.gui.GUI;
import pt.up.model.menu.GameOver;
import pt.up.model.menu.MainMenu;
import pt.up.states.MainMenuState;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver model){
        super(model);
    }
    @Override
    public void step(Space space, GUI.ACTION action, long time) throws IOException {
        if(action== GUI.ACTION.ESC){
            space.setState(new MainMenuState(new MainMenu()));
        }
    }
}
