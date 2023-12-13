package pt.up.model.menu;

public class Player {
    private int score;
    private String name;

    public Player(int score, String name){
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
