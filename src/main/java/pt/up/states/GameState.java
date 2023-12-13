package pt.up.states;

import pt.up.controller.Controller;
import pt.up.controller.game.SpaceController;
import pt.up.model.game.space.Space;
import pt.up.viewer.Viewer;
import pt.up.viewer.game.GameViewer;

public class GameState extends State<Space> {
    public GameState(Space arena) {
        super(arena);
    }

    @Override
    protected Viewer<Space> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Space> getController() {
        return new SpaceController(getModel());
    }
}

