package pt.up.viewer.game;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.gui.GUI;
import pt.up.model.game.elements.Hero;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ScoreViewTest {

    @Test
    void testDraw() {
        GUI gui = Mockito.mock(GUI.class);
        ScoreView scoreView = new ScoreView();
        Hero hero = new Hero(1, 1);
        hero.incrementHeroScore(1000);

        scoreView.draw(hero, gui);

        verify(gui, times(1)).drawString(6, 1, "Score", TextColor.Factory.fromString("#FFFFFF"), TextColor.ANSI.CYAN);
        verify(gui, times(1)).drawString(6 + "Score".length() + 1, 1, "01000", TextColor.Factory.fromString("#00FF0A"), TextColor.ANSI.CYAN);
    }

    @Test
    void testDrawWithDifferentScore() {

        GUI gui = Mockito.mock(GUI.class);
        ScoreView scoreView = new ScoreView();
        Hero hero = new Hero(1, 1);
        hero.incrementHeroScore(500); // Assuming the initial score is 0

        scoreView.draw(hero, gui);

        verify(gui, times(1)).drawString(6, 1, "Score", TextColor.Factory.fromString("#FFFFFF"), TextColor.ANSI.CYAN);
        verify(gui, times(1)).drawString(6 + "Score".length() + 1, 1, "00500", TextColor.Factory.fromString("#00FF0A"), TextColor.ANSI.CYAN);
    }
}
