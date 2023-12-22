package pt.up.controller.game;

import pt.up.gui.GUI;
import pt.up.model.game.space.Space;
import pt.up.model.menu.GameOver;
import pt.up.model.menu.MainMenu;
import pt.up.states.GameOverState;
import pt.up.states.MainMenuState;

import java.io.IOException;


public class SpaceController extends GameController {
    private final HeroController heroController;
    private final AlphaController alphaController;
    private final BetaController betaController;
    private final GammaController gammaController;
    private final BossController bossController;
    private final DeltaController deltaController;

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
        boolean winningCondition = getModel().getAlphas().isEmpty() && getModel().getBetas().isEmpty() &&
                getModel().getGammas().isEmpty() && getModel().getDeltas().isEmpty();
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