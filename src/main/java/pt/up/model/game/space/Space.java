package pt.up.model.game.space;

import pt.up.model.Position;
import pt.up.model.game.elements.*;
import pt.up.model.game.elements.enemy.*;
import pt.up.utils.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Space {
    private final int width;
    private final int height;

    private HeroShot heroShot;
    private BossShot bossShot;
    private EnemyShot enemyShot;
    private Hero hero;
    private Coin coin;
    private Boss boss;
    private List<Lives> lives;
    private List<Delta> deltas;
    private List<Alpha> alphas;
    private List<Gamma> gammas;
    private List<Wall> walls;
    private List<Beta> betas;
    private List<Barrier> barriers;
    private List<CeiGro> ceilingground;

    public Space(int width, int height) {
        this.width = width;
        this.height = height;

        Configuration.getInstance().stopAllMusic();
        Configuration.getInstance().getGameMusic().start();
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Alpha> getAlphas() {
        return alphas;
    }

    public List<Gamma> getGammas() {
        return gammas;
    }
    public List<Delta> getDeltas(){return deltas;}

    public List<Wall> getWalls() {
        return walls;
    }

    public Boss getBoss() {
        return boss;
    }

    public List<Beta> getBetas() {
        return betas;
    }

    public List<Barrier> getBarriers() {
        return barriers;
    }

    public List<CeiGro> getCeiGro() {
        return ceilingground;
    }

    public Coin getCoin() {
        return coin;
    }

    public List<Lives> getLives() {
        return lives;
    }

    public Hero getHero() {
        return hero;
    }

    public HeroShot getHeroShot() {
        return heroShot;
    }
    public BossShot getBossShot() {
        return bossShot;
    }
    public EnemyShot getEnemyShot(){return enemyShot;}

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setHeroShot(HeroShot heroShot) {
        this.heroShot = heroShot;
    }

    public void setBossShot(BossShot bossShot){
        this.bossShot = bossShot;
    }

    public void setEnemyShot(EnemyShot enemyShot){
        this.enemyShot = enemyShot;
    }

    public void setDeltas(List<Delta> deltas){this.deltas=deltas;}

    public void setLives(List<Lives> lives) {
        this.lives = lives;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setAlphas(List<Alpha> alphas) {
        this.alphas = alphas;
    }

    public void setGammas(List<Gamma> gammas) {
        this.gammas = gammas;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public void setBetas(List<Beta> betas) {
        this.betas = betas;
    }

    public void setBarriers(List<Barrier> barriers) {
        this.barriers = barriers;
    }

    public void setCeiGro(List<CeiGro> ceilingground) {
        this.ceilingground = ceilingground;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    //Para não sair do Space
    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean collideAlphas(Position position) {
        if(alphas == null){
            alphas = new ArrayList<>();
            return false;
        }
        Iterator<Alpha> iterator = alphas.iterator();
        while (iterator.hasNext()) {
            Alpha alpha = iterator.next();

            if (alpha.getPosition().equals(position)) {
                iterator.remove();
                getHero().incrementHeroScore(alpha.getPoints());

                return true;
            }
        }
        return false;
    }

    public boolean collideBetas(Position position) {
        if(betas == null){
            betas = new ArrayList<>();
            return false;
        }
        Iterator<Beta> iterator = betas.iterator();

        while (iterator.hasNext()) {
            Beta beta = iterator.next();

            if (beta.getPosition().equals(position)) {
                iterator.remove();
                getHero().incrementHeroScore(beta.getPoints());
                setBetas(betas);
                return true;
            }
        }
        return false;
    }

    public boolean collideDeltas(Position position) {
        if(deltas == null){
            deltas = new ArrayList<>();
            return false;
        }
        Iterator<Delta> iterator = deltas.iterator();
        while (iterator.hasNext()) {
            Delta delta = iterator.next();

            if (delta.getPosition().equals(position)) {
                iterator.remove();
                getHero().incrementHeroScore(delta.getPoints());
                return true;
            }
        }
        return false;
    }

    public boolean collideGammas(Position position) {
        if (gammas == null) {
            gammas = new ArrayList<>(); // Initialize with an empty list
            return false; // No collision with empty list
        }
        Iterator<Gamma> iterator = gammas.iterator();
        while (iterator.hasNext()) {
            Gamma gamma = iterator.next();

            if (gamma.getPosition().equals(position)) {
                iterator.remove();
                getHero().incrementHeroScore(gamma.getPoints());
                return true;
            }
        }
        return false;
    }
    public boolean collideBarriers(Position position) {
        if (barriers == null) {
            barriers = new ArrayList<>(); // Initialize with an empty list
            return false; // No collision with empty list
        }
        Iterator<Barrier> iterator =barriers.iterator();

        while (iterator.hasNext()) {
            Barrier barrier = iterator.next();

            if (barrier.getPosition().equals(position)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean collideBoss(Position position) {
        if (boss != null && boss.getPosition().equals(position)) {
            getHero().incrementHeroScore(boss.getPoints());
            boss = new Boss(999,999);
            boss.setAlive(false);
            return true;
        }
        return false;
    }

    public boolean colideHero(Position position) {
        if (hero.getPosition().equals(position)) {
            getHero().reduceHeroHealth(1);
            return true;
        }
        return false;
    }

    public boolean collideCeiGro(Position position) {
        for (CeiGro ceiGro : ceilingground) {
            if (ceiGro.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean collideCoin(Position position) {
        return coin.getPosition().equals(position);
    }

    public boolean collideHero(Position position) {
        return hero.getPosition().equals(position);
    }


}

