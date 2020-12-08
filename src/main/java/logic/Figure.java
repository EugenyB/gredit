package logic;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Figure {
    private Color color;
    private boolean selected;

    public Figure(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public abstract void draw(GraphicsContext gc);
}
