package pt.up.states;

import pt.up.controller.Controller;
import pt.up.controller.menu.MainMenuController;
import pt.up.model.menu.MainMenu;
import pt.up.viewer.Viewer;
import pt.up.viewer.menu.MenuViewer;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
