package pt.up.model.game.elements.enemy;

public class Alpha extends Enemy {
    public Alpha(int x, int y) {
        super(x, y);
    }

    // to check if its working
    public static void main(String[] args) {
        Alpha alpha = new Alpha(0, 5);

        alpha.setHealth(10);
        alpha.setPoints(30);
        System.out.printf("Alpha Health %s\n", alpha.getHealth());
        System.out.printf("Alpha Points %s\n", alpha.getPoints());
    }
}
