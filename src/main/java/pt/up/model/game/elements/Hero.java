package pt.up.model.game.elements;

public class Hero extends Element {
    private int health = 3;
    private int coins = 0;

    public Hero(int x, int y) {
        super(x, y);
    }

    public void reduceHeroHealth() {
        health--;
    }

    public void incrementHeroHealth() {
        health++;
    }

    public int getHeroHealth() {
        return health;
    }

    public int getHeroCoins() {
        return coins;
    }

    public void incrementHeroCoins() {
        coins++;
    }

    //should always increase health? I think its actually better than checking if the max is 3
    public void checkCoinsToHealth() {
        if (coins == 5) {
            coins = 0;
            incrementHeroHealth();
        }
    }

    // TEST HERO IMPLEMENTED FUNCTIONS
    public static void main(String[] args) {
        Hero heroi = new Hero(0, 5);
        for (int i = 0; i < 6; i++) {
            heroi.incrementHeroCoins();
            heroi.checkCoinsToHealth();
            int coins = heroi.getHeroCoins();
            System.out.printf("Hero Coins %s\n", coins);
        }
        int health = heroi.getHeroHealth();
        heroi.moveUp();
        heroi.moveDown();
        heroi.moveDown();
        heroi.moveDown();
        heroi.moveDown();
        heroi.moveRight();
        heroi.moveRight();
        System.out.printf("Hero Position x:%s, y:%s\n", heroi.getPosition().getX(), heroi.getPosition().getY());
        System.out.printf("Hero Health %s\n", health);
    }


}
