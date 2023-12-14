package pt.up.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import pt.up.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawHero(Position position);
    void drawHeroShot(Position position);
    void drawAlpha(Position position);

    void drawGamma(Position position);
    void drawDelta(Position position);

    void drawWall(Position position);

    void drawBeta(Position position);

    void drawBarrier(Position position);

    void drawCeiGro(Position position);

    void drawBoss(Position position);

    void drawCoin(Position position);

    void drawLive(Position position);

    void drawText(Position position, String text, String color);

    void drawBackground();
    void drawBossShot(Position position);

    void drawString(int col, int row, String text, TextColor foregroundColor, TextColor backgroundColor);

    void drawEscString(int col, int row, String text, TextColor foregroundColor, TextColor backgroundColor, SGR sgr);

    TextGraphics getGraphics();

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION { ESC, UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, SHOOT }
}
