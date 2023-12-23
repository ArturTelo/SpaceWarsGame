package pt.up.viewer.game;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;
import pt.up.gui.GUI;
import pt.up.model.game.elements.Hero;
import pt.up.utils.Constants;

import static org.mockito.Mockito.*;

class LivesViewTest {

    @Test
    void testDraw() {
        GUI gui = mock(GUI.class);
        LivesView livesView = new LivesView();
        Hero hero = new Hero(1, 1);

        TextColor whiteColor = TextColor.Factory.fromString(Constants.WHITE);
        TextColor cyanColor = TextColor.ANSI.CYAN;

        livesView.draw(hero, gui);

        // Verify that the drawString method is called with the correct parameters
        verify(gui, times(1)).drawString(65, 1, "LIVESul", whiteColor, cyanColor); // Fix the string
        verify(gui, times(1)).drawString(66 + "LIVESul".length(), 1, "" + hero.getHeroHealth(), TextColor.Factory.fromString(Constants.RED), cyanColor);
    }

    @Test
    void testDrawWithDifferentHeroHealth() {
        GUI gui = mock(GUI.class);
        LivesView livesView = new LivesView();
        Hero hero = new Hero(1, 1);
        hero.setHeroHealth(50);

        TextColor whiteColor = TextColor.Factory.fromString(Constants.WHITE);
        TextColor cyanColor = TextColor.ANSI.CYAN;

        livesView.draw(hero, gui);

        // Verify that the drawString method is called with the correct parameters for the updated hero health
        verify(gui, times(1)).drawString(65, 1, "LIVESul", whiteColor, cyanColor);
        verify(gui, times(1)).drawString(66 + "LIVESul".length(), 1, "" + hero.getHeroHealth(), TextColor.Factory.fromString(Constants.RED), cyanColor);
    }

    @Test
    void testDrawWithZeroHeroHealth() {
        GUI gui = mock(GUI.class);
        LivesView livesView = new LivesView();
        Hero hero = new Hero(1, 1);
        hero.setHeroHealth(0);

        TextColor whiteColor = TextColor.Factory.fromString(Constants.WHITE);
        TextColor cyanColor = TextColor.ANSI.CYAN;

        livesView.draw(hero, gui);

        // Verify that the drawString method is called with the correct parameters for zero hero health
        verify(gui, times(1)).drawString(65, 1, "LIVESul", whiteColor, cyanColor);
        verify(gui, times(1)).drawString(66 + "LIVESul".length(), 1, "0", TextColor.Factory.fromString(Constants.RED), cyanColor);
    }
}
