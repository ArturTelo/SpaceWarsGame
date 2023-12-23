package pt.up.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.BossShot;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class BossShotViewerTest {

    private BossShotViewer bossShotViewer;
    private GUI mockGui;
    private BossShot bossShot;

    @BeforeEach
    void setUp() {
        bossShotViewer = new BossShotViewer();
        mockGui = Mockito.mock(GUI.class);
        bossShot = new BossShot(1, 2);
    }

    @Test
    void drawBossShotShouldCallDrawBossShotOnGui() {
        bossShotViewer.draw(bossShot, mockGui);

        verify(mockGui, times(1)).drawBossShot(new Position(1, 2));
    }

    @Test
    void drawBossShotShouldHandleNullElement() {

        bossShot = null;
        bossShotViewer.draw(bossShot, mockGui);
        verify(mockGui, times(0)).drawBossShot(Mockito.any()); // Verify that drawBossShot was not called
    }
}
