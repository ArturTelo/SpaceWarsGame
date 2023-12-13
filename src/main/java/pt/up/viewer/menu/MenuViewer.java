package pt.up.viewer.menu;

import pt.up.gui.GUI;
import pt.up.model.Position;
import pt.up.model.menu.MainMenu;
import pt.up.viewer.Viewer;

public class MenuViewer extends Viewer<MainMenu> {
    public MenuViewer(MainMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(0,0),"X","#FFFFFF");
        gui.drawText(new Position(0,5),"X","#FFFFFF");
        gui.drawText(new Position(23,59),"X","#FFFFFF");
        gui.drawText(new Position(23,57),"X","#FFFFFF");



        String s1 = "  ________  _______      ____      ______  _________ ";
        String s2 = " / _______| | _____ \\   /    \\    / _____)|  _______|";
        String s3 = "|________|  | _____) ) / ____ \\  ( (      | |_______ ";
        String s4 = " ________ \\ | ______/ / /    \\ \\ \\ \\_____ |  _______|";
        String s5 = "|________/  | |      /_/      \\_\\ \\______)| |_______|";
        gui.drawText(new Position(3, 0), s1, "#FFFFFF");
        gui.drawText(new Position( 3,1), s2, "#FFFFFF");
        gui.drawText(new Position( 3,2), s3, "#FFFFFF");
        gui.drawText(new Position( 3,3), s4, "#FFFFFF");
        gui.drawText(new Position(3,4), s5, "#FFFFFF");
        String w1 = "__        __       __   ____     _______    ________";
        String w2 = "\\ \\      /  \\     / /  /    \\   |  __  _|  / _______|";
        String w3 = " \\ \\    / /\\     / /  / ____ \\  | |__| |  |________|";
        String w4 = "  \\ \\  / /  \\   / /  / /    \\ \\ |  __  /   ________ \\";
        String w5 = "   \\ \\/ /    \\_/ /  /_/      \\_\\| |  \\ \\  |________/";
        gui.drawText(new Position(3, 6), w1, "#FFFFFF");
        gui.drawText(new Position(3, 7), w2, "#FFFFFF");
        gui.drawText(new Position(3, 8), w3, "#FFFFFF");
        gui.drawText(new Position(3, 9), w4, "#FFFFFF");
        gui.drawText(new Position(3, 10), w5, "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText( new Position(30,  15+ i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
