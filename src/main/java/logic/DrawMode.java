package logic;

import javafx.scene.paint.Color;

import java.util.Optional;

public interface DrawMode {

    DrawMode NONE = new None();
    DrawMode CIRCLE = new DrawCircle();
    DrawMode RECT = new DrawRect();

    void start(double x, double y, Color c);
    Optional<Figure> endDraw(double x, double y);
}
