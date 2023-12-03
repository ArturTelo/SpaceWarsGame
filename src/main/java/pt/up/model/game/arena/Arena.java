package pt.up.model.game.arena;

import com.googlecode.lanterna.TerminalSize;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Arena {

    public void init() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 40);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            TerminalScreen screen = new TerminalScreen(terminal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
