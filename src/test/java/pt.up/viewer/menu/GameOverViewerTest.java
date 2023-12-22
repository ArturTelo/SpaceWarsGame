package pt.up.viewer.menu;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pt.up.gui.GUI;
import pt.up.model.menu.GameOver;

import static org.mockito.Mockito.*;

class GameOverViewerTest {

    @Mock
    private GUI guiMock;

    private GameOverViewer gameOverViewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        GameOver gameOver = new GameOver();
        gameOverViewer = new GameOverViewer(gameOver);
    }

    @Test
    void testDrawGameOver() {
        gameOverViewer.drawGameOver(guiMock);

        // Verify that the expected methods are invoked on the GUI mock
        verify(guiMock, times(1)).drawString(eq(20), eq(9), anyString(), any(TextColor.class), eq(TextColor.ANSI.CYAN));
    }

    @Test
    void testDrawElements() {
        gameOverViewer.drawElements(guiMock);

        // Verify that the expected methods are invoked on the GUI mock
        verify(guiMock, times(1)).drawString(eq(20), eq(9), anyString(), any(TextColor.class), eq(TextColor.ANSI.CYAN));
    }
}
