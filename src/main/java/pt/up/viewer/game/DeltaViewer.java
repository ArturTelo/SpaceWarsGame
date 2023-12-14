package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.Element;
import pt.up.model.game.elements.enemy.Delta;

public class DeltaViewer implements ElementViewer<Delta>{
    @Override
    public void draw(Delta element, GUI gui) {
        gui.drawDelta(element.getPosition());
    }
}
