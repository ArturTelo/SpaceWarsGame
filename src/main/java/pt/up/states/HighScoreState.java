package pt.up.states;

import pt.up.controller.HighScoreMenuController;
import pt.up.controller.Observer;
import pt.up.gui.LanGui;
import pt.up.model.Model;
import pt.up.model.menu.HighScoreMenuModel;
import pt.up.utils.Constants;
import pt.up.viewer.Viewer;
import pt.up.viewer.menu.HighScoresMenuViewer;

import java.io.IOException;

public class HighScoreState extends State {
    HighScoresMenuViewer highScoresViewer;
    final HighScoreMenuModel highScoreMenuModel;
    final HighScoreMenuController highScoreMenuController;
    LanGui gui;

    public HighScoreState() {
        super();
        highScoreMenuModel = new HighScoreMenuModel();
        highScoreMenuController = new HighScoreMenuController(highScoreMenuModel);
        gui = new LanGui();
    }

    @Override
    public void initScreen() {
        gui.createScreenMenu(Constants.MENU_SCREEN_WIDTH, Constants.MENU_SCREEN_HEIGHT);
        highScoresViewer = new HighScoresMenuViewer(highScoreMenuModel, gui.getScreen());
    }

    @Override
    public Viewer getViewer() {
        return highScoresViewer;
    }

    @Override
    public Observer getObserver() {
        return highScoreMenuController;
    }

    @Override
    public Model getModel() {
        return highScoreMenuModel;
    }

    @Override
    public boolean isRunning() {
        return highScoreMenuModel.isRunning();
    }

    @Override
    public void step() throws IOException {
        highScoresViewer.draw();
    }

    @Override
    public State nextState() {
        return new MenuState();
    }
}

