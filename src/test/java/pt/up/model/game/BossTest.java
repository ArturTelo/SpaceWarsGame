package pt.up.model.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.model.game.elements.enemy.Boss;

public class BossTest {

    private Boss boss;

    @BeforeEach
    public void createBoss(){
        boss = new Boss(10,10);
    }

    @Test
    public void checkIsShooting(){
        boss.createShot();
        boolean bossShooting = boss.getIsShooting();

        Assertions.assertTrue(bossShooting);
    }
    @Test
    public void checkShotDeleted(){
        boss.delShot();
        boolean bossShooting = boss.getIsShooting();

        Assertions.assertFalse(bossShooting);
    }
}
