package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.enemy.Boss;

public class BossViewer implements ElementViewer<Boss> {
    @Override
    public void draw(Boss element, GUI gui) {
        gui.drawBoss(element.getPosition());
    }
}
