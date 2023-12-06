package pt.up.model.game.elements.enemy;

import pt.up.model.game.elements.Element;

public class Enemy extends Element {
    public Enemy(int x, int y) {
        super(x, y);
    }

    private int health;
    private int points;

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getHealth() {
        return health;
    }

    public int getPoints() {
        return points;
    }
}
