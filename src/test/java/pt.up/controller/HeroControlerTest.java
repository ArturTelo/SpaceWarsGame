package pt.up.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.controller.game.HeroController;
import pt.up.model.Position;
import pt.up.model.game.elements.Barrier;
import pt.up.model.game.elements.HeroShot;
import pt.up.model.game.elements.Wall;
import pt.up.model.game.elements.enemy.*;
import pt.up.model.game.space.Space;
import pt.up.model.game.elements.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HeroControlerTest {
    //Make testes for the HeroController
    Space space;
    HeroController heroController;
    Hero hero;

    @BeforeEach
    void setUp() {
        space = new Space(10, 10);
        space.setWalls(Arrays.asList((new Wall(0, 1))));
        hero = new Hero(5, 5);
        space.setHero(hero);
        heroController = new HeroController(space);
    }

    @Test
    void moveHeroRightFree() {
        heroController.moveHeroRight();
        assertEquals(new Position(6, 5), hero.getPosition());
    }

    @Test
    void moveHeroRightNotFree() {
        space.setWalls(Arrays.asList(new Wall(6, 5)));
        heroController.moveHeroRight();
        assertEquals(new Position(5, 5), hero.getPosition());
    }

    @Test
    void moveHeroLeftFree() {
        heroController.moveHeroLeft();
        assertEquals(new Position(4, 5), hero.getPosition());
    }

    @Test
    void moveHeroLeftNotFree() {
        space.setWalls(Arrays.asList(new Wall(4, 5)));
        heroController.moveHeroLeft();
        assertEquals(new Position(5, 5), hero.getPosition());
    }

    @Test
    void createHeroShoot() {
        heroController.createHeroShoot();
        assertEquals(new Position(5, 5), space.getHeroShot().getPosition());

    }

    @Test
    void moveHeroShootY() {
        heroController.createHeroShoot();
        heroController.moveHeroShootY();
        assertEquals(new Position(5, 4), space.getHeroShot().getPosition());
    }

    @Test
    void moveHeroShootYNotFree() {
        space.setWalls(Arrays.asList(new Wall(5, 4)));
        heroController.createHeroShoot();
        heroController.moveHeroShootY();
        assertEquals(new Position(5, 5), space.getHeroShot().getPosition());
    }
    @Test
    void shotcolides() {
        space.setBarriers(Arrays.asList(new Barrier(5, 4)));
        space.setBoss(new Boss(0,1));
        heroController.createHeroShoot();
        heroController.moveHeroShootY();
        heroController.shotcolides(space.getHeroShot().getPosition());
        assertTrue(space.getBarriers().isEmpty());
        assertFalse(space.getHero().getIsShooting());
    }
}