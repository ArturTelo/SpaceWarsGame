package pt.up.controller.game;

import pt.up.gui.GUI;
import java.util.Random;
import pt.up.model.Position;

import pt.up.model.game.elements.enemy.*;
import pt.up.model.game.space.Space;

import java.io.IOException;

public class BossController extends GameController{
    public int i;
    private int side=1;  //1 vai para a direita e 0 para a esquerda
    private int countpositions=0;
    public boolean changed=false;
    private long lastMovement;
    public int getSide() {return side;}
    public void setSide(int i) {this.side = i;}
    public void setCountpositions(int countpositions) {this.countpositions = countpositions;}
    public int getCountpositions() {return countpositions;}
    public void setChanged(boolean changed) {this.changed = changed;}
    public boolean getChanged() {return changed;}

    public void moveBossShotY(){
        moveBossShot(getModel().getBossShot().getPosition().getDown());
    }

    public void createBossShot(){
        if(!getModel().getBoss().getIsShooting())
        {
            getModel().setBossShot(new BossShot(getModel().getBoss().getPosition().getX(),getModel().getBoss().getPosition().getY()));
            getModel().getBoss().createShot();
        }
    }
    public void moveBossShot(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getBossShot().setPosition(position);
            //   if (getModel().isMonster(position)) getModel().getHero().decreaseEnergy();
        }
    }

    public BossController(Space space) {
        super(space);
        this.lastMovement = 0;
    }

    public void chagedirection(){
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

        Random random = new Random();
        if(random.nextInt(80)==3){
            createBossShot();
        }
        shotcolides(getModel().getBoss());
    }

    public void move(Boss element, Position position) {
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
    public void shotcolides(Boss element){
        if(element.getIsShooting()) {
            moveBossShotY();
            Position position = getModel().getBossShot().getPosition();
            if(getModel().collideCeiGro(position)) {
                element.delShot();
            }
            if(getModel().collideHero(position)){
                getModel().getHero().reduceHeroHealth(1);
                element.delShot();
            }
            if(getModel().collideBarriers(position)){
                element.delShot();
            }
        }
    }
}

