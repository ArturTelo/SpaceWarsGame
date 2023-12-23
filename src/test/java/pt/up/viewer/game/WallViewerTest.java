package pt.up.viewer.game;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.Wall;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class WallViewerTest {

    @Test
    void testDraw() {
        GUI gui = Mockito.mock(GUI.class);
        WallViewer wallViewer = new WallViewer();
        Wall wall = new Wall(1, 1);

        wallViewer.draw(wall, gui);

        verify(gui, times(1)).drawWall(new Position(1, 1));
    }

    @Test
    void testDrawWithDifferentPosition() {
        GUI gui = Mockito.mock(GUI.class);
        WallViewer wallViewer = new WallViewer();
        Wall wall = new Wall(3, 5);

        wallViewer.draw(wall, gui);

        verify(gui, times(1)).drawWall(new Position(3, 5));
    }

    @Test
    void testDrawMultipleWalls() {
        GUI gui = Mockito.mock(GUI.class);
        WallViewer wallViewer = new WallViewer();
        Wall wall1 = new Wall(1, 1);
        Wall wall2 = new Wall(3, 5);
        Wall wall3 = new Wall(0, 0);

        wallViewer.draw(wall1, gui);
        wallViewer.draw(wall2, gui);
        wallViewer.draw(wall3, gui);

        verify(gui, times(1)).drawWall(new Position(1, 1));
        verify(gui, times(1)).drawWall(new Position(3, 5));
        verify(gui, times(1)).drawWall(new Position(0, 0));
    }

    @Test
    void testDrawNoWalls() {
        GUI gui = Mockito.mock(GUI.class);
        WallViewer wallViewer = new WallViewer();

        wallViewer.draw(null, gui);

        verify(gui, times(0)).drawWall(Mockito.any());
    }
}
