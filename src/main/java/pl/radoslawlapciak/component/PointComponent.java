package pl.radoslawlapciak.component;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.radoslawlapciak.modelfx.Point;


public class PointComponent extends Circle {


    public PointComponent(ObjectProperty<Point> pointObjectProperty, double xBound, double yBound) {
        super(pointObjectProperty.get().getX(),pointObjectProperty.get().getY(), 3);
        setFill(Color.RED);
        centerXProperty().bindBidirectional(pointObjectProperty.get().xProperty());
        centerYProperty().bindBidirectional(pointObjectProperty.get().yProperty());

        setOnMouseDragged(event -> {
            double radius = getRadius();
            double x = event.getX();
            double y = event.getY();
            if(x <= xBound - radius && x >= 0 + radius) {
                setCenterX(event.getX());
            }
            if(y <= yBound - radius && y >= 0 + radius) {
                setCenterY(event.getY());
            }
        });
    }

}
