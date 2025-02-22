package pt.up.controller.game;


import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.HeroShot;
import pt.up.model.game.space.Space;

public class HeroController extends GameController {
    public HeroController(Space arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getHero().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getHero().getPosition().getRight());
    }

    public void moveHeroShootY(){
        moveHeroShot(getModel().getHeroShot().getPosition().getUp());
    }

    public void createHeroShoot(){
        if(!getModel().getHero().getIsShooting())
        {
            getModel().setHeroShot(new HeroShot(getModel().getHero().getPosition().getX(),getModel().getHero().getPosition().getY()));
            getModel().getHero().createShot();
        }
    }
    private void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getHero().setPosition(position);
        }
    }

    private void moveHeroShot(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getHeroShot().setPosition(position);
        }
    }
    public void shotcolides(Position position) {
        if(getModel().collideBarriers(position)){
            getModel().getHero().delShot();
        }
        if(getModel().collideBoss(position)){
            getModel().getHero().delShot();
        }
        if(getModel().collideDeltas(position)){
            getModel().getHero().delShot();
        }
        if(getModel().collideAlphas(position)){
            getModel().getHero().delShot();
        }
        if(getModel().collideGammas(position)){
            getModel().getHero().delShot();
        }
        if(getModel().collideBetas(position)){
            getModel().getHero().delShot();
        }//fica uma javardice mas é necessario
        if(getModel().getHeroShot().getPosition().getY() < 1)
        {
            getModel().getHero().delShot();
        }
    }
    @Override
    public void step(pt.up.Space game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
        if (action == GUI.ACTION.SHOOT) createHeroShoot();

        if (getModel().getHero().getIsShooting()) {
            moveHeroShootY();
            Position position = getModel().getHeroShot().getPosition();
            shotcolides(position);
        }
    }}