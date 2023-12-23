package pt.up;

import pt.up.gui.LanternaGUI;
import pt.up.model.menu.MainMenu;
import pt.up.states.MainMenuState;
import pt.up.states.State;
import pt.up.utils.Constants;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.System.exit;

public class Space {
    private final LanternaGUI gui;
    public State state;

    public Space() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.state = new MainMenuState(new MainMenu());
    }

    public void setState(State state) {
        this.state = state;
    }

    public void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
        exit(0);
    }
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Space().start();
    }
}
