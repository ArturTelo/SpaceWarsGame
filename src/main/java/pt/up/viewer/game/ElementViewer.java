package pt.up.viewer.game;
import pt.up.gui.GUI;
import pt.up.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
