package pt.up.controller;

import pt.up.states.MenuState;
import pt.up.states.State;
import pt.up.viewer.Viewer;

import java.io.IOException;

public class Controller {
    final Thread thread;
    Keys readKeys;
    State state;
    Viewer viewer;


    public Controller() {
        readKeys = new Keys();
        thread = new Thread(readKeys);
        thread.start();
    }

    public void run() throws IOException {
        if (state == null) {
            state = new MenuState();
            state.initScreen();
        }

        while (state != null) {
            viewer = state.getViewer();

            readKeys.setScreen(viewer.getScreen());
            readKeys.addObserver(state.getObserver());

            while (state.isRunning())
                state.step();

            readKeys.removeObserver(state.getObserver());
            viewer.closeScreen();
            setState(state.nextState());
            if (state != null)
                state.initScreen();
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setReadKeys(Keys readKeys) {
        this.readKeys = readKeys;
    }

    public Thread getThread() {
        return thread;
    }

    public Keys getReadKeys() {
        return readKeys;
    }
}
