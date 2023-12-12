package pt.up.model.game.arena;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import pt.up.model.Position;
import pt.up.model.game.elements.*;
import pt.up.model.game.elements.enemy.*;

import java.io.IOException;
import java.util.List;

public class Arena {

    private Hero hero;

    private static List<Alpha> alphas;
    private static List<Beta> betas;
    private static List<Gamma> gammasBottom;
    private static List<Gamma> gammasTop;
    private static Boss boss;

    public void setAlphas(){
        for(int i = 0; i<13; i ++){
            Alpha alpha = new Alpha(2 + i*2, 10);
            alpha.setHealth(1);
            alpha.setPoints(10);
            alphas.add(alpha);
        }
    }

    public void setBetas(){
        for(int i = 0; i<13; i ++){
            Beta beta = new Beta(2 + i*2, 8);
            beta.setHealth(1);
            beta.setPoints(20);
            betas.add(beta);
        }
    }

    public void setGammasBottom(){
        for(int i = 0; i < 13; i++){
            Gamma gammaBottom = new Gamma(2 + 1*2, 6);
            gammaBottom.setHealth(2);
            gammaBottom.setPoints(30);
            gammasBottom.add(gammaBottom);
        }
    }

    public void setGammasTop(){
        for(int i = 0; i < 13; i++){
            Gamma gammaTop = new Gamma(2 + 1*2, 4);
            gammaTop.setHealth(3);
            gammaTop.setPoints(50);
            gammasTop.add(gammaTop);
        }
    }

    public void setBoss(){
        Boss boss = new Boss(2,  2);
        boss.setHealth(5);
        boss.setPoints(200);
        this.boss = boss;
    }

    public void setHero(){
        Hero hero = new Hero(new Position(15,15));
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public static void main(String[] args) {
        Arena arena = new Arena();
        arena.setAlphas();

        Alpha alpha = alphas.get(0);
        System.out.println(alpha);

    }

}
