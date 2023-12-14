package pt.up.controller.game;

import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.Boss;
import pt.up.model.game.elements.enemy.Delta;
import pt.up.model.game.elements.enemy.Gamma;
import pt.up.model.game.space.Space;

import java.io.IOException;

public class BossController extends GammaController{
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
        if (time - lastMovement > 300) {
            Boss boss = getModel().getBoss();
            move(boss,boss.getPosition());
            countpositions++;
            lastMovement = time;
        }
        if(countpositions==53){countpositions=0;}
        chagedirection();
    }

    private void move(Boss boss, Position position) {
        if (countpositions<51){
            if(side==1){
                boss.setPosition(new Position(boss.getPosition().getX()+1, boss.getPosition().getY()));
            }
            if(side==0){
                boss.setPosition(new Position(boss.getPosition().getX()-1 ,boss.getPosition().getY()));
            }
        }
    }
}

