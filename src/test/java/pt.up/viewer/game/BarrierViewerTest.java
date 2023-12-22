package pt.up.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.Barrier;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

class BarrierViewerTest {


    private BarrierViewer barrierViewer;
    private GUI mockGui;
    private Barrier barrier;

    @BeforeEach
    void setUp() {
        barrierViewer = new BarrierViewer();
        mockGui = Mockito.mock(GUI.class);
        barrier = new Barrier(0, 0);
    }

    @Test
    void drawBarrierShouldCallDrawBarrierOnGui() {

        barrierViewer.draw(barrier, mockGui);

        verify(mockGui, times(1)).drawBarrier(any()); // Verify that drawBarrier was called exactly once with any argument
    }

    @Test
    void drawBarrierShouldHandleNullElement() {

        assertDoesNotThrow(() -> barrierViewer.draw(null, mockGui));
        verify(mockGui, never()).drawBarrier(any()); // Verify that drawBarrier was never called
    }

    @Test
    void drawBarrierShouldDrawAtCorrectPosition() {
        Position expectedPosition = new Position(0, 0);

        barrierViewer.draw(barrier, mockGui);

        verify(mockGui, times(1)).drawBarrier(argThat(position -> position.equals(expectedPosition)));
    }

    @Test
    void drawBarrierShouldNotDrawIfResistanceIsZero() {

        barrier.reduceresistance();

        barrierViewer.draw(barrier, mockGui);

        verify(mockGui, never()).drawBarrier(any()); // Verify that drawBarrier was never called
    }

    @Test
    void drawBarrierShouldDrawIfResistanceIsPositive() {

        barrierViewer.draw(barrier, mockGui);

        verify(mockGui, times(1)).drawBarrier(any()); // Verify that drawBarrier was called exactly once
    }
}
