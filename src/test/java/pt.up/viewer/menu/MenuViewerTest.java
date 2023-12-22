package pt.up.viewer.menu;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pt.up.gui.GUI;
import pt.up.model.menu.MainMenu;

import static org.mockito.Mockito.*;

class MenuViewerTest {

    @Mock
    private GUI guiMock;

    private MenuViewer menuViewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        MainMenu mainMenu = new MainMenu();
        menuViewer = new MenuViewer(mainMenu);
    }

    @Test
    void testDrawTitle() {
        menuViewer.drawTitle(guiMock);

        verify(guiMock, times(5)).drawString(anyInt(), anyInt(), anyString(), any(TextColor.class), any(TextColor.class)); // Verify that the expected methods are invoked on the GUI mock
    }

    @Test
    void testDrawSubTitle() {
        menuViewer.drawSubTitle(guiMock);

        verify(guiMock, times(5)).drawString(anyInt(), anyInt(), anyString(), any(TextColor.class), any(TextColor.class)); // Verify that the expected methods are invoked on the GUI mock
    }

    @Test
    void testDrawOptions() {
        MainMenu mainMenuMock = mock(MainMenu.class);
        when(mainMenuMock.getNumberEntries()).thenReturn(4);
        when(mainMenuMock.getEntry(anyInt())).thenReturn("PLAY");

        MenuViewer menuViewerMock = new MenuViewer(mainMenuMock);
        menuViewerMock.drawOptions(guiMock);

        verify(guiMock, times(4)).drawText(any(), anyString(), any()); // Verify that the expected methods are invoked on the GUI mock
    }

    @Test
    void testDrawElements() {
        menuViewer.drawElements(guiMock);

        verify(guiMock, times(10)).drawString(anyInt(), anyInt(), anyString(), any(), any()); // Verify that the expected methods are invoked on the GUI mock
    }
}