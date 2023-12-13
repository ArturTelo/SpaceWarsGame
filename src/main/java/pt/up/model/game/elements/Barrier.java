package pt.up.model.game.elements;

public class Barrier extends Element{
    private int resistance;
    public void reduceresistance() {
        resistance--;
    }
    public Barrier(int x, int y) {
        super(x, y);
        resistance=1;
    }
    public int getResistance(){
        return resistance;
    }
}
