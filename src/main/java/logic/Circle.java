package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Figure {
    private double x, y, radius;

    public Circle(double x, double y, double radius, Color color) {
        super(color);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(getColor());
        if (isSelected()) {
            gc.setLineDashes(4, 4);
        } else gc.setLineDashes(null);
        gc.strokeOval(x-radius, y-radius, 2*radius, 2*radius);
    }

    @Override
    public String toString() {
        return String.format("Circle(%3.1f;%3.1f;%3.1f - (%3.1f;%3.1f;%3.1f))", x, y, radius, getColor().getRed(), getColor().getGreen(), getColor().getBlue());
    }
}
