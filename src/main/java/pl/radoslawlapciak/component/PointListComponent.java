package pl.radoslawlapciak.component;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import pl.radoslawlapciak.modelfx.Point;


public class PointListComponent extends VBox {

    private ListProperty<Point> points = new SimpleListProperty<>();

    public PointListComponent(){
        super();
        points.addListener((observable, oldValue, newValue) -> {
            this.getChildren().clear();
            for(Point point : newValue){
                this.getChildren().add(new PointListItem(new SimpleObjectProperty<>(point)));
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
}
