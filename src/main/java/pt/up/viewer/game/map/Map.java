package pt.up.viewer.game.map;

import pt.up.model.game.elements.Hero;

public class Map {
    private Hero hero;

    private int width, height;

    public Map() {

    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
        hero.setMap(this);
    }

    public void setSize(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
