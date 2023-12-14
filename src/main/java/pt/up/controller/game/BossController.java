package pt.up.controller.game;

import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.Beta;
import pt.up.model.game.elements.enemy.Boss;
import pt.up.model.game.elements.enemy.Delta;
import pt.up.model.game.elements.enemy.Gamma;
import pt.up.model.game.space.Space;

import java.io.IOException;

public class BossController extends GameController{
    private long lastMovement;

    public BossController(Space space) {
        super(space);
        this.lastMovement = 0;
    }
    private int side=1;  //1 vai para a direita e 0 para a esquerda
    private int countpositions=0;
    private boolean changed=false;
    private void chagedirection(){
        if(side==1 && changed){side=0;}
        else if(side==0 && changed){side=1;}
        changed=false;
    }
    @Override
    public void step(pt.up.Space space, GUI.ACTION action, long time) throws IOException {
        changed=false;
        // 1 vai para a direita e 0 para a esquerda
        if (time - lastMovement > 50){
            Boss boss = getModel().getBoss();
            move(boss,boss.getPosition());
            countpositions++;
            lastMovement = time;
        }
        if(countpositions==78){countpositions=0;}
        chagedirection();
    }

    private void move(Boss element, Position position) {
        if (countpositions<76){
            if(side==1){
                element.setPosition(new Position(element.getPosition().getX()+1, element.getPosition().getY()));
            }
            if(side==0){
                element.setPosition(new Position(element.getPosition().getX()-1 ,element.getPosition().getY()));
            }
        }
        else if (countpositions==77){
            if(side==1){
                changed=true;
            }
            if(side==0){
                changed=true;
            }
        }
    }
}

