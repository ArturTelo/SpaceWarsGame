package pt.up.model.menu;

import pt.up.model.Model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HighScoreMenuModel extends MenuModel implements Model {
    private boolean running;
    private final List<Player> playersScores;

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

    public HighScoreMenuModel() {
        running = true;
        playersScores = new ArrayList<>();
    }

    @Override
    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
