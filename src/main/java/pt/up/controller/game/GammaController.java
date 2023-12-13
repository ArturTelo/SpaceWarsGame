package pt.up.controller.game;

import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.Beta;
import pt.up.model.game.elements.enemy.Gamma;
import pt.up.model.game.space.Space;

import java.io.IOException;

public class GammaController extends GameController{
    private long lastMovement;
    public GammaController(Space space) {
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
            for (Gamma gamma : getModel().getGammas())
                if (side == 0 && change==false) {
                    moveGamma(gamma, new Position(gamma.getPosition().getX() - 1, gamma.getPosition().getY()));
                    this.lastMovement = time;
                } else if (side == 1&& change==false) {
                    moveGamma(gamma, new Position(gamma.getPosition().getX() + 1, gamma.getPosition().getY()));
                    this.lastMovement = time;
                } else if (change) {
                    moveGamma(gamma, new Position(gamma.getPosition().getX(),gamma.getPosition().getY()+1));
                }
        }
    }

    private void moveGamma(Gamma gamma, Position position) {
        if (getModel().isEmpty(position)) {
            gamma.setPosition(position);
        }
        else if(side==0){
            side=1;
            gamma.setPosition(new Position(position.getX()+1,position.getY()+1));
            change=true;
        }
        else if(side==1) {
            side = 0;
            gamma.setPosition(new Position(position.getX()-1, position.getY() + 1));
            change=true;
        }
    }
}

