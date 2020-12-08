package main;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.DrawCircle;
import logic.DrawMode;
import logic.Figure;
import logic.None;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {
    @FXML private ListView<Figure> figureList;
    @FXML private ColorPicker colorPicker;
    @FXML private ComboBox<DrawMode> modeBox;
    @FXML private Pane pane;
    @FXML private Canvas canvas;

    private DrawMode mode = DrawMode.NONE;

    private List<Figure> figures = new ArrayList<>();

    public void initialize() {
        modeBox.setItems(FXCollections.observableArrayList(DrawMode.NONE, DrawMode.CIRCLE, DrawMode.RECT));
        modeBox.getSelectionModel().select(mode);
        colorPicker.setValue(Color.BLACK);
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());
        canvas.widthProperty().addListener(e->draw());
        canvas.heightProperty().addListener(e->draw());

        figureList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue!=null) oldValue.setSelected(false);
            if (newValue!=null) newValue.setSelected(true);
            draw();
        });
        //draw();
    }


    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Figure figure : figures) {
            figure.draw(gc);
        }
    }

    public void startDraw(MouseEvent mouseEvent) {
        mode.start(mouseEvent.getX(), mouseEvent.getY(), colorPicker.getValue());
    }

    public void endDraw(MouseEvent mouseEvent) {
        Optional<Figure> figure = mode.endDraw(mouseEvent.getX(), mouseEvent.getY());
        figure.ifPresent(f -> {
            figures.add(f);
            figureList.setItems(FXCollections.observableList(figures));
        });
        draw();
    }

    public void changeMode() {
        mode = modeBox.getValue();
    }
}
