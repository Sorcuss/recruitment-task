package pl.radoslawlapciak.control;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PointListItem extends GridPane {
    public PointListItem(int pointId, double x, double y) {
        super();
        setStyle("-fx-border-color: black");

        add(new Label("Point id: " + pointId), 0, 0, 2, 1);
        setVgap(5);
        setHgap(5);
        GridPane xPane = new GridPane();
        xPane.add(new Label("x="), 0, 0, 1, 1);
        xPane.add(new TextField(String.valueOf(x)), 1, 0, 1, 1);
        add(xPane, 0,1,1,1);
        GridPane yPane = new GridPane();
        yPane.add(new Label("y="), 0, 0, 1, 1);
        yPane.add(new TextField(String.valueOf(y)), 1, 0, 1, 1);
        add(yPane, 1,1,1,1);

    }
}
