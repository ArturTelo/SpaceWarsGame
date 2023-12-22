package pt.up.model.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.model.Position;
import pt.up.model.game.elements.*;
import pt.up.model.game.elements.enemy.*;
import pt.up.model.game.space.SpaceLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpaceTest {
    private List<Barrier> barriers;

    private SpaceLoader space;

    @BeforeEach
    public void createSpace() throws IOException {
        space = new SpaceLoader();
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(space.createSpace().isEmpty(new Position(5, 5)));
    }

    @Test
    public void testIsOccupied() {
        Assertions.assertFalse(space.createSpace().isEmpty(new Position(0, 1)));
    }

    @Test
    public void notCollideAlphas() {
        Assertions.assertFalse(space.createSpace().collideAlphas(new Position(0, 1)));
    }
    @Test
    public void CollideAlphas() {
        Assertions.assertTrue(space.createSpace().collideAlphas(new Position(1, 11)));
    }

    @Test
    public void notCollideBetas() {
        Assertions.assertFalse(space.createSpace().collideBetas(new Position(0, 1)));
    }
    @Test
    public void CollideBetas() {
        Assertions.assertTrue(space.createSpace().collideBetas(new Position(1, 10)));
    }

    @Test
    public void notCollideGammas() {
        Assertions.assertFalse(space.createSpace().collideGammas(new Position(0, 1)));
    }
    @Test
    public void CollideGammas() {
        Assertions.assertTrue(space.createSpace().collideGammas(new Position(1, 9)));
    }

    @Test
    public void notCollideDeltas() {
        Assertions.assertFalse(space.createSpace().collideDeltas(new Position(0, 1)));
    }
    @Test
    public void CollideDeltas() {
        Assertions.assertTrue(space.createSpace().collideDeltas(new Position(1, 8)));
    }

    @Test
    public void notCollideHero() {
        Assertions.assertFalse(space.createSpace().collideHero(new Position(0, 1)));
    }
    @Test
    public void CollideHero() {
        Assertions.assertTrue(space.createSpace().collideHero(new Position(40, 30)));
    }

    @Test
    public void notCollideBoss() {
        Assertions.assertFalse(space.createSpace().collideBoss(new Position(0, 1)));
    }
    @Test
    public void CollideBoss() {
        Assertions.assertTrue(space.createSpace().collideBoss(new Position(1, 5)));
    }

    @Test
    public void notCollideBarrier() {
        Assertions.assertFalse(space.createSpace().collideBarriers(new Position(0, 1)));
    }
    @Test
    public void CollideBarrier() {
        Assertions.assertTrue(space.createSpace().collideBarriers(new Position(10, 20)));
    }


}
