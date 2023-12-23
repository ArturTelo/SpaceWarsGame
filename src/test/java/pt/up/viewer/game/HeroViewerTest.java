package pt.up.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.Hero;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class HeroViewerTest {

    private HeroViewer heroViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        heroViewer = new HeroViewer();
        gui = mock(GUI.class);
    }

    @Test
    void testDrawHero() {

        Hero hero = new Hero(2, 2);
        heroViewer.draw(hero, gui);
        verify(gui, times(1)).drawHero(new Position(2, 2));

        Hero heroAtOrigin = new Hero(0, 0);
        heroViewer.draw(heroAtOrigin, gui);
        verify(gui, times(1)).drawHero(new Position(0, 0));

        Hero heroAtNegativePosition = new Hero(-1, -1);
        heroViewer.draw(heroAtNegativePosition, gui);
        verify(gui, times(1)).drawHero(new Position(-1, -1));
    }

    @Test
    void testDrawHeroMultipleTimes() {

        Hero hero = new Hero(3, 3);
        heroViewer.draw(hero, gui);
        heroViewer.draw(hero, gui);
        heroViewer.draw(hero, gui);

        verify(gui, times(3)).drawHero(new Position(3, 3)); // Verify that drawHero is called three times with the correct position
    }

    @Test
    void testDrawHeroWithException() throws IOException {
        GUI gui = mock(GUI.class);

        doAnswer(invocation -> {
            throw new IOException("Simulated IOException");
        }).when(gui).drawHero(any(Position.class));

        HeroViewer heroViewer = new HeroViewer();

        Hero hero = new Hero(1, 1);

        assertThrows(IOException.class, () -> heroViewer.draw(hero, gui)); // Verify that an IOException is thrown when drawing the Hero
    }
}
