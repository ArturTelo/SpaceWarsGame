package pt.up.controller.game;

import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.Alpha;
import pt.up.model.game.elements.enemy.Beta;
import pt.up.model.game.elements.enemy.EnemyShot;
import pt.up.model.game.space.Space;

import java.io.IOException;
import java.util.Random;

public class BetaController extends GameController{
    public int i;
    private long lastMovement;
    public void moveShotY(){
        moveShot(getModel().getEnemyShoot().getPosition().getDown());}
    public void  createElementShoot(int i){
        if(!getModel().getBetas().get(i).getIsShooting())
        {
            getModel().setEnemyShoot(new EnemyShot(getModel().getBetas().get(i).getPosition().getX(),getModel().getBetas().get(i).getPosition().getY()));
            getModel().getBetas().get(i).createShot();
        }
    }
    private void moveShot(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getEnemyShoot().setPosition(position);
            //   if (getModel().isMonster(position)) getModel().getHero().decreaseEnergy();
        }
        if(getModel().collideBarriers(position)){
            getModel().getBetas().get(i).delShot();
        }
        if(getModel().getEnemyShoot().getPosition().getY() > 32)
        {
            getModel().getBetas().get(i).delShot();
        }
        if(getModel().collideHero(position)){
            getModel().getHero().reduceHeroHealth(1);
            getModel().getBetas().get(i).delShot();
        }}
    public BetaController(Space space) {
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
            for(Beta element: getModel().getBetas()){
                move(element,element.getPosition());
            }
            countpositions++;
            lastMovement = time;
        }
        if(countpositions==53){countpositions=0;}
        chagedirection();
        Random random = new Random();
        if(random.nextInt(200)==3){
            Random random1 = new Random();
            i=random1.nextInt(getModel().getBetas().size());
            createElementShoot((i));
        }
        if(getModel().getBetas().get(i).getIsShooting()) {
            moveShotY();
        }
    }

    private void move(Beta element, Position position) {
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

