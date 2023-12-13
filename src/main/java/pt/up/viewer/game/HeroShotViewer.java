package pt.up.viewer.game;

import pt.up.model.game.elements.HeroShot;
import pt.up.gui.GUI;
public class HeroShotViewer implements ElementViewer<HeroShot> {
    @Override
    public void draw(HeroShot hero, GUI gui) {
        gui.drawHeroShot(hero.getPosition());
    }
}