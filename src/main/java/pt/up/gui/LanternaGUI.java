package pt.up.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import pt.up.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;
    protected TextGraphics graphics;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;

        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        graphics = screen.newTextGraphics();

        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();

        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/main.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Backspace) return ACTION.SHOOT;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.ESC;

        return ACTION.NONE;
    }

    @Override
    public void drawAlpha(Position position) {
        drawCharacter(position.getX(), position.getY(), 'a', "#FFFFFF");
    }

    @Override
    public void drawHeroShot(Position position){
        drawCharacter(position.getX(), position.getY(), 'I', "#FFFFFF");
    }

    @Override
    public void drawGamma(Position position) {
        drawCharacter(position.getX(), position.getY(), 'g', "#FFFFFF");
    }

    @Override
    public void drawHero(Position position) {
        drawCharacter(position.getX(), position.getY(), 'h', "#FFFFFF");
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY(), 'i', "#FFFFFF");
    }

    @Override
    public void drawBeta(Position position) {
        drawCharacter(position.getX(), position.getY(), 'e', "#FFFFFF");
    }

    @Override
    public void drawDelta(Position position){drawCharacter(position.getX(), position.getY(), 'd',"#FFFFFF");}
    @Override
    public void drawBarrier(Position position) {
        drawCharacter(position.getX(), position.getY(), 'b', "#FFFFFF");
    }

    @Override
    public void drawCeiGro(Position position) {
        drawCharacter(position.getX(), position.getY(), '-', "#FFFFFF");
    }

    @Override
    public void drawBoss(Position position) {
        drawCharacter(position.getX(), position.getY(), 'm', "#FFFFFF");
    }

    @Override
    public void drawBossShot(Position position) {
        drawCharacter(position.getX(), position.getY(), 'I', "#FF0000");
    }

    @Override
    public void drawCoin(Position position) {
        drawCharacter(position.getX(), position.getY(), 'c', "#FFFFFF");
    }

    @Override
    public void drawLive(Position position) {
        drawCharacter(position.getX(), position.getY(), 'l', "#FFFFFF");
    }
    public void drawEnemyShot(Position position){drawCharacter(position.getX(), position.getY(),'I',"#FF0000");}

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.setBackgroundColor(TextColor.ANSI.CYAN);
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void drawBackground() {
        TextGraphics textGraphics = screen.newTextGraphics();

        textGraphics.setBackgroundColor(TextColor.ANSI.CYAN);
        textGraphics.fill(' ');
    }

    @Override
    public void drawString(int col, int row, String text, TextColor foregroundColor, TextColor backgroundColor) {
        graphics.setForegroundColor(foregroundColor);
        graphics.setBackgroundColor(backgroundColor);

        graphics.putString(col, row, text);
    }

    @Override
    public void drawEscString(int col, int row, String text, TextColor foregroundColor, TextColor backgroundColor, SGR sgr) {
        graphics.setForegroundColor(foregroundColor);
        graphics.setBackgroundColor(backgroundColor);

        graphics.putString(col, row, text, sgr);
    }

    @Override
    public TextGraphics getGraphics() {
        return graphics;
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.setBackgroundColor(TextColor.ANSI.CYAN);
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
