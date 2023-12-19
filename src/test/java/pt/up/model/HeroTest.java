package pt.up.model;
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
    public void decresa(){
        hero.reduceHeroHealth(1);
        int heroHealth = hero.getHeroHealth();

        Assertions.assertEquals(2,heroHealth);
    }
}
