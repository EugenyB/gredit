package logic;

import javafx.scene.paint.Color;

import java.util.Optional;

public class None implements DrawMode {
    @Override
    public void start(double x, double y, Color c) {

    }

    @Override
    public Optional<Figure> endDraw(double x, double y) {
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "---";
    }
}
