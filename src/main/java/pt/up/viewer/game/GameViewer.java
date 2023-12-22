package pt.up.viewer.game;

import pt.up.gui.GUI;
import pt.up.model.game.elements.Element;
import pt.up.model.game.elements.Hero;
import pt.up.model.game.elements.enemy.Alpha;
import pt.up.model.game.elements.enemy.Beta;
import pt.up.model.game.elements.enemy.Delta;
import pt.up.model.game.elements.enemy.Gamma;
import pt.up.model.game.space.Space;
import pt.up.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Space> {
    public GameViewer(Space space) {
        super(space);
    }

    @Override
    public void drawElements(GUI gui) {
        var hero = getModel().getHero();
        var heroShot = getModel().getHero();

        new ScoreView().draw(hero, gui);
        new LivesView().draw(hero, gui);

        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, hero, new HeroViewer());
        drawElement(gui, getModel().getBoss(), new BossViewer());
        if(getModel().getHero().getIsShooting())
            drawElement(gui, getModel().getHeroShot(), new HeroShotViewer());
        if(getModel().getBoss().getIsShooting())
            drawElement(gui, getModel().getBossShot(), new BossShotViewer());
        for (Alpha element: getModel().getAlphas()){
            if(element.getIsShooting())
                drawElement(gui, getModel().getEnemyShot(), new EnemyShotViewer());
        }
        for (Beta element: getModel().getBetas()){
            if(element.getIsShooting())
                drawElement(gui, getModel().getEnemyShot(), new EnemyShotViewer());
        }
        for (Delta element: getModel().getDeltas()){
            if(element.getIsShooting())
                drawElement(gui, getModel().getEnemyShot(), new EnemyShotViewer());
        }
        for (Gamma element: getModel().getGammas()){
            if(element.getIsShooting())
                drawElement(gui, getModel().getEnemyShot(), new EnemyShotViewer());
        }
        drawElements(gui,getModel().getAlphas(), new AlphaViewer());
        drawElements(gui, getModel().getBetas(), new BetaViewer());
        drawElements(gui,getModel().getGammas(),new GammaViewer());
        drawElements(gui, getModel().getCeiGro(), new CeiGrouViewer());
        drawElements(gui, getModel().getBarriers(), new BarrierViewer());
        drawElements(gui,getModel().getDeltas(),new DeltaViewer());
        //drawElement(gui,getModel().getCoin(),new CoinViewer());
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
