package org.spacewars.model.game.elements;

public class Hero {
    private int health = 3;
    private int coins = 0;


    public void reduceHeroHealth(){
        health--;
    }

    public void incrementHeroHealth(){
        health++;
    }

    public int getHeroHealth(){
        return health;
    }

    public int getHeroCoins() {
        return coins;
    }

    public void incrementHeroCoins(){
        coins++;
    }

    //should always increase health? I think its actually better than checking if the max is 3
    public void checkCoinsToHealth(){
        if(coins == 5){
            coins = 0;
            incrementHeroHealth();
        }
    }

    // TEST HERO IMPLEMENTED FUNCTIONS
    public static void main(String[] args) {
        Hero heroi = new Hero();
        for(int i = 0; i < 6; i++){
            heroi.incrementHeroCoins();
            heroi.checkCoinsToHealth();
            int coins = heroi.getHeroCoins();
            System.out.printf("Hero Coins %s\n", coins);
        }
        int health = heroi.getHeroHealth();

        System.out.printf("Hero Health %s\n", health);
    }


}
