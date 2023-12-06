package pt.up.controller;

import com.googlecode.lanterna.input.KeyStroke;

public interface Observer {
    void handleKey(KeyStroke key);
}
