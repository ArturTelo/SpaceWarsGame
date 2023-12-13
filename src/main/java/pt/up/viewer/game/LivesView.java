package pt.up.viewer.game;

import com.googlecode.lanterna.TextColor;
import pt.up.gui.GUI;
import pt.up.model.game.elements.Hero;
import pt.up.utils.Constants;

public class LivesView implements ElementViewer<Hero> {

    @Override
    public void draw(Hero hero, GUI gui) {
        String scoreTitle = "Lives";

        gui.drawString(65, 1, scoreTitle, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);

        int heroHealth = hero.getHeroHealth();

        gui.drawString(66 + scoreTitle.length(), 1, "" + heroHealth, TextColor.Factory.fromString(Constants.RED), TextColor.ANSI.CYAN);
    }
}
