package pt.up.viewer.game;

import org.junit.jupiter.api.Test;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.Boss;

import static org.mockito.Mockito.*;

class BossViewerTest {

    @Test
    void drawBossShouldInvokeDrawBossWithCorrectPosition() {
        GUI gui = mock(GUI.class);

        BossViewer bossViewer = new BossViewer();

        int bossPositionX = 5;
        int bossPositionY = 10;
        Boss boss = new Boss(bossPositionX, bossPositionY);

        bossViewer.draw(boss, gui);

        verify(gui, times(1)).drawBoss(new Position(bossPositionX, bossPositionY)); // Verify that drawBoss method of GUI is invoked with the correct position
    }
}
