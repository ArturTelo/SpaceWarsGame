package pt.up.controller.game;

import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.Alpha;
import pt.up.model.game.elements.enemy.Beta;
import pt.up.model.game.space.Space;

import java.io.IOException;

public class BetaController extends GameController{
    private long lastMovement;
    public BetaController(Space space) {
        super(space);
        this.lastMovement = 0;
    }
    private int side=0;  //1 vai para a direita e 0 para a esquerda
    private boolean change=false; // se houve mudança ou não
    @Override
    public void step(pt.up.Space space, GUI.ACTION action, long time) throws IOException {
        change = false;
        // 1 vai para a direita e 0 para a esquerda
        if (time - lastMovement > 500) {
            for (Beta beta : getModel().getBetas())
                if (side == 0 && change==false) {
                    moveBeta(beta, new Position(beta.getPosition().getX() - 1, beta.getPosition().getY()));
                    this.lastMovement = time;
                } else if (side == 1&& change==false) {
                    moveBeta(beta, new Position(beta.getPosition().getX() + 1, beta.getPosition().getY()));
                    this.lastMovement = time;
                } else if (change) {
                    moveBeta(beta, new Position(beta.getPosition().getX(),beta.getPosition().getY()+1));
                }
        }
    }

    private void moveBeta(Beta beta, Position position) {
        if (getModel().isEmpty(position)) {
            beta.setPosition(position);
        }
        else if(side==0){
            side=1;
            beta.setPosition(new Position(position.getX()+1,position.getY()+1));
            change=true;
        }
        else if(side==1) {
            side = 0;
            beta.setPosition(new Position(position.getX()-1, position.getY() + 1));
            change=true;
        }
    }
}
