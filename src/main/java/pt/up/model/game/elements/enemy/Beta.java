package pt.up.model.game.elements.enemy;

public class Beta extends Enemy {

    public Beta(int x, int y) {
        super(x, y);
        health=1;
        points=15;
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
