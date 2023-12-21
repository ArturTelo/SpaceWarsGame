package pt.up.viewer.menu;

import com.googlecode.lanterna.TextColor;
import pt.up.gui.GUI;
import pt.up.model.menu.GameOver;
import pt.up.utils.Constants;
import pt.up.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver gameOver){
        super(gameOver);
    }
    protected void drawGameOver(GUI gui){

        String s1="uu______";
        String s2="u//u____|" ;
        String s3="u||u|uu__uuu____u_u__u__uuuu___";
        String s4="u||u|u|_ |//uu_u|||_u_u_u\\u/u_u\\";
        String s5="u||u|__|u|||u|_||||u|u|u|u|uu__/";
        String s6="uu\\_____/uu\\__,_|||u|_|u|_|\\___|";
        String s7="uuuu______u__uuuuuuu__u___________";
        String s8="uuu/u/u__u\\\\u\\uuuuu/u/uu____|uu__u\\";
        String s9="uu|u|u|uu|u|\\u\\uuu/u/|u|__  |u|__|u|";
        String s10="uu|u|u|uu|u|u\\u\\u/u/u|uu__|u|uu_uu/";
        String s11="uu|u|u|__|u|uu\\u\\u/uu|u|____|u|u\\u\\";
        String s12="uuu\\u\\_____/uuu\\u\\uuu|______|_|uu\\_\\";

        gui.drawString(20, 9, s1, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(20, 10, s2, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(20, 11, s3, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(20, 12, s4, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(20, 13, s5, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(20, 14, s6, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(20, 17, s7, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(20, 18, s8, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(20, 19, s9, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(20, 20, s10, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(20, 21, s11, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
        gui.drawString(20, 22, s12, TextColor.Factory.fromString(Constants.WHITE), TextColor.ANSI.CYAN);
    }
    @Override
    protected void drawElements(GUI gui) {
        drawGameOver(gui);
    }
}
