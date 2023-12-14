package pt.up.states;

import pt.up.controller.Controller;
import pt.up.controller.menu.GameOverController;
import pt.up.model.menu.GameOver;
import pt.up.viewer.Viewer;
import pt.up.viewer.menu.GameOverViewer;

public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController((getModel()));
    }
}
