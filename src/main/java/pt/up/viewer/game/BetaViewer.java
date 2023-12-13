package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.enemy.Beta;

public class BetaViewer implements ElementViewer<Beta>{
    @Override
    public void draw(Beta beta, GUI gui) {
        gui.drawBeta(beta.getPosition());

    }
}
