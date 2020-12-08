package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Figure {

    private double x1,y1,x2,y2;

    public Rectangle(double x1, double y1, double x2, double y2, Color color) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(getColor());
        if (isSelected()) {
            gc.setLineDashes(4, 4);
        } else gc.setLineDashes(null);
        gc.strokeRect(x1, y1, x2-x1, y2-y1);
    }

    @Override
    public String toString() {
        return String.format("Rectangle(%3.1f;%3.1f;%3.1f;%3.1f - (%3.1f;%3.1f;%3.1f))", x1, y1, x2, y2, getColor().getRed(), getColor().getGreen(), getColor().getBlue());
    }
}
