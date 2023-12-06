package pt.up.controller;

import com.googlecode.lanterna.input.KeyStroke;
import pt.up.model.menu.MenuModel;

public class MenuController implements Observer {
    final MenuModel menuModel;

    public MenuController(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    @Override
    public void handleKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> menuModel.selectPrevious();
            case ArrowDown -> menuModel.selectNext();
            case Enter -> menuModel.setRunning(false);
        }
    }
}
