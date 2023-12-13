package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.Lives;

public class LivesViewer implements ElementViewer<Lives>{
    @Override
    public void draw(Lives element, GUI gui) {
        gui.drawLive(element.getPosition());
    }
}
