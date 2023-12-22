package pt.up.model.game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.model.game.elements.Hero;

public class HeroTest {
    private Hero hero;

    @BeforeEach
    public void createHero(){
        hero = new Hero(10,10);
    }

    @Test
    public void decreaseHealth(){
        hero.reduceHeroHealth(1);
        hero.reduceHeroHealth(1);
        int heroHealth = hero.getHeroHealth();

        Assertions.assertEquals(1,heroHealth);
    }
    @Test
    public void incrementPoints(){
        hero.incrementHeroScore(50);
        hero.incrementHeroScore(30);
        hero.incrementHeroScore(10);
        int heroPoints = hero.getScore();

        Assertions.assertEquals(90,heroPoints);
    }
    @Test
    public void checkIsShooting(){
        hero.createShot();
        boolean heroShooting = hero.getIsShooting();

        Assertions.assertTrue(heroShooting);
    }
    @Test
    public void checkShotDeleted(){
        hero.delShot();
        boolean heroShooting = hero.getIsShooting();

        Assertions.assertFalse(heroShooting);
    }
}
