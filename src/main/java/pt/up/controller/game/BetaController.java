package pt.up.controller.game;

import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.Beta;
import pt.up.model.game.elements.enemy.Enemy;
import pt.up.model.game.elements.enemy.EnemyShot;
import pt.up.model.game.space.Space;

import java.io.IOException;
import java.util.Random;

public class BetaController extends GameController{
    private long lastMovement;
    private int i;
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
    private void shotcolides(Enemy element) {
        if(element.getIsShooting()) {
            moveShotY();
            Position position = getModel().getEnemyShot().getPosition();
            if(getModel().getEnemyShot().getPosition().getY() > 32) {
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
            for(Beta element: getModel().getBetas()){
                move(element,element.getPosition());
            }
            countpositions++;
            lastMovement = time;
        }
        if(countpositions==53){countpositions=0;}
        chagedirection();
        if(getModel().getBetas().size()!=0) {
            Random random = new Random();
            if (random.nextInt(300) == 3) {
                Random random1 = new Random();
                i = random1.nextInt(getModel().getBetas().size());
                createEnemyShot(i);
            }
            for (Beta element : getModel().getBetas()) {
                shotcolides(element);
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
        if(!getModel().getBetas().get(i).getIsShooting())
        {
            getModel().setEnemyShot(new EnemyShot(getModel().getBetas().get(i).getPosition().getX(),getModel().getBetas().get(i).getPosition().getY()));
            getModel().getBetas().get(i).createShot();
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

