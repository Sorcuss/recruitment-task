package pl.radoslawlapciak.component;

import javafx.beans.property.ObjectProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.radoslawlapciak.modelfx.PointFxModel;
import pl.radoslawlapciak.util.Constants;
import pl.radoslawlapciak.util.Validator;


public class PointComponent extends Circle {


    public PointComponent(ObjectProperty<PointFxModel> pointObjectProperty, double xBound, double yBound) {
        super(pointObjectProperty.get().getX(),pointObjectProperty.get().getY(), Constants.RADIUS);
        setFill(Color.RED);

        centerXProperty().bindBidirectional(pointObjectProperty.get().xProperty());
        centerYProperty().bindBidirectional(pointObjectProperty.get().yProperty());

        setOnMouseDragged(event -> {
            double x = event.getX();
            double y = event.getY();
            if(Validator.checkCoordinateBoundBounds(x, xBound)) {
                setCenterX(event.getX());
            }
            if(Validator.checkCoordinateBoundBounds(y, yBound)) {
                setCenterY(event.getY());
            }
        });
    }

}
