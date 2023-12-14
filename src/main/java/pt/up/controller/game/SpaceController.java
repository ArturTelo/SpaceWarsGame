package pt.up.controller.game;

import pt.up.gui.GUI;
import pt.up.model.game.space.Space;
import pt.up.model.menu.MainMenu;
import pt.up.states.MainMenuState;

import java.io.IOException;

public class SpaceController extends GameController {
    private final HeroController heroController;
    private final AlphaController alphaController;
    private final BetaController betaController;
    private final GammaController gammaController;
    private final DeltaController deltaController;
/*


    private final BetaController betaController;
    private final BossController bossController;
    private final HeroShootController hshootController;
    private final EnemyShootController eshootController;
    private final CoinController coinController;*/

    public SpaceController(Space space) {
        super(space);
        this.heroController = new HeroController(space);
        this.alphaController=new AlphaController(space);
        this.betaController=new BetaController(space);
        this.gammaController=new GammaController(space);
        this.deltaController= new DeltaController(space);
        /*

        this.bossController=new BossController(space);
        this.hshootController=new HeroShootController(space);
        this.eshootController=new EnemyShootController(space);
        this.coinController= new CoinController(Space);*/
    }

    public void step(pt.up.Space game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getHero().getHeroHealth() == 0)
            game.setState(new MainMenuState(new MainMenu()));
        else {
            heroController.step(game, action, time);
            alphaController.step(game, action, time);
            betaController.step(game, action,time);
            gammaController.step(game,action,time);
            deltaController.step(game, action, time);
        }
    }
}