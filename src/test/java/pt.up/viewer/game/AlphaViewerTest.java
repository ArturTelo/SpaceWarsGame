package pt.up.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.gui.GUI;
import pt.up.model.game.elements.enemy.Alpha;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AlphaViewerTest {

    private AlphaViewer alphaViewer;
    private GUI mockGui;
    private Alpha alpha;

    @BeforeEach
    void setUp() {
        alphaViewer = new AlphaViewer();
        mockGui = Mockito.mock(GUI.class);
        alpha = new Alpha(0, 0); // Pass appropriate x and y values for testing
    }

    @Test
    void drawAlphaShouldCallDrawAlphaOnGui() {
        // Arrange

        // Act
        alphaViewer.draw(alpha, mockGui);

        // Assert
        verify(mockGui, times(1)).drawAlpha(any()); // Verify that drawAlpha was called exactly once with any argument
    }

    @Test
    void drawAlphaShouldHandleNullElement() {
        // Arrange

        // Act & Assert
        assertDoesNotThrow(() -> alphaViewer.draw(null, mockGui));
        verify(mockGui, never()).drawAlpha(any()); // Verify that drawAlpha was never called
    }

    @Test
    void drawAlphaShouldSetCorrectHealthAndPoints() {
        // Arrange

        // Act
        alphaViewer.draw(alpha, mockGui);

        // Assert
        assertEquals(1, alpha.getHealth());
        assertEquals(10, alpha.getPoints());
    }
}
