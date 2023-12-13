package pt.up.controller.game;


import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.space.Space;

public class HeroController extends GameController {
    public HeroController(Space arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getHero().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getHero().getPosition().getRight());
    }

    private void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getHero().setPosition(position);
         //   if (getModel().isMonster(position)) getModel().getHero().decreaseEnergy();
        }
    }

    @Override
    public void step(pt.up.Space game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
    }
}
