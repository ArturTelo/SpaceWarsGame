package pt.up.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.model.menu.Player;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void createPlayer(){
        player = new Player(1000, "playerName");
    }

    @Test
    void testName(){
        String playerName = player.getName();

        Assertions.assertEquals("playerName",playerName);
    }

    @Test
    void testScore(){
        int playerScore = player.getScore();

        Assertions.assertEquals(1000,playerScore);
    }


}
