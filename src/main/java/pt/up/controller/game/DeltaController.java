package pt.up.controller.game;

import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.enemy.Delta;
import pt.up.model.game.elements.enemy.EnemyShot;
import pt.up.model.game.elements.enemy.Gamma;
import pt.up.model.game.space.Space;

import java.io.IOException;
import java.util.Random;

public class DeltaController extends GammaController{
    public int i;
    private long lastMovement;
    public void moveShotY(){
        moveShot(getModel().getEnemyShoot().getPosition().getDown());}
    public void  createElementShoot(int i){
        if(!getModel().getDeltas().get(i).getIsShooting())
        {
            getModel().setEnemyShoot(new EnemyShot(getModel().getDeltas().get(i).getPosition().getX(),getModel().getDeltas().get(i).getPosition().getY()));
            getModel().getDeltas().get(i).createShot();
        }
    }
    private void moveShot(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getEnemyShoot().setPosition(position);
            //   if (getModel().isMonster(position)) getModel().getHero().decreaseEnergy();
        }
        if(getModel().collideBarriers(position)){
            getModel().getDeltas().get(i).delShot();
        }
        if(getModel().getEnemyShoot().getPosition().getY() > 32)
        {
            getModel().getDeltas().get(i).delShot();
        }
        if(getModel().collideHero(position)){
            getModel().getHero().reduceHeroHealth(1);
            getModel().getDeltas().get(i).delShot();
        }}
    public DeltaController(Space space) {
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
            for(Delta delta: getModel().getDeltas()){
                move(delta,delta.getPosition());
            }
            countpositions++;
            lastMovement = time;
        }
        if(countpositions==53){countpositions=0;}
        chagedirection();
        Random random = new Random();
        if(random.nextInt(300)==3){
            Random random1 = new Random();
            i=random1.nextInt(getModel().getDeltas().size());
            createElementShoot((i));
        }
        if(getModel().getDeltas().get(i).getIsShooting()) {
            moveShotY();
        }
    }

    private void move(Delta gamma, Position position) {
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
