package pt.up.states;

import pt.up.controller.Observer;
import pt.up.model.Model;
import pt.up.viewer.Viewer;

import java.io.IOException;

public abstract class State {
    public abstract Viewer getViewer();

    public abstract Observer getObserver();

    public abstract Model getModel();

    public abstract boolean isRunning();

    public abstract void step() throws IOException;

    public abstract State nextState() throws IOException;

    public abstract void initScreen();
}
