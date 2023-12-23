package pt.up.controller.game;

import pt.up.gui.GUI;
import pt.up.model.game.space.Space;
import pt.up.model.menu.GameOver;
import pt.up.model.menu.MainMenu;
import pt.up.states.GameOverState;
import pt.up.states.MainMenuState;

import java.io.IOException;


public class SpaceController extends GameController {
    public HeroController heroController;
    public AlphaController alphaController;
    public BetaController betaController;
    public GammaController gammaController;
    public BossController bossController;
    public DeltaController deltaController;

    public SpaceController(Space space) {
        super(space);
        this.heroController = new HeroController(space);
        this.alphaController = new AlphaController(space);
        this.betaController = new BetaController(space);
        this.gammaController = new GammaController(space);
        this.deltaController = new DeltaController(space);
        this.bossController = new BossController(space);
    }

    public void step(pt.up.Space game, GUI.ACTION action, long time) throws IOException {
        boolean winningCondition = getModel().getAlphas().isEmpty() && getModel().getBetas().isEmpty() && getModel().getGammas().isEmpty() && getModel().getDeltas().isEmpty() && !getModel().getBoss().alive();

        if (action == GUI.ACTION.QUIT)
            game.setState(new MainMenuState(new MainMenu()));

        else if(getModel().getHero().getHeroHealth() == 0 || winningCondition){
            game.setState(new GameOverState(new GameOver()));
            GameOver gameOverModel = new GameOver();
            gameOverModel.writeScore(GameOver.generateRandomString(),getModel().getHero().getScore());
        }

        else {
            heroController.step(game, action, time);
            alphaController.step(game, action, time);
            betaController.step(game, action,time);
            gammaController.step(game,action,time);
            bossController.step(game,action,time);
            deltaController.step(game, action, time);
        }
    }
}

/*
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.gui.GUI;
import pt.up.model.game.space.Space;
import pt.up.model.menu.GameOver;
import pt.up.model.menu.MainMenu;
import pt.up.states.GameOverState;
import pt.up.states.MainMenuState;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class SpaceControllerTest {

    @Test
    void testGameOverState() throws IOException {
        // Create a mock Space object
        pt.up.Space spaceMock = Mockito.mock(pt.up.Space.class);

        // Create the SpaceController
        SpaceController spaceController = new SpaceController(new Space());

        // Set the hero's health to 0 to trigger Game Over state
        spaceController.getModel().getHero().setHeroHealth(0);

        // Call the step method with any action and time
        spaceController.step(spaceMock, GUI.ACTION.UP, 0);

        // Verify that the state is set to GameOverState
        verify(spaceMock).setState(argThat(argument -> argument instanceof GameOverState));
    }

    @Test
    void testWinningCondition() throws IOException {
        // Create a mock Space object
        pt.up.Space spaceMock = Mockito.mock(pt.up.Space.class);

        // Create the SpaceController
        SpaceController spaceController = new SpaceController(new Space());

        // Set the model's enemies lists to empty to trigger Winning condition
        spaceController.getModel().getAlphas().clear();
        spaceController.getModel().getBetas().clear();
        spaceController.getModel().getGammas().clear();
        spaceController.getModel().getDeltas().clear();

        // Call the step method with any action and time
        spaceController.step(spaceMock, GUI.ACTION.UP, 0);

        // Verify that the state is set to GameOverState and the writeScore method is called
        verify(spaceMock).setState(argThat(argument -> argument instanceof GameOverState));
        verify(spaceMock.getGameOverModel()).writeScore(anyString(), anyInt());
    }

    @Test
    void testQuitAction() throws IOException {
        // Create a mock Space object
        pt.up.Space spaceMock = Mockito.mock(pt.up.Space.class);

        // Create the SpaceController
        SpaceController spaceController = new SpaceController(new Space());

        // Call the step method with QUIT action and any time
        spaceController.step(spaceMock, GUI.ACTION.QUIT, 0);

        // Verify that the state is set to MainMenuState
        verify(spaceMock).setState(argThat(argument -> argument instanceof MainMenuState));
    }

    @Test
    void testRegularGameplay() throws IOException {
        // Create a mock Space object
        pt.up.Space spaceMock = Mockito.mock(pt.up.Space.class);

        // Create the SpaceController
        SpaceController spaceController = new SpaceController(new Space());

        // Call the step method with any action and time
        spaceController.step(spaceMock, GUI.ACTION.UP, 0);

        // Verify that the step method is called for each controller
        verify(spaceController.getHeroController()).step(eq(spaceMock), eq(GUI.ACTION.UP), anyLong());
        verify(spaceController.getAlphaController()).step(eq(spaceMock), eq(GUI.ACTION.UP), anyLong());
        verify(spaceController.getBetaController()).step(eq(spaceMock), eq(GUI.ACTION.UP),anyLong());
        verify(spaceController.getGammaController()).step(eq(spaceMock), eq(GUI.ACTION.UP), anyLong());
        verify(spaceController.getBossController()).step(eq(spaceMock), eq(GUI.ACTION.UP), anyLong());
        verify(spaceController.getDeltaController()).step(eq(spaceMock), eq(GUI.ACTION.UP), anyLong());

        // Ensure that the state is not changed
        verify(spaceMock, never()).setState(any());
    }
}


 */