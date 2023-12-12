package pt.up.controller;

import com.googlecode.lanterna.input.KeyStroke;
import pt.up.model.game.elements.GameModel;
import pt.up.model.game.elements.Hero;

import static java.lang.System.exit;

public class PlayerController implements Observer {
    private final Hero hero;
    private final GameModel gameModel;

    public PlayerController(Hero hero, GameModel gameModel){
        this.hero = hero;
        this.gameModel=gameModel;
    }

    public Hero getHero() {
        return hero;
    }

    @Override
    @SuppressWarnings("MissingCasesInEnumSwitch")
    public void handleKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp    :
               hero.moveUp();
                break;
            case ArrowDown  :
                hero.moveDown();
                break;
            case ArrowLeft  :
                hero.moveLeft();
                break;
            case ArrowRight :
                hero.moveRight();
                break;
            case Character :
                if(key.getCharacter()=='x' ||  key.getCharacter()=='X')
                    exit(0);
                break;
            case Enter:
                gameModel.setRunning(false);
                gameModel.setLost(true);
                break;
        }
    }
}
