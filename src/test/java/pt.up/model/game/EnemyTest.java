package pt.up.model.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.model.game.elements.enemy.Enemy;

public class EnemyTest {

    @Test
    public void checkScore(){
        Enemy enemy = new Enemy(1,1);
        enemy.setPoints(10);
        enemy.setPoints(25);
        int enemyPoints = enemy.getPoints();

        Assertions.assertEquals(25, enemyPoints);
    }
}
