package pt.up.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.gui.GUI;
import pt.up.model.game.elements.enemy.Delta;

import static org.mockito.Mockito.*;

class DeltaViewerTest {

    private DeltaViewer deltaViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        deltaViewer = new DeltaViewer();
        gui = mock(GUI.class);
    }

    @Test
    void testDraw() {

        Delta delta = new Delta(3, 4);

        deltaViewer.draw(delta, gui);

        verify(gui, times(1)).drawDelta(eq(delta.getPosition()));
    }

    @Test
    void testDrawWithNullElement() {

        Delta delta = null;

        deltaViewer.draw(delta, gui);

        verify(gui, never()).drawDelta(any());
    }

    @Test
    void testDrawMultipleTimes() {

        Delta delta1 = new Delta(1, 2);
        Delta delta2 = new Delta(5, 6);

        deltaViewer.draw(delta1, gui);
        deltaViewer.draw(delta2, gui);

        verify(gui, times(1)).drawDelta(eq(delta1.getPosition()));
        verify(gui, times(1)).drawDelta(eq(delta2.getPosition()));
    }

    @Test
    void testDrawWithNullElementAndNullGUI() {

        Delta delta = null;

        deltaViewer.draw(delta, null);

    }

    @Test
    void testDrawWithMultipleNullElements() {

        Delta delta1 = null;
        Delta delta2 = null;

        deltaViewer.draw(delta1, gui);
        deltaViewer.draw(delta2, gui);
    }

    @Test
    void testDrawWithNullElementAndNonNullGUI() {

        GUI gui = mock(GUI.class);

        deltaViewer.draw(null, gui);
    }
}
