package pt.up.states;

import pt.up.controller.Controller;
import pt.up.controller.menu.CreditsMenuController;
import pt.up.model.menu.CreditsMenu;
import pt.up.viewer.Viewer;
import pt.up.viewer.menu.CreditsViewer;

public class CreditsMenuState extends State<CreditsMenu> {
    public CreditsMenuState(CreditsMenu model) {
        super(model);
    }

    @Override
    protected Viewer<CreditsMenu> getViewer() {
        return new CreditsViewer(getModel());
    }

    @Override
    protected Controller<CreditsMenu> getController() {
        return new CreditsMenuController(getModel());
    }
}
