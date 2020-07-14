package pl.radoslawlapciak.component;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.util.converter.NumberStringConverter;
import pl.radoslawlapciak.modelfx.Point;

public class PointListItem extends GridPane {

    private TextField xTextField;
    private TextField yTextField;
    private int pointId;

    public PointListItem(ObjectProperty<Point> pointObjectProperty) {
        super();
        setStyle("-fx-border-color: black");
        add(new Label("Point id: " + pointId), 0, 0, 2, 1);
        setVgap(5);
        setHgap(5);
        GridPane xPane = new GridPane();
        xPane.add(new Label("x="), 0, 0, 1, 1);
        xTextField = new TextField(String.valueOf(pointObjectProperty.get().getX()));
        xPane.add(xTextField, 1, 0, 1, 1);
        add(xPane, 0,1,1,1);
        GridPane yPane = new GridPane();
        yPane.add(new Label("y="), 0, 0, 1, 1);
        yTextField = new TextField(String.valueOf(pointObjectProperty.get().getY()));
        yPane.add(yTextField, 1, 0, 1, 1);
        add(yPane, 1,1,1,1);

        xTextField.textProperty().bindBidirectional(pointObjectProperty.get().xProperty(), new NumberStringConverter());
        yTextField.textProperty().bindBidirectional(pointObjectProperty.get().yProperty(), new NumberStringConverter());


    }

    public void addXTextFieldChangeListener(ChangeListener<String> changeListener){
        xTextField.textProperty().addListener(changeListener);
    }

    public void addYTextFieldChangeListener(ChangeListener<String> changeListener){
        yTextField.textProperty().addListener(changeListener);
    }

    public TextField getXTextField() {
        return xTextField;
    }

    public TextField getYTextField() {
        return yTextField;
    }

    public int getPointId() {
        return pointId;
    }
}
