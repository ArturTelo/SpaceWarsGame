package pt.up.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.model.menu.GameOver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameOverTest {

    @Test
    public void testGenerateRandomString() {
        String randomString = GameOver.generateRandomString();

        Assertions.assertNotNull(randomString);
        Assertions.assertEquals(10, randomString.length());
    }

    @Test
    public void testWriteScore() throws IOException {
        GameOver gameOver = new GameOver();
        String testName = "TestPlayer";
        int testScore = 100;

        gameOver.writeScore(testName, testScore);

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/assets/scores.txt"))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals(testScore + " " + testName)) {
                    found = true;
                    break;
                }
            }
            Assertions.assertTrue(found);
        }
    }
}