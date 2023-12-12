package pt.up.states;

import pt.up.controller.MenuController;
import pt.up.controller.Observer;
import pt.up.gui.LanGui;
import pt.up.model.Model;
import pt.up.model.menu.MenuModel;
import pt.up.utils.Configuration;
import pt.up.utils.Constants;
import pt.up.utils.Music;
import pt.up.viewer.Viewer;
import pt.up.viewer.menu.MainMenuViewer;

import java.io.IOException;

import static java.lang.System.exit;

public class MenuState extends State {
    private MainMenuViewer viewMainMenu;
    private final MenuController menuController;
    private final MenuModel mainMenuModel;
    LanGui gui;
    Music music;

    public MenuState() {
        super();
        mainMenuModel = new MenuModel();
        menuController = new MenuController(mainMenuModel);
        gui = new LanGui();
        music = Configuration.getInstance().getMenuMusic();
    }

    @Override
    public void initScreen() {
        gui.createScreenMenu(Constants.MENU_SCREEN_WIDTH, Constants.MENU_SCREEN_HEIGHT);
        viewMainMenu = new MainMenuViewer(mainMenuModel, gui.getScreen());
    }

    @Override
    public Viewer getViewer() {
        return viewMainMenu;
    }

    @Override
    public Observer getObserver() {
        return menuController;
    }

    @Override
    public Model getModel() {
        return mainMenuModel;
    }

    @Override
    public boolean isRunning() {
        return mainMenuModel.isRunning();
    }

    @Override
    public void step() throws IOException {
        viewMainMenu.draw();
        if (!music.isPlaying())
            music.start();
    }

    @Override
    public State nextState() throws IOException {
        switch (mainMenuModel.getSelected()) {
            case "PLAY":
                return new GameState();
            case "HIGHSCORES":
                return new HighScoreState();
            case "CREDITS":
                return new CreditsState();
            case "EXIT":
                exit(0);
                break;
        }

        return null;
    }
}
