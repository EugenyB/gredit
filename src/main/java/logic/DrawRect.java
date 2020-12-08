package logic;

import javafx.scene.paint.Color;

import java.util.Optional;

public class DrawRect implements DrawMode {

    private double startX;
    private double startY;
    private Color color;

    @Override
    public void start(double x, double y, Color c) {
        startX = x;
        startY = y;
        color = c;
    }

    @Override
    public Optional<Figure> endDraw(double x, double y) {
        Rectangle rectangle = new Rectangle(Math.min(startX, x), Math.min(startY, y), Math.max(startX, x), Math.max(startY, y), color);
        return Optional.of(rectangle);
    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}
