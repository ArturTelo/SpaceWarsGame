package pt.up.controller.game;


import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.Alpha;
import pt.up.model.game.space.Space;


import java.io.IOException;

public class AlphaController extends GameController{
        private long lastMovement;
        public AlphaController(Space space) {
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
            for (Alpha alpha : getModel().getAlphas())
                if (side == 0 && change==false) {
                    moveAlpha(alpha, new Position(alpha.getPosition().getX() - 1, alpha.getPosition().getY()));
                    this.lastMovement = time;
                } else if (side == 1&& change==false) {
                    moveAlpha(alpha, new Position(alpha.getPosition().getX() + 1, alpha.getPosition().getY()));
                    this.lastMovement = time;
                } else if (change) {
                    moveAlpha(alpha, new Position(alpha.getPosition().getX(),alpha.getPosition().getY()+1));
                }
        }
    }

    private void moveAlpha(Alpha alpha, Position position) {
        if (getModel().isEmpty(position)) {
            alpha.setPosition(position);
        }
        else if(side==0){
            side=1;
            alpha.setPosition(new Position(position.getX()+1,position.getY()+1));
            change=true;
        }
        else if(side==1) {
            side = 0;
            alpha.setPosition(new Position(position.getX()-1, position.getY() + 1));
            change=true;
        }
    }
}
