package pt.up.viewer.game;

import com.googlecode.lanterna.TextColor;
import pt.up.gui.GUI;
import pt.up.model.game.elements.Hero;
import pt.up.utils.Constants;

public class ScoreView implements ElementViewer<Hero> {

    @Override
    public void draw(Hero hero, GUI gui) {
        String scoreTitle = "Score";

        gui.drawString(6, 1, scoreTitle, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);

        int heroScore = hero.getScore();
        String score = String.format("%05d", heroScore);

        gui.drawString(6 + scoreTitle.length() + 1, 1, score, TextColor.Factory.fromString(Constants.GREEN), TextColor.ANSI.CYAN);
    }
}
