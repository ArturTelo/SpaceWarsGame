package pt.up.model.game.elements.enemy;

import pt.up.model.game.elements.Element;

public class Enemy extends Element {
    public Enemy(int x, int y) {
        super(x, y);
    }

    public int health;
    public int points;

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
    private boolean isShooting = false;
    public boolean getIsShooting(){
        return this.isShooting;
    }

    public void createShot(){
        this.isShooting = true;
    }

    public void delShot(){
        this.isShooting = false;
    }
}
