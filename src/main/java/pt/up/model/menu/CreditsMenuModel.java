package pt.up.model.menu;

import pt.up.model.Model;

public class CreditsMenuModel extends MenuModel implements Model {
    private boolean running;

    public CreditsMenuModel() {
        running = true;
    }

    @Override
    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
