package pt.up.model.menu;

import pt.up.utils.Configuration;

public class CreditsMenu {

    public CreditsMenu() {
        if (!Configuration.getInstance().getMenuMusic().isPlaying()) {
            Configuration.getInstance().stopAllMusic();
            Configuration.getInstance().getMenuMusic().start();
        }
    }
}
