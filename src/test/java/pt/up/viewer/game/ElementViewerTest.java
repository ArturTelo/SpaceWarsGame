package pt.up.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.gui.GUI;
import pt.up.model.game.elements.Element;

import static org.mockito.Mockito.*;

class ElementViewerTest {

    private ElementViewer<Element> elementViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        elementViewer = new MockElementViewer();
        gui = mock(GUI.class);
    }

    @Test
    void testDraw() {

        Element element = new Element(3, 4);

        elementViewer.draw(element, gui);

        verify(gui, times(1)).drawDelta(eq(element.getPosition()));
    }

    @Test
    void testDrawWithNullElement() {

        Element element = null;

        elementViewer.draw(element, gui);

        verify(gui, never()).drawDelta(any());
    }

    // Mock ElementViewer implementation for testing
    private static class MockElementViewer implements ElementViewer<Element> {
        @Override
        public void draw(Element element, GUI gui) {
            if (element != null) {
                gui.drawDelta(element.getPosition());
            }
        }
    }
}
