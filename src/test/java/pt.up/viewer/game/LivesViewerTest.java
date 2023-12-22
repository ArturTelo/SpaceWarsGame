package pt.up.viewer.game;

import org.junit.jupiter.api.Test;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.Lives;

import static org.mockito.Mockito.*;

class LivesViewerTest {

    @Test
    void testDraw() {
        GUI gui = mock(GUI.class);
        LivesViewer livesViewer = new LivesViewer();
        Lives lives = new Lives(2, 2);

        livesViewer.draw(lives, gui);

        verify(gui, times(1)).drawLive(new Position(2, 2));
    }

    @Test
    void testDrawWithDifferentPosition() {
        GUI gui = mock(GUI.class);
        LivesViewer livesViewer = new LivesViewer();
        Lives lives = new Lives(5, 5);

        livesViewer.draw(lives, gui);

        verify(gui, times(1)).drawLive(new Position(5, 5));
    }

    @Test
    void testDrawWithNegativePosition() {
        GUI gui = mock(GUI.class);
        LivesViewer livesViewer = new LivesViewer();
        Lives lives = new Lives(-1, -1);

        livesViewer.draw(lives, gui);

        verify(gui, times(1)).drawLive(new Position(-1, -1));
    }

    @Test
    void testDrawWithZeroPosition() {
        GUI gui = mock(GUI.class);
        LivesViewer livesViewer = new LivesViewer();
        Lives lives = new Lives(0, 0);

        livesViewer.draw(lives, gui);

        verify(gui, times(1)).drawLive(new Position(0, 0));
    }

    @Test
    void testDrawWithMockGUI() {
        GUI gui = mock(GUI.class);
        LivesViewer livesViewer = new LivesViewer();
        Lives lives = new Lives(3, 3);

        livesViewer.draw(lives, gui);

        verify(gui, times(1)).drawLive(new Position(3, 3)); // Verify that the drawLive method is called with the correct position on the mock GUI
    }
}
