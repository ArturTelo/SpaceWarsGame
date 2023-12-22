package pt.up.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.gui.GUI;
import pt.up.model.game.elements.*;
import pt.up.model.game.elements.enemy.*;
import pt.up.model.game.space.Space;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class GameViewerTest {

    private GameViewer gameViewer;
    private GUI gui;
    private Space space;

    @BeforeEach
    void setUp() {
        space = mock(Space.class);
        gameViewer = new GameViewer(space);
        gui = mock(GUI.class);
    }

    @Test
    void testDrawElements() {
        Hero hero = mock(Hero.class);
        HeroShot heroShot = mock(HeroShot.class);
        Boss boss = mock(Boss.class);
        BossShot bossShot = mock(BossShot.class);
        List<Wall> walls = new ArrayList<>();
        List<Alpha> alphas = new ArrayList<>();
        List<Beta> betas = new ArrayList<>();
        List<Gamma> gammas = new ArrayList<>();
        List<CeiGro> ceiGroList = new ArrayList<>();
        List<Barrier> barriers = new ArrayList<>();
        List<Delta> deltas = new ArrayList<>();

        when(space.getHero()).thenReturn(hero);
        when(space.getHeroShot()).thenReturn(heroShot);
        when(space.getBoss()).thenReturn(boss);
        when(space.getBossShot()).thenReturn(bossShot);
        when(space.getWalls()).thenReturn(walls);
        when(space.getAlphas()).thenReturn(alphas);
        when(space.getBetas()).thenReturn(betas);
        when(space.getGammas()).thenReturn(gammas);
        when(space.getCeiGro()).thenReturn(ceiGroList);
        when(space.getBarriers()).thenReturn(barriers);
        when(space.getDeltas()).thenReturn(deltas);

        HeroViewer heroViewerMock = mock(HeroViewer.class);
        BossViewer bossViewerMock = mock(BossViewer.class);
        HeroShotViewer heroShotViewerMock = mock(HeroShotViewer.class);
        BossShotViewer bossShotViewerMock = mock(BossShotViewer.class);
        AlphaViewer alphaViewerMock = mock(AlphaViewer.class);
        BetaViewer betaViewerMock = mock(BetaViewer.class);
        GammaViewer gammaViewerMock = mock(GammaViewer.class);
        CeiGrouViewer ceiGrouViewerMock = mock(CeiGrouViewer.class);
        BarrierViewer barrierViewerMock = mock(BarrierViewer.class);
        DeltaViewer deltaViewerMock = mock(DeltaViewer.class);

        gameViewer.drawElements(gui);

        // Verify that the draw method is called for each viewer with the correct arguments
        verify(heroViewerMock, times(1)).draw(eq(hero), eq(gui));
        verify(bossViewerMock, times(1)).draw(eq(boss), eq(gui));
        verify(heroShotViewerMock, times(1)).draw(eq(heroShot), eq(gui));
        verify(bossShotViewerMock, times(1)).draw(eq(bossShot), eq(gui));
        verify(alphaViewerMock, times(alphas.size())).draw(any(Alpha.class), eq(gui));
        verify(betaViewerMock, times(betas.size())).draw(any(Beta.class), eq(gui));
        verify(gammaViewerMock, times(gammas.size())).draw(any(Gamma.class), eq(gui));
        verify(ceiGrouViewerMock, times(ceiGroList.size())).draw(any(CeiGro.class), eq(gui));
        verify(barrierViewerMock, times(barriers.size())).draw(any(Barrier.class), eq(gui));
        verify(deltaViewerMock, times(deltas.size())).draw(any(Delta.class), eq(gui));
    }
}
