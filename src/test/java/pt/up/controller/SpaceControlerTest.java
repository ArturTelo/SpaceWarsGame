package pt.up.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.controller.game.*;
import pt.up.gui.GUI;
import pt.up.model.game.elements.Barrier;
import pt.up.model.game.elements.Hero;
import pt.up.model.game.elements.Wall;
import pt.up.model.game.elements.enemy.*;
import pt.up.model.game.space.Space;
import pt.up.states.GameOverState;
import pt.up.states.MainMenuState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class SpaceControlerTest {
    pt.up.Space spaceMock ;
    SpaceController spaceController;
    Space space;

    @BeforeEach
    void setUp(){
        space= new Space(10,10);
        space.setWalls(new ArrayList<>(Arrays.asList((new Wall(0, 1)))));
        space.setBetas(new ArrayList<>(Arrays.asList(new Beta(2, 4))));
        space.setGammas(new ArrayList<>(Arrays.asList(new Gamma(3, 4))));
        space.setAlphas(new ArrayList<>(Arrays.asList(new Alpha(4, 4))));
        space.setBarriers(new ArrayList<>(Arrays.asList(new Barrier(5, 4))));
        space.setBoss(new Boss(6,4));
        space.setDeltas(new ArrayList<>(Arrays.asList(new Delta(7, 4))));
        space.setHero(new Hero(5, 5));
        spaceMock= Mockito.mock(pt.up.Space.class);
        spaceController = new SpaceController(space);
    }
    @Test
    void GamoverCondition() throws IOException {
        spaceController.getModel().getHero().setHeroHealth(0);
        spaceController.step(spaceMock, GUI.ACTION.NONE, 0);
        verify(spaceMock).setState(argThat(argument -> argument instanceof GameOverState));
    }


    @Test
    void testWinningCondition() throws IOException {
        spaceController.getModel().getAlphas().clear();
        spaceController.getModel().getBetas().clear();
        spaceController.getModel().getGammas().clear();
        spaceController.getModel().getDeltas().clear();
        spaceController.getModel().getBoss().setAlive(false);
        spaceController.step(spaceMock, GUI.ACTION.NONE, 0);

        verify(spaceMock).setState(argThat(argument -> argument instanceof GameOverState));
    }

    @Test
    void testQuitAction() throws IOException {
        spaceController.step(spaceMock, GUI.ACTION.QUIT, 0);
        verify(spaceMock).setState(argThat(argument -> argument instanceof MainMenuState));
    }

    @Test
    void testRegularGameplay() throws IOException {
        HeroController heroControllerMock = Mockito.mock(HeroController.class);
        AlphaController alphaControllerMock = Mockito.mock(AlphaController.class);
        BetaController betaControllerMock = Mockito.mock(BetaController.class);
        GammaController gammaControllerMock = Mockito.mock(GammaController.class);
        BossController bossControllerMock = Mockito.mock(BossController.class);
        DeltaController deltaControllerMock = Mockito.mock(DeltaController.class);

        spaceController.heroController = heroControllerMock;
        spaceController.alphaController = alphaControllerMock;
        spaceController.betaController = betaControllerMock;
        spaceController.gammaController = gammaControllerMock;
        spaceController.bossController = bossControllerMock;
        spaceController.deltaController = deltaControllerMock;

        spaceController.step(spaceMock, GUI.ACTION.UP, 0);

        verify(heroControllerMock).step(spaceMock, GUI.ACTION.UP, 0);
        verify(alphaControllerMock).step(spaceMock, GUI.ACTION.UP, 0);
        verify(betaControllerMock).step(spaceMock, GUI.ACTION.UP, 0);
        verify(gammaControllerMock).step(spaceMock, GUI.ACTION.UP, 0);
        verify(bossControllerMock).step(spaceMock, GUI.ACTION.UP, 0);
        verify(deltaControllerMock).step(spaceMock, GUI.ACTION.UP, 0);


        verify(spaceMock, never()).setState(Mockito.any());
    }
}

