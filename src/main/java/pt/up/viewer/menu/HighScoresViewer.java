package pt.up.viewer.menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import pt.up.gui.GUI;
import pt.up.model.menu.HighScoresMenu;
import pt.up.model.menu.Player;
import pt.up.utils.Constants;
import pt.up.viewer.Viewer;

import java.util.List;

public class HighScoresViewer extends Viewer<HighScoresMenu> {

    public HighScoresViewer(HighScoresMenu menu) {
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

    public void drawDescription(GUI gui) {
        gui.drawEscString(1, 1, "<-ESC", TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN, SGR.BLINK);

        HighScoresMenu model = new HighScoresMenu();
        model.readScores();

        List<Player> topPlayers = model.getTopPlayers(5);
        int place = 1;
        int ite = 0;

        for(Player player : topPlayers){
            String line = place + ". " + player.getName() + " " + player.getScore();
            gui.drawString(30, 17 + ite, line, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
            ite += 2;
            place++;
        }

        gui.drawString(5, 30, "You can press ESC to go back to the Main Menu", TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
    }

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui);
        drawSubTitle(gui);
        drawDescription(gui);
    }
}
