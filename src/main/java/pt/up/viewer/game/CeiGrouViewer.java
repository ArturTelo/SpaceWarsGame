package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.CelGro;


public class CeiGrouViewer implements ElementViewer<CelGro> {
    @Override
    public void draw(CelGro element, GUI gui) {
        gui.drawCeiGro(element.getPosition());
    }
}
