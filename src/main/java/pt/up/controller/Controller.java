package pt.up.controller;



import pt.up.Space;
import pt.up.gui.GUI;


import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Space space, GUI.ACTION action, long time) throws IOException;
}
