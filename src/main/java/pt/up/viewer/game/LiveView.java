package pt.up.viewer.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import pt.up.model.game.elements.Hero;
import pt.up.utils.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LiveView extends View {
    static final int height = 2, width = 2;
    final List<String[]> numbers;
    final Hero hero;

    public LiveView(Hero hero, TextGraphics graphics) {
        super(graphics);
        this.hero = hero;
        numbers = new ArrayList<>();
        try {
            loadNumbers();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void draw() {
        drawLives();

        int heroScore = hero.getScore();

        String score = String.format("%05d", heroScore);
        int col = 130;
        for (char digit : score.toCharArray()) {
            int n = Integer.parseInt(digit + "");
            drawNumber(n, 10, col + 7);
            col += numbers.get(n)[0].length() * width + 3;
        }
    }


    public void loadNumbers() throws IOException {
        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String mapLocation = rootPath + "/src/main/resources/numbers.font";
        BufferedReader br = Files.newBufferedReader(Paths.get(mapLocation), Charset.defaultCharset());
        int height = Integer.parseInt(br.readLine());

        for (int n = 0; n <= 9; n++) {
            String[] number = new String[height];
            for (int i = 0; i < height; i++) {
                number[i] = br.readLine();
            }
            numbers.add(number);
        }
    }

    public void drawNumber(int number, int terminalRow, int terminalCol) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(Constants.GREEN));

        String[] numberDraw = getNumbers().get(number);
        for (int row = 0; row < numberDraw.length; row++) {
            for (int col = 0; col < numberDraw[row].length(); col++) {
                if (numberDraw[row].charAt(col) == '#') {
                    fillTheRectangles(terminalCol + col * width, terminalRow + row * height);
                }
            }
        }
    }

    public void drawLives() {
        graphics.setBackgroundColor(TextColor.Factory.fromString(Constants.WHITE));

        int y = 0;
        for (String s : LIVES) {
            for (int x = 0; x < s.length(); x++) {
                if (s.charAt(x) == '#')
                    fillTheRectangles(600 + x * width, 4 + y * height + 6);
            }
            y++;
        }
    }

    public void fillTheRectangles(int x, int y) {
        graphics.fillRectangle(new TerminalPosition(x, y), new TerminalSize(width, height), ' ');
    }

    public List<String[]> getNumbers() {
        return numbers;
    }

    public static final String[] LIVES = {
            "#       ## #        #  ######   ###",
            "#       ## ##      ##  ##      ##",
            "#       ##  ##    ##   #####       ##",
            "#       ##   ##  ##    ##        ##",
            "####### ##    ####     ######  ##"
    };
}
