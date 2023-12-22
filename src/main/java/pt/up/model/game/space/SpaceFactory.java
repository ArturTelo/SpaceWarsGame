package pt.up.model.game.space;

import pt.up.model.game.elements.*;
import pt.up.model.game.elements.enemy.*;

import java.util.List;

public abstract class SpaceFactory {
    public Space createSpace() {
        Space space = new Space(getWidth(), getHeight());

        space.setHero(createHero());
        space.setHeroShot(createHeroShot());
        space.setBossShot(createBossShot());
        space.setHero(createHero());
        space.setAlphas(createAlphas());
        space.setBetas(createBetas());
        space.setBoss(createBoss());
        space.setGammas(createGammas());
        space.setLives(createLives());
        space.setWalls(createWalls());
        space.setBarriers(createBarriers());
        space.setCeiGro(createCeiGro());
        space.setDeltas(createDeltas());
        return space;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Alpha> createAlphas();

    protected abstract List<Gamma> createGammas();

    protected abstract List<Beta> createBetas();
    protected abstract List<Delta> createDeltas();

    protected abstract List<Barrier> createBarriers();

    protected abstract List<CeiGro> createCeiGro();

    protected abstract List<Lives> createLives();

    protected abstract Boss createBoss();

    protected abstract Hero createHero();

    protected abstract HeroShot createHeroShot();

    protected abstract BossShot createBossShot();


}
