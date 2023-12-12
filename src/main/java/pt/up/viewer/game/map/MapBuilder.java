package pt.up.viewer.game.map;

import java.io.IOException;

public interface MapBuilder {
    Map createMap(String mapName) throws IOException;
}
