package pt.up.states;

import pt.up.controller.Controller;
import pt.up.controller.menu.HighScoresMenuController;
import pt.up.model.menu.HighScoresMenu;
import pt.up.viewer.Viewer;
import pt.up.viewer.menu.HighScoresViewer;

public class HighScoresMenuState extends State<HighScoresMenu> {
    public HighScoresMenuState(HighScoresMenu model) {
        super(model);
    }

    @Override
    protected Viewer<HighScoresMenu> getViewer() {
        return new HighScoresViewer(getModel());
    }

    @Override
    protected Controller<HighScoresMenu> getController() {
        return new HighScoresMenuController(getModel());
    }
}
