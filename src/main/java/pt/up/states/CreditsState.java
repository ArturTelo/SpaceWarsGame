package pt.up.states;

import pt.up.controller.CreditsMenuController;
import pt.up.controller.Observer;
import pt.up.gui.LanGui;
import pt.up.model.Model;
import pt.up.model.menu.CreditsMenuModel;
import pt.up.utils.Constants;
import pt.up.viewer.Viewer;
import pt.up.viewer.menu.CreditsMenuViewer;

import java.io.IOException;

public class CreditsState extends State {
    CreditsMenuViewer creditsMenuViewer;
    final CreditsMenuModel creditsMenuModel;
    final CreditsMenuController creditsMenuController;
    LanGui gui;

    public CreditsState() {
        super();
        creditsMenuModel = new CreditsMenuModel();
        creditsMenuController = new CreditsMenuController(creditsMenuModel);
        gui = new LanGui();
    }

    @Override
    public void initScreen() {
        gui.createScreenMenu(Constants.MENU_SCREEN_WIDTH, Constants.MENU_SCREEN_HEIGHT);
        creditsMenuViewer = new CreditsMenuViewer(creditsMenuModel, gui.getScreen());
    }

    @Override
    public Viewer getViewer() {
        return creditsMenuViewer;
    }

    @Override
    public Observer getObserver() {
        return creditsMenuController;
    }

    @Override
    public Model getModel() {
        return creditsMenuModel;
    }

    @Override
    public boolean isRunning() {
        return creditsMenuModel.isRunning();
    }

    @Override
    public void step() throws IOException {
        creditsMenuViewer.draw();
    }

    @Override
    public State nextState() {
        return new MenuState();
    }
}

