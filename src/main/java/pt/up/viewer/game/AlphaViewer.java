package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.enemy.Alpha;

public class AlphaViewer implements ElementViewer<Alpha> {
    @Override
    public void draw(Alpha element, GUI gui) {
        gui.drawAlpha(element.getPosition());
    }
}
