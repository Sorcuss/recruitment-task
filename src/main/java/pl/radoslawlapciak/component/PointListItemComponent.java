package pl.radoslawlapciak.component;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;
import pl.radoslawlapciak.modelfx.ColorFxModel;
import pl.radoslawlapciak.modelfx.PointFxModel;
import pl.radoslawlapciak.util.AlertUtils;
import pl.radoslawlapciak.util.Validator;


public class PointListItemComponent extends GridPane {

    private TextField xTextField;
    private TextField yTextField;
    DoubleProperty xBound = new SimpleDoubleProperty();
    DoubleProperty yBound = new SimpleDoubleProperty();

    public PointListItemComponent(ObjectProperty<PointFxModel> pointObjectProperty, DoubleProperty xBound, DoubleProperty yBound) {
        super();
        this.xTextField = new TextField(String.valueOf(pointObjectProperty.get().getX()));
        this.yTextField = new TextField(String.valueOf(pointObjectProperty.get().getY()));
        this.xBound.bindBidirectional(xBound);
        this.yBound.bindBidirectional(yBound);

        ColorFxModel color = pointObjectProperty.get().getColor();
        Label label = new Label("Point id: " + pointObjectProperty.get().getId());
        label.setTextFill(Color.color(color.getR(), color.getG(), color.getB()));

        initStyles();
        addRow(0, label);
        add(buildCoordinateGridPane("x=", xTextField), 0, 1);
        add(buildCoordinateGridPane("y=", yTextField), 1, 1);

        setUpValidators();
        xTextField.textProperty().bindBidirectional(pointObjectProperty.get().xProperty(), new NumberStringConverter());
        yTextField.textProperty().bindBidirectional(pointObjectProperty.get().yProperty(), new NumberStringConverter());

    }

    private void initStyles() {
        setStyle("-fx-border-color: black; -fx-background-color: silver; -fx-padding: 5");
        setVgap(10);
        setHgap(10);
    }

    private GridPane buildCoordinateGridPane(String label, TextField textField) {
        GridPane gridPane = new GridPane();
        gridPane.add(new Label(label), 0, 0);
        gridPane.add(textField, 1, 0);
        return gridPane;
    }

    private void setUpValidators() {
        xTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!Validator.validateTextField(newValue, xBound.get())) {
                AlertUtils.showAlert("Error", "Wrong value of coordinate", Alert.AlertType.ERROR);
                xTextField.textProperty().setValue(oldValue);
            }
        });

        yTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!Validator.validateTextField(newValue, yBound.get())) {
                AlertUtils.showAlert("Error", "Wrong value of coordinate", Alert.AlertType.ERROR);
                yTextField.textProperty().setValue(oldValue);
            }
        });

    }
}
