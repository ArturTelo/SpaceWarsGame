package pt.up.viewer.menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import pt.up.model.menu.CreditsMenuModel;
import pt.up.utils.Constants;
import pt.up.viewer.Viewer;

import java.io.IOException;

public class CreditsMenuViewer extends Viewer {

    public CreditsMenuViewer(CreditsMenuModel model, Screen screen) {
        super(model, screen);
    }

    public void drawTitle() {
        String s1 = "  ________  _______      ____      ______  _________ ";
        String s2 = " / _______| | _____ \\   /    \\    / _____)|  _______|";
        String s3 = "|________|  | _____) ) / ____ \\  ( (      | |_______ ";
        String s4 = " ________ \\ | ______/ / /    \\ \\ \\ \\_____ |  _______|";
        String s5 = "|________/  | |      /_/      \\_\\ \\______)| |_______|";

        graphics.setForegroundColor(TextColor.Factory.fromString(Constants.WHITE));
        graphics.setBackgroundColor(TextColor.ANSI.CYAN);
        graphics.putString(12, 4, s1);
        graphics.putString(12, 5, s2);
        graphics.putString(12, 6, s3);
        graphics.putString(12, 7, s4);
        graphics.putString(12, 8, s5);
    }

    public void drawSubTitle() {
        String w1 = "__        __       __   ____     _______    ________";
        String w2 = "\\ \\      /  \\     / /  /    \\   |  __  _|  / _______|";
        String w3 = " \\ \\    / /\\     / /  / ____ \\  | |__| |  |________|";
        String w4 = "  \\ \\  / /  \\   / /  / /    \\ \\ |  __  /   ________ \\";
        String w5 = "   \\ \\/ /    \\_/ /  /_/      \\_\\| |  \\ \\  |________/";

        graphics.setForegroundColor(TextColor.Factory.fromString(Constants.YELLOW));
        graphics.setBackgroundColor(TextColor.ANSI.CYAN);
        graphics.putString(12, 9, w1);
        graphics.putString(12, 10, w2);
        graphics.putString(12, 11, w3);
        graphics.putString(12, 12, w4);
        graphics.putString(12, 13, w5);
    }

    @Override
    public void draw() throws IOException {
        drawTitle();
        drawSubTitle();
        graphics.setForegroundColor(TextColor.Factory.fromString(Constants.WHITE));
        graphics.setBackgroundColor(TextColor.ANSI.CYAN);
        graphics.putString(1, 1, "<-ESC", SGR.BLINK);

        graphics.putString(35, 20, "Artur Telo");
        graphics.putString(35, 22, "Margarida Fonseca");
        graphics.putString(35, 24, "Nuno França");
        graphics.putString(5, 35, "You can press ESC to go back to the Main Menu");
        screen.refresh();
    }
}
