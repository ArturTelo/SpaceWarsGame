package pt.up.model.game.arena;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Arena {

    public void init() {
        try {
            TerminalSize terminalSize = new TerminalSize(80, 40);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            TerminalScreen screen = new TerminalScreen(terminal);

            screen.startScreen();
            TextGraphics textGraphics = screen.newTextGraphics();

            textGraphics.setBackgroundColor(TextColor.ANSI.CYAN);
            textGraphics.fill(' ');

            screen.refresh();
            screen.readInput();
            screen.stopScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
