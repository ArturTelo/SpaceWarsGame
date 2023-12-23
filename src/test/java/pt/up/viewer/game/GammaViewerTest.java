package pt.up.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.Gamma;

import static org.mockito.Mockito.*;

class GammaViewerTest {

    private GammaViewer gammaViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        gammaViewer = new GammaViewer();
        gui = mock(GUI.class);
    }

    @Test
    void testDraw() {
        Gamma gamma = new Gamma(1, 1);
        gammaViewer.draw(gamma, gui);

        verify(gui, times(1)).drawGamma(new Position(1, 1)); // Verify that the drawGamma method is called with the correct position
    }
}
