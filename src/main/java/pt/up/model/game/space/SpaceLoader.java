package pt.up.model.game.space;

import pt.up.model.game.elements.*;
import pt.up.model.game.elements.enemy.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SpaceLoader extends SpaceFactory {
    private final List<String> lines;

    public SpaceLoader() throws IOException {
        URL resource = SpaceLoader.class.getResource("/maps/map.txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '|') walls.add(new Wall(x, y));
        }

        return walls;
    }

    @Override
    protected List<Alpha> createAlphas() {
        List<Alpha> alphas = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'A') alphas.add(new Alpha(x, y));
        }
        return alphas;
    }

    @Override
    protected List<Gamma> createGammas() {
        List<Gamma> gammas = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'G') gammas.add(new Gamma(x, y));
        }
        return gammas;
    }
    @Override
    protected List<Delta> createDeltas() {
        List<Delta> deltas = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'D') deltas.add(new Delta(x, y));
        }
        return deltas;
    }


    @Override
    protected List<Beta> createBetas() {
        List<Beta> betas = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'E') betas.add(new Beta(x, y));
        }
        return betas;
    }

    @Override
    protected List<Barrier> createBarriers() {
        List<Barrier> barriers = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'B') barriers.add(new Barrier(x, y));
        }
        return barriers;
    }

    @Override
    protected List<CeiGro> createCeiGro() {
        List<CeiGro> celgroes = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '-') celgroes.add(new CeiGro(x, y));
        }
        return celgroes;
    }


    @Override
    protected List<Lives> createLives() {
        List<Lives> lives = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'L') lives.add(new Lives(x, y));
        }
        return lives;
    }

    @Override
    protected Hero createHero() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') return new Hero(x, y);
        }
        return null;
    }

    @Override
    protected Boss createBoss() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'M') return new Boss(x, y);
        }
        return null;
    }
   /* @Override
    protected HeroShot createHeroShot(){
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'I') return new HeroShot(x, y);
        }
        return null;
    }

    @Override
    protected BossShot createBossShot() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'I') return new BossShot(x, y);
        }
        return null;
    }*/
}