package pt.up;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pt.up.Space;
import pt.up.gui.LanternaGUI;
import pt.up.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class SpaceTest {/*

    @Mock
    private LanternaGUI guiMock;

    @Mock
    private State stateMock;

    @InjectMocks
    private Space space;

    @BeforeEach
    public void setUp() throws FontFormatException, IOException, URISyntaxException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSpaceStart() throws IOException {
        // Mocking behavior for guiMock.close()
        doNothing().when(guiMock).close();

        // Mocking behavior for stateMock.step()
        doNothing().when(stateMock).step(any(Space.class), any(LanternaGUI.class), anyLong());

        // Call the start method
        space.start();

        // Verify interactions
        verify(stateMock, atLeastOnce()).step(eq(space), eq(guiMock), anyLong());
        verify(guiMock).close();
        verifyZeroInteractions(System.class); // Ensure that System.exit() is not called directly
    }*/
}
