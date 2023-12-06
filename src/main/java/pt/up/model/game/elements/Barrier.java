package pt.up.model.game.elements;

public class Barrier extends Element {
    private int health = 15;

    public Barrier(int x, int y) {
        super(x, y);
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth() {
        health--;
    }
}
