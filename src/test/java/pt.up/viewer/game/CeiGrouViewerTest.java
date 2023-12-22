package pt.up.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.gui.GUI;
import pt.up.model.game.elements.CeiGro;

import static org.mockito.Mockito.*;

class CeiGrouViewerTest {

    private CeiGrouViewer ceiGrouViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        ceiGrouViewer = new CeiGrouViewer();
        gui = mock(GUI.class);
    }

    @Test
    void testDraw() {
        CeiGro ceiGro = new CeiGro(3, 4);

        ceiGrouViewer.draw(ceiGro, gui);

        verify(gui, times(1)).drawCeiGro(eq(ceiGro.getPosition()));
    }

    @Test
    void testDrawWithNullElement() {

        CeiGro ceiGro = null;

        ceiGrouViewer.draw(ceiGro, gui);

        verify(gui, never()).drawCeiGro(any());
    }

    @Test
    void testDrawMultipleTimes() {

        CeiGro ceiGro1 = new CeiGro(1, 2);
        CeiGro ceiGro2 = new CeiGro(5, 6);

        ceiGrouViewer.draw(ceiGro1, gui);
        ceiGrouViewer.draw(ceiGro2, gui);

        verify(gui, times(1)).drawCeiGro(eq(ceiGro1.getPosition()));
        verify(gui, times(1)).drawCeiGro(eq(ceiGro2.getPosition()));
    }

    @Test
    void testDrawWithNullElementAndNullGUI() {
        CeiGro ceiGro = null;

        ceiGrouViewer.draw(ceiGro, null);
    }

    @Test
    void testDrawWithMultipleNullElements() {
        CeiGro ceiGro1 = null;
        CeiGro ceiGro2 = null;

        ceiGrouViewer.draw(ceiGro1, gui);
        ceiGrouViewer.draw(ceiGro2, gui);
    }

    @Test
    void testDrawWithNullElementAndNonNullGUI() {

        GUI gui = mock(GUI.class);

        ceiGrouViewer.draw(null, gui);
    }
}
