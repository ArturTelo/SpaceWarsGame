package pt.up.utils;

public class Configuration {
    private static Configuration config;

    Music menuMusic, gameMusic;

    private Configuration() {
        menuMusic = new Music("MenuSound.wav");
        gameMusic = new Music("GameSound.wav");
    }

    public void stopAllMusic() {
        menuMusic.stop();
        gameMusic.stop();
    }

    public Music getMenuMusic() {
        return menuMusic;
    }

    public Music getGameMusic() {
        return gameMusic;
    }

    public static Configuration getInstance() {
        if (config == null)
            config = new Configuration();
        return config;
    }
}
