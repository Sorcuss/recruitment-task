package pl.radoslawlapciak.component;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class PointComponent extends Circle {

    private int pointId;

    public PointComponent(double centerX, double centerY, double radius, int pointId){
        super(centerX,centerY,radius);
        setFill(Color.RED);
        this.pointId = pointId;
    }

    public int getPointId() {
        return pointId;
    }

}
