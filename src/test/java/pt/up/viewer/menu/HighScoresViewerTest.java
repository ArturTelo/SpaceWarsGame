package pt.up.viewer.menu;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pt.up.gui.GUI;
import pt.up.model.menu.HighScoresMenu;
import pt.up.model.menu.Player;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class HighScoresViewerTest {

    @Mock
    private GUI guiMock;

    private HighScoresViewer highScoresViewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        HighScoresMenu highScoresMenu = new HighScoresMenu();
        highScoresViewer = new HighScoresViewer(highScoresMenu);
    }

    @Test
    void testDrawTitle() {
        highScoresViewer.drawTitle(guiMock);

        // Verify that the expected methods are invoked on the GUI mock
        verify(guiMock, times(1)).drawString(eq(12), eq(4), anyString(), any(TextColor.class), eq(TextColor.ANSI.CYAN));
    }

    @Test
    void testDrawSubTitle() {
        highScoresViewer.drawSubTitle(guiMock);

        // Verify that the expected methods are invoked on the GUI mock
        verify(guiMock, times(1)).drawString(eq(12), eq(9), anyString(), any(TextColor.class), eq(TextColor.ANSI.CYAN));
    }

    @Test
    void testDrawDescription() {
        HighScoresMenu highScoresMenuMock = mock(HighScoresMenu.class);
        when(highScoresMenuMock.getTopPlayers(anyInt())).thenReturn(getTestPlayerList());

        HighScoresViewer highScoresViewerMock = new HighScoresViewer(highScoresMenuMock);
        highScoresViewerMock.drawDescription(guiMock);

        // Verify that the expected methods are invoked on the GUI mock
        verify(guiMock, times(1)).drawString(eq(30), eq(17), anyString(), any(TextColor.class), eq(TextColor.ANSI.CYAN));
    }

    @Test
    void testDrawElements() {
        highScoresViewer.drawElements(guiMock);

        // Verify that the expected methods are invoked on the GUI mock
        verify(guiMock, times(1)).drawString(eq(12), eq(4), anyString(), any(TextColor.class), eq(TextColor.ANSI.CYAN));
    }

    private List<Player> getTestPlayerList() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(100, "Player1"));
        players.add(new Player(90, "Player2"));
        players.add(new Player(80, "Player3"));
        return players;
    }
}
