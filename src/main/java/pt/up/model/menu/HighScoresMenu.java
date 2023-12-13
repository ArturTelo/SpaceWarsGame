package pt.up.model.menu;

import pt.up.utils.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HighScoresMenu {

    private final List<Player> playersScores;

    public HighScoresMenu() {
        if (!Configuration.getInstance().getMenuMusic().isPlaying()) {
            Configuration.getInstance().stopAllMusic();
            Configuration.getInstance().getMenuMusic().start();
        }

        playersScores = new ArrayList<>();
    }

    public void readScores(){
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/assets/scores.txt"));
            while (scanner.hasNextLine()){
                String input = scanner.nextLine();

                String[] parts = input.split(" ");

                int score = Integer.parseInt(parts[0]);
                String name = parts[1];

                Player player = new Player(score, name);
                playersScores.add(player);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Player> getTopPlayers(int numberOfPlayers) {
        playersScores.sort(Comparator.comparingInt(Player::getScore).reversed());
        return playersScores.subList(0, Math.min(numberOfPlayers, playersScores.size()));
    }
}
