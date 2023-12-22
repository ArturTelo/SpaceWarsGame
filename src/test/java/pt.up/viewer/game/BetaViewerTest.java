package pt.up.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.Beta;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

class BetaViewerTest {

    private BetaViewer betaViewer;
    private GUI mockGui;
    private Beta beta;

    @BeforeEach
    void setUp() {
        betaViewer = new BetaViewer();
        mockGui = Mockito.mock(GUI.class);
        beta = new Beta(0, 0);
    }

    @Test
    void drawBetaShouldCallDrawBetaOnGui() {
        betaViewer.draw(beta, mockGui);

        verify(mockGui, times(1)).drawBeta(any()); // Verify that drawBeta was called exactly once with any argument
    }

    @Test
    void drawBetaShouldHandleNullElement() {
        assertDoesNotThrow(() -> betaViewer.draw(null, mockGui));
        verify(mockGui, never()).drawBeta(any()); // Verify that drawBeta was never called
    }

    @Test
    void drawBetaShouldDrawAtCorrectPosition() {

        Beta beta = new Beta(1, 2);
        Position expectedPosition = new Position(1, 2);

        betaViewer.draw(beta, mockGui);

        verify(mockGui, times(1)).drawBeta(argThat(position -> position.equals(expectedPosition)));
    }
}
