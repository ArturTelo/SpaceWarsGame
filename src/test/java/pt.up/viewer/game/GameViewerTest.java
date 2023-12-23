package pt.up.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pt.up.gui.GUI;
import pt.up.model.game.elements.*;
import pt.up.model.game.elements.enemy.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class GameViewerTest {

    @Mock
    private GUI gui;

    @Mock
    private HeroViewer heroViewerMock;

    @Mock
    private BossViewer bossViewerMock;

    @Mock
    private HeroShotViewer heroShotViewerMock;

    @Mock
    private BossShotViewer bossShotViewerMock;

    @Mock
    private AlphaViewer alphaViewerMock;

    @Mock
    private BetaViewer betaViewerMock;

    @Mock
    private GammaViewer gammaViewerMock;

    @Mock
    private CeiGrouViewer ceiGrouViewerMock;

    @Mock
    private BarrierViewer barrierViewerMock;

    @Mock
    private DeltaViewer deltaViewerMock;

    @InjectMocks
    private GameViewer gameViewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
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

        doReturn(hero).when(gameViewer.getModel()).getHero();
        doReturn(heroShot).when(gameViewer.getModel()).getHeroShot();
        doReturn(boss).when(gameViewer.getModel()).getBoss();
        doReturn(bossShot).when(gameViewer.getModel()).getBossShot();
        doReturn(walls).when(gameViewer.getModel()).getWalls();
        doReturn(alphas).when(gameViewer.getModel()).getAlphas();
        doReturn(betas).when(gameViewer.getModel()).getBetas();
        doReturn(gammas).when(gameViewer.getModel()).getGammas();
        doReturn(ceiGroList).when(gameViewer.getModel()).getCeiGro();
        doReturn(barriers).when(gameViewer.getModel()).getBarriers();
        doReturn(deltas).when(gameViewer.getModel()).getDeltas();

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
