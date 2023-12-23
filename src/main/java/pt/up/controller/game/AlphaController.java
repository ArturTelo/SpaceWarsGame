package pt.up.controller.game;


import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.Element;
import pt.up.model.game.elements.enemy.*;
import pt.up.model.game.space.Space;


import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class AlphaController extends GameController{
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




    public AlphaController(Space space) {
        super(space);
        this.lastMovement = 0;
    }
    @Override
    public void step(pt.up.Space space, GUI.ACTION action, long time) throws IOException {
        changed=false;
        // 1 vai para a direita e 0 para a esquerda
        if (time - lastMovement > 300) {
            for(Alpha element: getModel().getAlphas()){
                move(element,element.getPosition());
            }
            countpositions++;
            lastMovement = time;
        }
        if(countpositions==53){countpositions=0;}
        chagedirection();
        if(getModel().getAlphas().size()!=0){//vê se ainda existem alphas
            Random random = new Random();
            if(random.nextInt(100)==3){
                Random random1=new Random();
                i=random1.nextInt(getModel().getAlphas().size());
                createEnemyShot(i);
            }
            for(Alpha element: getModel().getAlphas()){
                shotcolides(element);

            }
        }
    }
    public void chagedirection(){
        if(side==1 && changed){side=0;}
        else if(side==0 && changed){side=1;}
        changed=false;
    }


    public void move(Alpha element, Position position) {
        if (countpositions<51){// se for menor que 51 move se par aos lados e no 51 fica parado para efeitos visuais
            if(side==1){
                element.setPosition(new Position(element.getPosition().getX()+1, element.getPosition().getY()));
            }
            if(side==0){
               element.setPosition(new Position(element.getPosition().getX()-1 ,element.getPosition().getY()));
            }
        }
        else if (countpositions==52){ //se for 52 bate na parede e desce
            if(side==1){
                element.setPosition(new Position(element.getPosition().getX(), element.getPosition().getY()+1));
                changed=true;
            }
            if(side==0){
                element.setPosition(new Position(element.getPosition().getX() ,element.getPosition().getY()+1));
                changed=true;
            }
        }
    }
    public void shotcolides(Enemy element) {
        if(element.getIsShooting()){
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
    public void moveShotY(){
        moveShot(getModel().getEnemyShot().getPosition().getDown());
    }

    public void moveShot(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getEnemyShot().setPosition(position);
        }
    }

    public void createEnemyShot(int i) {
        if(!getModel().getAlphas().get(i).getIsShooting())
        {   Position position = getModel().getAlphas().get(i).getPosition();
            getModel().setEnemyShot(new EnemyShot(position.getX(),position.getY()));
            getModel().getAlphas().get(i).createShot();
        }
    }
}

