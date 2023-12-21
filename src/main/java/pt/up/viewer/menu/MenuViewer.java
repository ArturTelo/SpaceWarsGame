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
        String s1 = "uu________uu_______uuuuuu____uuuuuu______uu_________u";
        String s2 = "u/u_______|u|u_____u\\uuu/uuuu\\uuuu/u_____||uu_______|";
        String s3 = "|________|uu|u_____|u|u/u____u\\uu|u|uuuuuu|u|_______u";
        String s4 = "u________u\\u|u______/u/u/uuuu\\u\\u\\u______u|u|_______|";
        String s5 = "|________/uu|u|uuuuuu/_/uuuuuu\\_\\u\\______||u|_______|";

        gui.drawString(12, 4, s1, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(12, 5, s2, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(12, 6, s3, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(12, 7, s4, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(12, 8, s5, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
    }

    public void drawSubTitle(GUI gui) {
        String w1 = "__uuuuuuuu__uuuuuuu__uuu____uuuuu_______uuuu________";
        String w2 = "\\u\\uuuuuu/uu\\uuuuu/u/uu/uuuu\\uuu|uu__uu_|uu/u_______|";
        String w3 = "u\\u\\uuuu/u/\\uuuuu/u/uu/u____u\\uu|u|__|u|uu|________|";
        String w4 = "uu\\u\\uu/u/uu\\uuu/u/uu/u/uuuu\\u\\u|uu__uu/uuu________u\\";
        String w5 = "uuu\\u\\/u/uuuu\\_/u/uu/_/uuuuuu\\_\\|u|uu\\u\\uu|________/";

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
