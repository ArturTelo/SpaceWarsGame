package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.Barrier;

public class BarrierViewer implements ElementViewer<Barrier> {
    @Override
    public void draw(Barrier barrier, GUI gui){
        gui.drawBarrier(barrier.getPosition());
    }
}
