package pt.up.gui;

import pt.up.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;
    void drawHero(Position position);

    void drawAlpha(Position position);

    void drawGamma(Position position);

    void drawWall(Position position);

    void drawBeta(Position position) ;
    void drawBarrier(Position position);

    void drawCeiGro(Position position);

    void drawBoss(Position position);
    void drawCoin(Position position);
    void drawLive(Position position);
    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT,SHOOT}
}
