package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.Hero;

public class HeroViewer implements ElementViewer<Hero> {
    @Override
    public void draw(Hero hero, GUI gui) {
        gui.drawHero(hero.getPosition());
    }
}
