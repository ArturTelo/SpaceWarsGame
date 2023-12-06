package pt.up.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import pt.up.model.menu.HighScoreMenuModel;

public class HighScoreMenuController implements Observer {
    final HighScoreMenuModel highScoreMenuController;

    public HighScoreMenuController(HighScoreMenuModel highScoreMenuController) {
        this.highScoreMenuController = highScoreMenuController;
    }

    @Override
    public void handleKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.Escape) {
            highScoreMenuController.setRunning(false);
        }
    }
}
