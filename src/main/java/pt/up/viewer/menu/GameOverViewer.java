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

        String s1="  ______";
        String s2=" // ____|" ;
        String s3=" || |  __   ____ _ __ __    ___";
        String s4=" || | |_ |//  _ ||'_ ` _ \\ / _ \\";
        String s5=" || |__| ||| (_|||| | | | |  __/";
        String s6="  \\_____/  \\__,_||| |_| |_|\\___|";
        String s7="    ______ __      __   __________";
        String s8="   / / __ \\\\ \\     / /  ____|  __ \\";
        String s9="  | | |  | |\\ \\   / /| |__  | |__) |";
        String s10="  | | |  | | \\ \\ / / |  __| |  _  /";
        String s11="  | | |__| |  \\ \\ /  | |____| | \\ \\";
        String s12="   \\ \\_____/   \\ \\   |______|_|  \\_\\";

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
