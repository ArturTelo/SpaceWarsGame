package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {

    @Override
    public void draw(Wall wall, GUI gui) {
        if (wall != null) {
            gui.drawWall(wall.getPosition());
        }
    }
}
