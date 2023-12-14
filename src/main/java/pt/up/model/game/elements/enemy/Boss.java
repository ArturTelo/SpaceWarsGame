package pt.up.model.game.elements.enemy;
import java.util.Random;
public class Boss extends Enemy {
    public Boss(int x, int y) {
        super(x, y);
        health=1;
        Random random = new Random();
        points = (random.nextInt(16) + 5) * 10;
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
