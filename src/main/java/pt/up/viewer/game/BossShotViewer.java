package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.enemy.BossShot;

public class BossShotViewer implements ElementViewer<BossShot> {
    @Override
    public void draw(BossShot bossShot, GUI gui) {gui.drawBossShot(bossShot.getPosition());
    }
}
