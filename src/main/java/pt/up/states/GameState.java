package pt.up.states;

import pt.up.controller.Observer;
import pt.up.model.Model;
import pt.up.viewer.Viewer;

import java.io.IOException;

public class GameState extends State {

    @Override
    public Viewer getViewer() {
        return null;
    }

    @Override
    public Observer getObserver() {
        return null;
    }

    @Override
    public Model getModel() {
        return null;
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void step() throws IOException {

    }

    @Override
    public State nextState() throws IOException {
        return null;
    }

    @Override
    public void initScreen() {

    }
}
