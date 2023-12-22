package pt.up.model.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.model.game.elements.*;
import pt.up.model.game.elements.enemy.*;
import pt.up.model.game.space.SpaceLoader;

import java.io.IOException;
import java.util.List;

public class SpaceLoaderTest {
    private SpaceLoader spaceLoader;

    @BeforeEach
    public void createSpace() throws IOException {
        spaceLoader = new SpaceLoader();
    }

    @Test
    public void testWidth(){
        int width = spaceLoader.createSpace().getWidth();

        Assertions.assertEquals(80,width);
    }
    @Test
    public void testHeight(){
        int width = spaceLoader.createSpace().getHeight();

        Assertions.assertEquals(33,width);
    }
    @Test
    public void testCreateWalls() throws IOException {
        List<Wall> walls = spaceLoader.createSpace().getWalls();

        Assertions.assertNotNull(walls);
        Assertions.assertEquals(64, walls.size());
    }

    @Test
    public void testCreateAlphas() throws IOException {
        List<Alpha> alphas = spaceLoader.createSpace().getAlphas();

        Assertions.assertNotNull(alphas);
        Assertions.assertEquals(14, alphas.size());
    }

    @Test
    public void testCreateGammas() throws IOException {
        List<Gamma> gammas  = spaceLoader.createSpace().getGammas();

        Assertions.assertNotNull(gammas);
        Assertions.assertEquals(14, gammas.size());
    }

    @Test
    public void testCreateBetas() throws IOException {
        List<Beta> betas = spaceLoader.createSpace().getBetas();

        Assertions.assertNotNull(betas);
        Assertions.assertEquals(14, betas.size());
    }

    @Test
    public void testCreateDeltas() throws IOException {
        List<Delta> deltas = spaceLoader.createSpace().getDeltas();

        Assertions.assertNotNull(deltas);
        Assertions.assertEquals(14, deltas.size());
    }

    @Test
    public void testCreateBarriers() throws IOException {
        List<Barrier> barriers = spaceLoader.createSpace().getBarriers();

        Assertions.assertNotNull(barriers);
        Assertions.assertEquals(96, barriers.size());
    }

    @Test
    public void testCreateCeiGro() throws IOException {
        List<CeiGro> ceiGroes = spaceLoader.createSpace().getCeiGro();

        Assertions.assertNotNull(ceiGroes);
        Assertions.assertEquals(156, ceiGroes.size());
    }

    @Test
    public void testCreateBoss() throws IOException {
        Boss boss = spaceLoader.createSpace().getBoss();

        Assertions.assertNotNull(boss);
    }

    @Test
    public void testCreateHero() throws IOException {
        Hero hero = spaceLoader.createSpace().getHero();

        Assertions.assertNotNull(hero);
    }

}
