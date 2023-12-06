package pt.up.model.menu;

public enum MenuOption {
    PLAY("PLAY"),
    HIGHSCORES("HIGHSCORES"),
    CREDITS("CREDITS"),
    EXIT("EXIT");

    private final String text;

    MenuOption(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
