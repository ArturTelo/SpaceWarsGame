package pt.up.model.game.elements;

public class Hero extends Element {
    private int health = 3;
    private int coins;
    private int score;

    private boolean isShooting = false;

    public Hero(int x, int y) {
        super(x, y);
    }

    public int getScore() {
        return score;
    }

    public void incrementHeroScore(int enemyPoints) {
        score += enemyPoints;
    }

    public void reduceHeroHealth(int po) {
        health -= po;
    }

    public void incrementHeroHealth() {
        health++;
    }

    public void setHeroHealth(int health) {
        this.health = health;
    }

    public boolean getIsShooting() {
        return this.isShooting;
    }

    public void createShot() {
        this.isShooting = true;
    }

    public void delShot() {
        this.isShooting = false;
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
