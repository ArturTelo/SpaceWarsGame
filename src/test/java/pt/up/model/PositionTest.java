package pt.up.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.model.Position;

public class PositionTest {
    private Position position;

    @BeforeEach
    public void createPosition(){
        position = new Position(5,5);
    }

    @Test
    public void checkRight(){
        Position pos = position.getRight();

        Assertions.assertEquals(6,pos.getX());
    }

    @Test
    public void checkDown(){
        Position pos = position.getDown();

        Assertions.assertEquals(6,pos.getY());
    }

    @Test
    public void checkUp(){
        Position pos = position.getUp();

        Assertions.assertEquals(4,pos.getY());
    }

    @Test
    public void checkLeft(){
        Position pos = position.getLeft();

        Assertions.assertEquals(4,pos.getX());
    }

    @Test
    public void checkEquals(){
        Position pos = position.getRight();
        Position pos1 = pos.getUp();

        boolean bool = pos1.equals(new Position(6,4));

        Assertions.assertTrue(bool);
    }
}
