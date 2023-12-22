package pt.up.model.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.model.Position;
import pt.up.model.game.elements.Element;

public class ElementTest {
    private Element element;

    @BeforeEach
    public void createElement(){
        element = new Element(10,10);
    }

    @Test
    public void checkPosition(){
        element.setPosition(new Position(4,5));
        element.setPosition(new Position(8,8));

        Position elementPosition = element.getPosition();
        Assertions.assertEquals(new Position(8,8),elementPosition);
    }
}
