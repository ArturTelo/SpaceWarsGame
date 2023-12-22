package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.enemy.Alpha;

public class AlphaViewer implements ElementViewer<Alpha> {
    @Override
    public void draw(Alpha alpha, GUI gui) {
        if (alpha != null) {
            gui.drawAlpha(alpha.getPosition());
        }
    }
}
