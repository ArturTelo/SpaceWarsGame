package pt.up.controller.game;

import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.Enemy;
import pt.up.model.game.elements.enemy.EnemyShot;
import pt.up.model.game.elements.enemy.Gamma;
import pt.up.model.game.space.Space;

import java.io.IOException;
import java.util.Random;

public class GammaController extends GameController{
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


    public GammaController(Space space) {
        super(space);
        this.lastMovement = 0;
    }

    public void chagedirection(){
        if(side==1 && changed){side=0;}
        else if(side==0 && changed){side=1;}
        changed=false;
    }
    public void shotcolides(Enemy element) {
        if(element.getIsShooting()) {
            moveShotY();
            Position position = getModel().getEnemyShot().getPosition();
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
    @Override
    public void step(pt.up.Space space, GUI.ACTION action, long time) throws IOException {
        changed=false;
        // 1 vai para a direita e 0 para a esquerda
        if (time - lastMovement > 300) {
            for(Gamma gamma: getModel().getGammas()){
                move(gamma,gamma.getPosition());
            }
            countpositions++;
            lastMovement = time;
        }
        if(countpositions==53){countpositions=0;}
        chagedirection();
        if(getModel().getGammas().size()!=0) {
            Random random = new Random();
            if (random.nextInt(100) == 3) {
                Random random1 = new Random();
                i = random1.nextInt(getModel().getGammas().size());
                createEnemyShot(i);
            }
            for (Gamma element : getModel().getGammas()) {
                shotcolides(element);
            }
        }
    }
    public void moveShotY(){
        moveShot(getModel().getEnemyShot().getPosition().getDown());
    }

    public void moveShot(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getEnemyShot().setPosition(position);
            //   if (getModel().isMonster(position)) getModel().getHero().decreaseEnergy();
        }
    }

    public void createEnemyShot(int i) {
        if(!getModel().getGammas().get(i).getIsShooting())
        {
            getModel().setEnemyShot(new EnemyShot(getModel().getGammas().get(i).getPosition().getX(),getModel().getGammas().get(i).getPosition().getY()));
            getModel().getGammas().get(i).createShot();
        }
    }

    public void move(Gamma gamma, Position position) {
        if (countpositions<51){
            if(side==1){
                gamma.setPosition(new Position(gamma.getPosition().getX()+1, gamma.getPosition().getY()));
            }
            if(side==0){
                gamma.setPosition(new Position(gamma.getPosition().getX()-1 ,gamma.getPosition().getY()));
            }
        }
        else if (countpositions==52){
            if(side==1){
                gamma.setPosition(new Position(gamma.getPosition().getX(), gamma.getPosition().getY()+1));
                changed=true;
            }
            if(side==0){
                gamma.setPosition(new Position(gamma.getPosition().getX() ,gamma.getPosition().getY()+1));
                changed=true;
            }
        }
    }
}

