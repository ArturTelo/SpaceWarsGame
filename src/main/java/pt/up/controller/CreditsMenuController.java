package pt.up.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import pt.up.model.menu.CreditsMenuModel;

public class CreditsMenuController implements Observer {
    final CreditsMenuModel creditsMenuModel;

    public CreditsMenuController(CreditsMenuModel creditsMenuModel) {
        this.creditsMenuModel = creditsMenuModel;
    }

    @Override
    public void handleKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.Escape) {
            creditsMenuModel.setRunning(false);
        }
    }
}
