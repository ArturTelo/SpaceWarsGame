package pt.up.model.game.elements.enemy;

public class Gamma extends Enemy {
    private int health;
    public Gamma(int x, int y) {
        super(x,y);
        health=1;
        points=25;
    }


}
