package pt.up.viewer.game;

import java.util.List;

import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.game.elements.Barrier;
import pt.up.model.game.elements.Element;
import pt.up.model.game.space.Space;
import pt.up.viewer.Viewer;

public class GameViewer extends Viewer<Space> {
    public GameViewer(Space space) {
        super(space);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getHero(), new HeroViewer());
        //drawElement(gui,getModel().getCoin(),new CoinViewer());
        drawElements(gui,getModel().getAlphas(), new AlphaViewer());
        drawElements(gui, getModel().getBetas(), new BetaViewer());
        drawElements(gui,getModel().getGammas(),new GammaViewer());
        drawElements(gui, getModel().getLives(), new LivesViewer());
        drawElements(gui, getModel().getCeiGro(), new CeiGrouViewer());
        drawElements(gui, getModel().getBarriers(), new BarrierViewer());
        /*gui.drawText(new Position(0, 0), "Energy: " + getModel().getHero().getHeroHealth(), "#FFD700");*/
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
