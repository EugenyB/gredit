package logic;

import javafx.scene.paint.Color;

import java.util.Optional;

public class DrawCircle implements DrawMode {

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
        Circle circle = new Circle(startX, startY, Math.hypot(x - startX, y - startY), color);
        return Optional.of(circle);
    }

    @Override
    public String toString() {
        return "Circle";
    }
}
