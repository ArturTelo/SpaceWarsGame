package pt.up.viewer.menu;

import com.googlecode.lanterna.TextColor;
import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.menu.MainMenu;
import pt.up.utils.Constants;
import pt.up.viewer.Viewer;

public class MenuViewer extends Viewer<MainMenu> {

    public MenuViewer(MainMenu menu) {
        super(menu);
    }

    public void drawTitle(GUI gui) {
        String s1 = "  ________  _______      ____      ______  _________ ";
        String s2 = " / _______| | _____ \\   /    \\    / _____)|  _______|";
        String s3 = "|________|  | _____) ) / ____ \\  ( (      | |_______ ";
        String s4 = " ________ \\ | ______/ / /    \\ \\ \\ \\_____ |  _______|";
        String s5 = "|________/  | |      /_/      \\_\\ \\______)| |_______|";

        gui.drawString(12, 4, s1, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(12, 5, s2, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(12, 6, s3, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(12, 7, s4, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(12, 8, s5, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
    }

    public void drawSubTitle(GUI gui) {
        String w1 = "__        __       __   ____     _______    ________";
        String w2 = "\\ \\      /  \\     / /  /    \\   |  __  _|  / _______|";
        String w3 = " \\ \\    / /\\     / /  / ____ \\  | |__| |  |________|";
        String w4 = "  \\ \\  / /  \\   / /  / /    \\ \\ |  __  /   ________ \\";
        String w5 = "   \\ \\/ /    \\_/ /  /_/      \\_\\| |  \\ \\  |________/";

        gui.drawString(12, 9, w1, TextColor.Factory.fromString(Constants.YELLOW), TextColor.ANSI.CYAN);
        gui.drawString(12, 10, w2, TextColor.Factory.fromString(Constants.YELLOW), TextColor.ANSI.CYAN);
        gui.drawString(12, 11, w3, TextColor.Factory.fromString(Constants.YELLOW), TextColor.ANSI.CYAN);
        gui.drawString(12, 12, w4, TextColor.Factory.fromString(Constants.YELLOW), TextColor.ANSI.CYAN);
        gui.drawString(12, 13, w5, TextColor.Factory.fromString(Constants.YELLOW), TextColor.ANSI.CYAN);
    }

    public void drawOptions(GUI gui) {
        int y = 25;

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position((80 - getModel().getEntry(i).length()) / 2, y + i * 2),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? Constants.YELLOW : Constants.WHITE
            );
        }
    }

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui);
        drawSubTitle(gui);
        drawOptions(gui);
    }
}
