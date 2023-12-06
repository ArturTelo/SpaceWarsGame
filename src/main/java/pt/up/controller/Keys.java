package pt.up.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;

public class Keys implements Runnable {
    volatile Screen screen = null;
    final ArrayList<Observer> observers;

    public Keys() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (screen == null || observers.isEmpty())
                    continue;

                KeyStroke keyStroke = screen.readInput();
                for (Observer observer : observers) {
                    observer.handleKey(keyStroke);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }
}