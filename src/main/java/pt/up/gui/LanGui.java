package pt.up.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorAutoCloseTrigger;

public class LanGui implements Gui {
    private Screen screen;
    protected TextGraphics graphics;

    @Override
    public void createScreenGame(Integer width, Integer height) {

    }

    @Override
    public void createScreenMenu(Integer width, Integer height) {
        try {
            TerminalSize terminalSize = new TerminalSize(width, height);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            terminalFactory.setTerminalEmulatorFrameAutoCloseTrigger(TerminalEmulatorAutoCloseTrigger.CloseOnExitPrivateMode);
            Terminal terminal = terminalFactory.createTerminal();

            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            graphics = screen.newTextGraphics();

            TextGraphics textGraphics = screen.newTextGraphics();

            textGraphics.setBackgroundColor(TextColor.ANSI.CYAN);
            textGraphics.fill(' ');
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Screen getScreen() {
        return screen;
    }
}