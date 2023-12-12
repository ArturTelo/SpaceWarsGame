package pt.up.viewer.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import pt.up.model.game.elements.Hero;
import pt.up.utils.Constants;

public class HeroViewer extends View {

    private final Hero hero;

    public HeroViewer(Hero hero, TextGraphics graphics) {
        super(graphics);
        this.hero = hero;
    }

    @Override
    public void draw() {
        graphics.setBackgroundColor(TextColor.Factory.fromString(Constants.YELLOW));

        int y = 0;
        for (String s : HERO){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == '#')
                    graphics.fillRectangle(new TerminalPosition(hero.getPosition().getY() + x *2 + 2 , hero.getPosition().getX() + y + 2),  new TerminalSize(2, 1), ' ');
            }
            y++;
        }
    }

    public static final String[] HERO = {
            "     ####",
            "   ###  ###",
            "  ####  ####",
            " #####  #####",
            " ###### ######",
            " ###### ######",
            "  ###########",
            "  ###########",
            "   #########",
            "     #####",

    };

}
