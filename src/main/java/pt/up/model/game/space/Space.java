package pt.up.model.game.space;


import pt.up.model.Position;
import pt.up.model.game.elements.*;
import pt.up.model.game.elements.enemy.Alpha;
import pt.up.model.game.elements.enemy.Beta;
import pt.up.model.game.elements.enemy.Gamma;

import java.util.List;

public class Space {
    private final int width;
    private final int height;
    private Hero hero;
    private Coin coin;
    private List<Lives> lives;

    private List<Alpha> alphas;
    private List<Gamma> gammas;
    private List<Wall> walls;
    private List<Beta> betas;
    private List<Barrier> barriers;
    private List<CelGro> ceilingground;

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Alpha> getAlphas(){return alphas;}
    public List<Gamma> getGammas(){return gammas;}
    public List<Wall> getWalls(){return walls;};
    public List<Beta> getBetas(){return betas;};
    public List<Barrier> getBarriers(){return barriers;};
    public List<CelGro> getCeiGro(){return ceilingground;}
    public Coin getCoin(){return coin;}
    public List<Lives> getLives(){return lives;}
    public Hero getHero() {
        return hero;
    }
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

    public void setBetas(List<Beta> betas) {
        this.betas = betas;
    }

    public void setBarriers(List<Barrier> barriers) {
        this.barriers = barriers;
    }

    public void setCeiGro(List<CelGro> ceilingground) {
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
    //Ver se os tiros colidem
    public boolean colidealphas(Position position) {
        for (Alpha alpha : alphas)
            if (alpha.getPosition().equals(position))
                return true;
        return false;
    }

        public boolean collideAlphas(Position position) {
            for (Alpha alpha : alphas) {
                if (alpha.getPosition().equals(position)) {
                    return true;
                }
            }
            return false;
        }

        public boolean collideGammas(Position position) {
            for (Gamma gamma : gammas) {
                if (gamma.getPosition().equals(position)) {
                    return true;
                }
            }
            return false;
        }

        public boolean collideWalls(Position position) {
            for (Wall wall : walls) {
                if (wall.getPosition().equals(position)) {
                    return true;
                }
            }
            return false;
        }

        public boolean collideBetas(Position position) {
            for (Beta beta : betas) {
                if (beta.getPosition().equals(position)) {
                    return true;
                }
            }
            return false;
        }

        public boolean collideBarriers(Position position) {
            for (Barrier barrier : barriers) {
                if (barrier.getPosition().equals(position)) {
                    return true;
                }
            }
            return false;
        }

        public boolean collideCeiGro(Position position) {
            for (CelGro celGro : ceilingground) {
                if (celGro.getPosition().equals(position)) {
                    return true;
                }
            }
            return false;
        }

        public boolean collideCoin(Position position) {
            return coin.getPosition().equals(position);
        }
        public boolean collideHero(Position position){
            return hero.getPosition().equals(position);
        }
}


