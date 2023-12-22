package pt.up.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.HeroShot;

import static org.mockito.Mockito.*;

class HeroShootViewerTest {

    private HeroShotViewer heroShotViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        heroShotViewer = new HeroShotViewer();
        gui = mock(GUI.class);
    }

    @Test
    void testDrawHeroShot() {
        HeroShot heroShot = new HeroShot(2, 2);
        heroShotViewer.draw(heroShot, gui);
        verify(gui, times(1)).drawHeroShot(new Position(2, 2));

        HeroShot heroShotAtOrigin = new HeroShot(0, 0);
        heroShotViewer.draw(heroShotAtOrigin, gui);
        verify(gui, times(1)).drawHeroShot(new Position(0, 0));

        HeroShot heroShotAtNegativePosition = new HeroShot(-1, -1);
        heroShotViewer.draw(heroShotAtNegativePosition, gui);
        verify(gui, times(1)).drawHeroShot(new Position(-1, -1));
    }

    @Test
    void testDrawHeroShotMultipleTimes() {
        HeroShot heroShot = new HeroShot(3, 3);
        heroShotViewer.draw(heroShot, gui);
        heroShotViewer.draw(heroShot, gui);
        heroShotViewer.draw(heroShot, gui);

        verify(gui, times(3)).drawHeroShot(new Position(3, 3)); // Verify that drawHeroShot is called three times with the correct position
    }

}
