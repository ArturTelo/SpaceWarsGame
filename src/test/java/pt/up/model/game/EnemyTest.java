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

    @Test
    public void testIsShootingDefault() {
        Enemy enemy = new Enemy(0, 0);

        Assertions.assertFalse(enemy.getIsShooting());
    }



    @Test
    public void checkIsShooting(){
        Enemy enemy = new Enemy(1,1);

        enemy.createShot();
        boolean bossShooting = enemy.getIsShooting();

        Assertions.assertTrue(bossShooting);
    }
    @Test
    public void checkShotDeleted(){
        Enemy enemy = new Enemy(1,1);

        enemy.delShot();
        boolean bossShooting = enemy.getIsShooting();

        Assertions.assertFalse(bossShooting);
    }
}
