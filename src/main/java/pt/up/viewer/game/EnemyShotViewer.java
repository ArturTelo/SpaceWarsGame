package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.enemy.EnemyShot;

public class EnemyShotViewer implements ElementViewer<EnemyShot> {
    @Override
    public void draw(EnemyShot element, GUI gui) {
        gui.drawEnemyShot(element.getPosition());
    }
}
