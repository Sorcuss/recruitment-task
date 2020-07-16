package pl.radoslawlapciak.component;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.util.converter.NumberStringConverter;
import pl.radoslawlapciak.modelfx.PointFxModel;
import pl.radoslawlapciak.util.AlertUtils;
import pl.radoslawlapciak.util.Validator;


public class PointListItemComponent extends GridPane {

    private TextField xTextField;
    private TextField yTextField;
    DoubleProperty xBound;
    DoubleProperty yBound;

    public PointListItemComponent(ObjectProperty<PointFxModel> pointObjectProperty, DoubleProperty xBound, DoubleProperty yBound) {
        super();
        this.xBound = xBound;
        this.yBound = yBound;
        this.xTextField = new TextField(String.valueOf(pointObjectProperty.get().getX()));
        this.yTextField = new TextField(String.valueOf(pointObjectProperty.get().getY()));

        initStyles();
        addRow(0, new Label("Point id: " + pointObjectProperty.get().getId()));
        add(buildCoordinateGridPane("x=", xTextField), 0, 1);
        add(buildCoordinateGridPane("y=", yTextField), 1, 1);


        xTextField.textProperty().bindBidirectional(pointObjectProperty.get().xProperty(), new NumberStringConverter());
        yTextField.textProperty().bindBidirectional(pointObjectProperty.get().yProperty(), new NumberStringConverter());
        setUpVValidators();
    }

    private void initStyles(){
        setStyle("-fx-border-color: black");
        setVgap(5);
        setHgap(5);
    }

    private GridPane buildCoordinateGridPane(String label, TextField textField){
        GridPane gridPane = new GridPane();
        gridPane.add(new Label(label), 0,0);
        gridPane.add(textField, 1,0);
        return gridPane;
    }

    private void setUpVValidators(){
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