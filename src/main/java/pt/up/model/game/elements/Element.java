package pt.up.model.game.elements;

import pt.up.model.Position;

public class Element {
    private Position position;


    //Values to change in the future accordingly to the screen ratio
    private static int maxY = 500;
    private static int maxX = 1000;

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void moveUp() {
        if (position.getY() > 1)
            this.position = new Position(position.getX(), position.getY() - 1);
    }

    public void moveDown() {
        if (position.getY() < maxY - 1)
            this.position = new Position(position.getX(), position.getY() + 1);
    }

    public void moveRight() {
        if (position.getY() < maxX - 1)
            this.position = new Position(position.getX() + 1, position.getY());
    }

    public void moveLeft() {
        if (position.getY() > 1)
            this.position = new Position(position.getX() - 1, position.getY());
    }
}
