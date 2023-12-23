package pt.up.viewer.menu;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pt.up.gui.GUI;
import pt.up.model.menu.CreditsMenu;

import static org.mockito.Mockito.*;

class CreditsViewerTest {

    @Mock
    private GUI guiMock;

    private CreditsViewer creditsViewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        CreditsMenu creditsMenu = new CreditsMenu();
        creditsViewer = new CreditsViewer(creditsMenu);
    }

    @Test
    void testDrawTitle() {
        creditsViewer.drawTitle(guiMock);

        // Verify that the expected methods are invoked on the GUI mock
        verify(guiMock, times(1)).drawString(eq(12), eq(4), anyString(), any(TextColor.class), eq(TextColor.ANSI.CYAN));
    }

    @Test
    void testDrawSubTitle() {
        creditsViewer.drawSubTitle(guiMock);

        // Verify that the expected methods are invoked on the GUI mock
        verify(guiMock, times(1)).drawString(eq(12), eq(9), anyString(), any(TextColor.class), eq(TextColor.ANSI.CYAN));
    }

    @Test
    void testDrawDescription() {
        creditsViewer.drawDescription(guiMock);

        // Verify that the expected methods are invoked on the GUI mock
        verify(guiMock, times(1)).drawString(eq(30), eq(20), anyString(), any(TextColor.class), eq(TextColor.ANSI.CYAN));
    }

    @Test
    void testDrawElements() {
        creditsViewer.drawElements(guiMock);

        // Verify that the expected methods are invoked on the GUI mock
        verify(guiMock, times(1)).drawString(eq(12), eq(4), anyString(), any(TextColor.class), eq(TextColor.ANSI.CYAN));

        verify(guiMock, times(1)).drawString(eq(12), eq(9), anyString(), any(TextColor.class), eq(TextColor.ANSI.CYAN));
        verify(guiMock, times(1)).drawString(eq(30), eq(20), anyString(), any(TextColor.class), eq(TextColor.ANSI.CYAN));
    }
}
