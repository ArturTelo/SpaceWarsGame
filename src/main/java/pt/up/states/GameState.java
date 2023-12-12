package pt.up.states;

import pt.up.controller.Observer;
import pt.up.controller.PlayerController;
import pt.up.gui.LanGui;
import pt.up.model.Model;
import pt.up.model.game.elements.GameModel;
import pt.up.utils.Configuration;
import pt.up.utils.Constants;
import pt.up.utils.Music;
import pt.up.viewer.Viewer;
import pt.up.viewer.game.GameViewer;

import java.io.IOException;

public class GameState extends State {
    private GameViewer gameViewer;
    private GameModel gameModel;
    private PlayerController playerController;
    LanGui gui;
    Music music;

    public void initializing() throws IOException {
        gameModel = new GameModel("map.txt");
        playerController = new PlayerController(gameModel.getMap().getHero(), gameModel);
        gui = new LanGui();
        Configuration.getInstance().stopAllMusic();
        music = Configuration.getInstance().getGameMusic();
    }

    public GameState() throws IOException {
        super();
        initializing();
    }

    @Override
    public void initScreen() {
        gui.createScreenGame(Constants.GAME_SCREEN_WIDTH, Constants.GAME_SCREEN_HEIGHT);
        gameViewer = new GameViewer(gameModel, gui.getScreen());
    }

    @Override
    public Viewer getViewer() {
        return gameViewer;
    }

    @Override
    public Observer getObserver() {
        return playerController;
    }

    @Override
    public Model getModel() {
        return gameModel;
    }

    @Override
    public boolean isRunning() {
        return true;
    }

    @Override
    public void step() throws IOException {
        if (!music.isPlaying()) {
            music.start();
        }
        gameViewer.draw();
    }

    @Override
    public State nextState() throws IOException {
        return null;
    }
}
