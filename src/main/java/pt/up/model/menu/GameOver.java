package pt.up.model.menu;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import pt.up.utils.Configuration;

public class GameOver {
    public GameOver() {
        if (!Configuration.getInstance().getMenuMusic().isPlaying()) {
            Configuration.getInstance().stopAllMusic();
            Configuration.getInstance().getMenuMusic().start();
        }
    }

    public static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 10;
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            randomString.append(randomChar);
        }

        return randomString.toString();
    }

    public void writeScore(String name, int score) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/assets/scores.txt", true);

            fileWriter.write(score + " " + name + "\n");

            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

