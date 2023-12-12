package pt.up.model.game.elements;

import pt.up.model.Model;
import pt.up.utils.Configuration;
import pt.up.utils.Music;
import pt.up.viewer.game.map.Map;
import pt.up.viewer.game.map.MapBuilder;
import pt.up.viewer.game.map.MapReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameModel implements Model {
    private Map map;
    Hero hero;
    boolean isRunning;
    boolean lost;
    Music music = Configuration.getInstance().getGameMusic();

    public GameModel(String mapName) throws IOException {
        MapBuilder mapBuilder = new MapReader();
        map = mapBuilder.createMap(mapName);
        hero = map.getHero();
    }

    public Map getMap() {
        return map;
    }

    public void update(long deltatime) {
        if (!music.isPlaying()) music.start();

        musicUpdate();
    }

    public void musicUpdate() {
        Music newMusic = Configuration.getInstance().getGameMusic();

        if (newMusic != music) {
            music.stop();
            music = newMusic;
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean hasLost() {
        return lost;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }
}