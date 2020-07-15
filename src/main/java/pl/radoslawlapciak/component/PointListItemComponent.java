package pl.radoslawlapciak.component;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.util.converter.NumberStringConverter;
import pl.radoslawlapciak.modelfx.Point;
import pl.radoslawlapciak.util.AlertUtils;
import pl.radoslawlapciak.util.Validator;


public class PointListItemComponent extends GridPane {

    private TextField xTextField;
    private TextField yTextField;



    public PointListItemComponent(ObjectProperty<Point> pointObjectProperty, DoubleProperty xBound, DoubleProperty yBound) {
        super();
        setStyle("-fx-border-color: black");
        add(new Label("Point id: " + pointObjectProperty.get().getId()), 0, 0, 2, 1);
        setVgap(5);
        setHgap(5);
        GridPane xPane = new GridPane();
        xPane.add(new Label("x="), 0, 0, 1, 1);
        xTextField = new TextField(String.valueOf(pointObjectProperty.get().getX()));
        xPane.add(xTextField, 1, 0, 1, 1);
        add(xPane, 0, 1, 1, 1);
        GridPane yPane = new GridPane();
        yPane.add(new Label("y="), 0, 0, 1, 1);
        yTextField = new TextField(String.valueOf(pointObjectProperty.get().getY()));
        yPane.add(yTextField, 1, 0, 1, 1);
        add(yPane, 1, 1, 1, 1);

        xTextField.textProperty().bindBidirectional(pointObjectProperty.get().xProperty(), new NumberStringConverter());
        yTextField.textProperty().bindBidirectional(pointObjectProperty.get().yProperty(), new NumberStringConverter());

        xTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!Validator.validateTextField(newValue, xBound.get())){
                AlertUtils.showErrorAlert("Error", "Wrong value of coordinate");
                xTextField.textProperty().setValue(oldValue);
            }
        });

        yTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!Validator.validateTextField(newValue, yBound.get())){
                AlertUtils.showErrorAlert("Error", "Wrong value of coordinate");
                yTextField.textProperty().setValue(oldValue);
            }
        });


    }

}
