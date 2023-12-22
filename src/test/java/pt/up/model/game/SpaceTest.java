package pt.up.model.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.Space;
import pt.up.model.game.space.SpaceLoader;

import java.io.IOException;

public class SpaceTest {
    private SpaceLoader spaceLoader;

    @BeforeEach
    public void createSpace() throws IOException {
        spaceLoader = new SpaceLoader();
    }

    @Test
    public void testWidth(){
        int width = spaceLoader.createSpace().getWidth();

        Assertions.assertEquals(80,width);
    }
    @Test
    public void testHeight(){
        int width = spaceLoader.createSpace().getHeight();

        Assertions.assertEquals(33,width);
    }
}
