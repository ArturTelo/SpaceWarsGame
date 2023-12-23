package pt.up.model.game.elements.enemy;
import java.util.Random;
public class Boss extends Enemy {
    public boolean alive = true;
    public Boss(int x, int y) {
        super(x, y);
        health=1;
        Random random = new Random();
        points = (random.nextInt(16) + 5) * 10;

    }
    public boolean alive() {
        return this.alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
