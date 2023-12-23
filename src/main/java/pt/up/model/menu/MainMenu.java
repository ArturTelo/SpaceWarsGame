package pt.up.model.menu;

import pt.up.utils.Configuration;

import java.util.Arrays;
import java.util.List;

public class MainMenu {
    public List<String> entries;
    public int currentEntry = 0;

    public MainMenu() {
        this.entries = Arrays.asList("PLAY", "HIGHSCORES", "CREDITS", "EXIT");

        if (!Configuration.getInstance().getMenuMusic().isPlaying()) {
            Configuration.getInstance().stopAllMusic();
            Configuration.getInstance().getMenuMusic().start();
        }
    }

    public void nextEntry() {
        currentEntry++;

        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;

        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedPlay() {
        return isSelected(0);
    }

    public boolean isSelectedHighScore() {
        return isSelected(1);
    }

    public boolean isSelectedCredits() {
        return isSelected(2);
    }

    public boolean isSelectedExit() {
        return isSelected(3);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
    public void setEntries(List<String> entries) {
        this.entries.clear();
        this.entries.addAll(entries);
    }
}
