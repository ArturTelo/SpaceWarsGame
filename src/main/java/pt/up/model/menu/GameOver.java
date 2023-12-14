package pt.up.model.menu;

import pt.up.utils.Configuration;

public class GameOver {
    public GameOver() {
        if (!Configuration.getInstance().getMenuMusic().isPlaying()) {
            Configuration.getInstance().stopAllMusic();
            Configuration.getInstance().getMenuMusic().start();
        }
    }
}

