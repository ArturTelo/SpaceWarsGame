package pt.up.controller.game;


import pt.up.controller.Controller;
import pt.up.model.game.space.Space;

public abstract class GameController extends Controller<Space> {
    public GameController(Space space) {
        super(space);
    }
}
