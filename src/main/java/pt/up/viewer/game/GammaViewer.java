package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.enemy.Gamma;

public class GammaViewer implements ElementViewer<Gamma>{
    @Override
    public void draw(Gamma element, GUI gui) {
        gui.drawGamma(element.getPosition());
    }
}
