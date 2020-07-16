package pl.radoslawlapciak.component;

import javafx.beans.property.ObjectProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.radoslawlapciak.modelfx.ColorFxModel;
import pl.radoslawlapciak.modelfx.PointFxModel;
import pl.radoslawlapciak.util.Constants;
import pl.radoslawlapciak.util.Validator;


public class PointComponent extends Circle {


    public PointComponent(ObjectProperty<PointFxModel> pointObjectProperty, double xBound, double yBound, double[] translateVector) {
        super(pointObjectProperty.get().getX(), pointObjectProperty.get().getY(), Constants.RADIUS);

        ColorFxModel color = pointObjectProperty.get().getColor();
        setFill(Color.color(color.getR(), color.getG(), color.getB()));
        centerXProperty().bindBidirectional(pointObjectProperty.get().xProperty());
        centerYProperty().bindBidirectional(pointObjectProperty.get().yProperty());
        setTranslateX(translateVector[0]);
        setTranslateY(translateVector[1]);

        setOnMouseDragged(event -> {
            double x = event.getX();
            double y = event.getY();
            if (Validator.checkCoordinateBoundBounds(x, xBound - 2 * translateVector[0])) {
                setCenterX(event.getX());
            }
            if (Validator.checkCoordinateBoundBounds(y, yBound - 2 * translateVector[1])) {
                setCenterY(event.getY());
            }
        });
    }

}
