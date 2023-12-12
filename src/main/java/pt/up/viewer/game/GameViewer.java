package pt.up.viewer.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import pt.up.model.game.elements.GameModel;
import pt.up.viewer.Viewer;

import java.io.IOException;

public class GameViewer extends Viewer<GameModel> {
    private HeroViewer heroViewer;
    private final GameModel gameModel;
    private ScoreView scoreView;
    private LiveView livesView;

    private void create() {
        heroViewer = new HeroViewer(gameModel.getMap().getHero(), graphics);
        scoreView = new ScoreView(gameModel.getMap().getHero(), graphics);
        livesView = new LiveView(gameModel.getMap().getHero(), graphics);
    }

    public GameViewer(GameModel gameModel, Screen screen) {
        super(gameModel, screen);
        this.gameModel = gameModel;

        create();
    }

    public GameViewer(GameModel gameModel, Screen screen, TextGraphics graphics) {
        super(gameModel, screen);
        this.gameModel = gameModel;
        this.graphics = graphics;

        create();
    }

    @Override
    public void draw() throws IOException {
        graphics.setBackgroundColor(TextColor.ANSI.CYAN);

        scoreView.draw();
        livesView.draw();

        heroViewer.draw();

        getScreen().refresh(Screen.RefreshType.AUTOMATIC);
    }
}
