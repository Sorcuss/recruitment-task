package pl.radoslawlapciak.component;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import pl.radoslawlapciak.modelfx.Point;


public class PointListComponent extends VBox {

    private ListProperty<Point> points = new SimpleListProperty<>();
    private DoubleProperty xBoundValidationRule = new SimpleDoubleProperty();
    private DoubleProperty yBoundValidationRule = new SimpleDoubleProperty();


    public PointListComponent(){
        super();
        points.addListener((observable, oldValue, newValue) -> {
            this.getChildren().clear();
            for(Point point : newValue){
                this.getChildren().add(new PointListItemComponent(new SimpleObjectProperty<>(point), xBoundValidationRule, yBoundValidationRule));
            }
        });
    }

    public ObservableList<Point> getPoints() {
        return points.get();
    }

    public ListProperty<Point> pointsProperty() {
        return points;
    }

    public void setPoints(ObservableList<Point> points) {
        this.points.set(points);
    }

    public double getXBoundValidationRule() {
        return xBoundValidationRule.get();
    }

    public DoubleProperty xBoundValidationRuleProperty() {
        return xBoundValidationRule;
    }

    public void setXBoundValidationRule(double xBoundValidationRule) {
        this.xBoundValidationRule.set(xBoundValidationRule);
    }

    public double getYBoundValidationRule() {
        return yBoundValidationRule.get();
    }

    public DoubleProperty yBoundValidationRuleProperty() {
        return yBoundValidationRule;
    }

    public void setYBoundValidationRule(double yBoundValidationRule) {
        this.yBoundValidationRule.set(yBoundValidationRule);
    }
}
