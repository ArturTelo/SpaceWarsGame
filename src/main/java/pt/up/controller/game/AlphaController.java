package pt.up.controller.game;


import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.Element;
import pt.up.model.game.elements.enemy.Alpha;
import pt.up.model.game.elements.enemy.BossShot;
import pt.up.model.game.elements.enemy.EnemyShot;
import pt.up.model.game.elements.enemy.Gamma;
import pt.up.model.game.space.Space;


import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class AlphaController extends GameController{
    private int i;
    private long lastMovement;
    public AlphaController(Space space) {
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
            for(Alpha element: getModel().getAlphas()){
                move(element,element.getPosition());
            }
            countpositions++;
            lastMovement = time;
        }
        if(countpositions==53){countpositions=0;}
        chagedirection();
        Random random = new Random();
        if(random.nextInt(100)==3){
            Random random1=new Random();
            i=random1.nextInt(getModel().getAlphas().size());
            createEnemyShot(i);
        }
        for(Alpha element: getModel().getAlphas()){
            if(element.getIsShooting()) {
                moveShotY();
                Position position = getModel().getEnemyShot().getPosition();
                if(getModel().getEnemyShot().getPosition().getY() > 32)
                {
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

    public void moveShotY(){
        moveShot(getModel().getEnemyShot().getPosition().getDown());
    }

    private void moveShot(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getEnemyShot().setPosition(position);
            //   if (getModel().isMonster(position)) getModel().getHero().decreaseEnergy();
        }
    }

    private void createEnemyShot(int i) {
        if(!getModel().getAlphas().get(i).getIsShooting())
        {
            getModel().setEnemyShot(new EnemyShot(getModel().getAlphas().get(i).getPosition().getX(),getModel().getAlphas().get(i).getPosition().getY()));
            getModel().getAlphas().get(i).createShot();
        }
    }

    private void move(Alpha element, Position position) {
        if (countpositions<51){
            if(side==1){
                element.setPosition(new Position(element.getPosition().getX()+1, element.getPosition().getY()));
            }
            if(side==0){
               element.setPosition(new Position(element.getPosition().getX()-1 ,element.getPosition().getY()));
            }
        }
        else if (countpositions==52){
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
    }

