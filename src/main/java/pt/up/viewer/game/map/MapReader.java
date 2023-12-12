package pt.up.viewer.game.map;

import pt.up.model.Position;
import pt.up.model.game.elements.Hero;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MapReader implements MapBuilder {
    private int height;

    private enum MapElement {
        Hero('c'), INVALID('\0');

        final char symbol;

        MapElement(char symbol) {
            this.symbol = symbol;
        }

        public char getSymbol() {
            return symbol;
        }

        public static MapElement fromChar(char symbol) {
            for (MapElement mapElement : MapElement.values())
                if (mapElement.getSymbol() == symbol)
                    return mapElement;
            return INVALID;
        }
    }

    @Override
    public Map createMap(String mapName) throws IOException {
        Map m = new Map();
        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String mapLocation = rootPath + "/src/main/resources/maps/" + mapName;

        BufferedReader br = Files.newBufferedReader(Paths.get(mapLocation), Charset.defaultCharset());

        int width = Integer.parseInt(br.readLine());
        height = Integer.parseInt(br.readLine());
        m.setSize(width * 12, height * 8);
        readElements(m, br);
        return m;
    }

    @SuppressWarnings("MissingCasesInEnumSwitch")
    private void readElements(Map map, BufferedReader br) throws IOException {
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                switch (MapElement.fromChar(line.charAt(j))) {
                    case Hero -> map.setHero(new Hero(new Position(i * 8, j * 12)));
                }
            }
        }
    }
}

