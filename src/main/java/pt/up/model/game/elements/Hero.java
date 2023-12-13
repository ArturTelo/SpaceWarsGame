package pt.up.model.game.elements;

public class Hero extends Element {
    private int health;
    private int coins;
    private int score;

    public Hero(int x, int y) {
        super(x, y);
        this.health = 3;
    }
    public int getScore(){return score;}

    public void reduceHeroHealth() {
        health--;
    }

    public void incrementHeroHealth() {
        health++;
    }

    public int getHeroHealth() {
        return health;
    }

    public int getHeroCoins() {
        return coins;
    }

    public void incrementHeroCoins() {
        coins++;
    }

}
