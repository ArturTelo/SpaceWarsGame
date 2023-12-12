package pt.up.viewer.game;

import com.googlecode.lanterna.gui2.Direction;
import pt.up.model.Position;

import java.util.Map;

public class MovingElement extends Element {
    private Map map;
    private Direction currentDirection;
    private Position beginPosition;
    private double velocityX, velocityY;


    public MovingElement(Position position, int width, int height) {
        super(position, width, height);
        setVelocity(0.0, 0.0);
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    public void setVelocity(double velocityX, double velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void setBeginPositionPosition(Position position) {
        beginPosition = position;
    }

    public Position getBeginPosition() {
        return beginPosition;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }
}
