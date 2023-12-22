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
    void setUp2() {
        space = new Space(10, 10);
        space.setWalls(new ArrayList<>(Arrays.asList((new Wall(0, 1)))));
        space.setBetas(new ArrayList<>(Arrays.asList(new Beta(2, 4))));
        space.setGammas(new ArrayList<>(Arrays.asList(new Gamma(3, 4))));
        space.setAlphas(new ArrayList<>(Arrays.asList(new Alpha(4, 4))));
        space.setBarriers(new ArrayList<>(Arrays.asList(new Barrier(5, 4))));
        space.setBoss(new Boss(6,4));
        space.setDeltas(new ArrayList<>(Arrays.asList(new Delta(7, 4))));
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
    void shotcolidesBarriers() {
        heroController.createHeroShoot();
        heroController.moveHeroShootY();
        heroController.shotcolides(space.getHeroShot().getPosition());
        assertTrue(space.getBarriers().isEmpty());
        assertFalse(space.getHero().getIsShooting());
    }
    @Test
    void shotcolidesAlphas() {
        hero.setPosition(new Position(4,5));
        heroController.createHeroShoot();
        heroController.moveHeroShootY();
        heroController.shotcolides(space.getHeroShot().getPosition());
        assertTrue(space.getAlphas().isEmpty());
        assertFalse(space.getHero().getIsShooting());
    }
    @Test
    void shotcolidesBetas(){
        hero.setPosition(new Position(2,5));
        heroController.createHeroShoot();
        heroController.moveHeroShootY();
        heroController.shotcolides(space.getHeroShot().getPosition());
        assertTrue(space.getBetas().isEmpty());
        assertFalse(space.getHero().getIsShooting());
    }
    @Test
    void shotcolidesGammas(){
        hero.setPosition(new Position(3,5));
        heroController.createHeroShoot();
        heroController.moveHeroShootY();
        heroController.shotcolides(space.getHeroShot().getPosition());
        assertTrue(space.getGammas().isEmpty());
        assertFalse(space.getHero().getIsShooting());
    }
    @Test
    void shotcolidesDeltas(){
        hero.setPosition(new Position(7,5));
        heroController.createHeroShoot();
        heroController.moveHeroShootY();
        heroController.shotcolides(space.getHeroShot().getPosition());
        assertTrue(space.getDeltas().isEmpty());
        assertFalse(space.getHero().getIsShooting());
    }
    @Test
    void shotcolidesBoss(){
        hero.setPosition(new Position(6,5));
        heroController.createHeroShoot();
        heroController.moveHeroShootY();
        heroController.shotcolides(space.getHeroShot().getPosition());
        assertEquals(new Position(999,999), space.getBoss().getPosition());
        assertFalse(space.getHero().getIsShooting());
    }
    @Test
void shotcolidesNothing(){
        hero.setPosition(new Position(8,5));
        heroController.createHeroShoot();
        heroController.moveHeroShootY();
        heroController.shotcolides(space.getHeroShot().getPosition());
        assertEquals(new Position(8,4), space.getHeroShot().getPosition());
        assertTrue(space.getHero().getIsShooting());
    }

}