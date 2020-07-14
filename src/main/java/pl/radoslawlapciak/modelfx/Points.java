package pl.radoslawlapciak.modelfx;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Points {
    private ObservableList<Point> points = FXCollections.observableArrayList();
    private ListProperty<Point> pointList = new SimpleListProperty<>();

    public Points() {
        this.pointList.set(this.points);
    }

    public void addPoint(Point point){
        points.add(point);
    }

    public ObservableList<Point> getPoints() {
        return points;
    }

    public void setPoints(ObservableList<Point> points) {
        this.points = points;
    }

    public ObservableList<Point> getPointList() {
        return pointList.get();
    }

    public ListProperty<Point> pointListProperty() {
        return pointList;
    }

    public void setPointList(ObservableList<Point> pointList) {
        this.pointList.set(pointList);
    }
}
