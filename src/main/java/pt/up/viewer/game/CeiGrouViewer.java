package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.CeiGro;

public class CeiGrouViewer implements ElementViewer<CeiGro> {
    @Override
    public void draw(CeiGro element, GUI gui) {
        if (element != null) {
            gui.drawCeiGro(element.getPosition());
        }
    }
}
