package pl.radoslawlapciak.component;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import pl.radoslawlapciak.modelfx.Point;

import java.util.List;
import java.util.stream.Collectors;

public class PointPanelComponent extends AnchorPane {
    private ListProperty<Point> points = new SimpleListProperty<>();

    public PointPanelComponent(){
        super();
        points.addListener((observable, oldValue, newValue) -> {
            List<Node> nodesToRemove = this.getChildren().stream().filter(node -> node instanceof PointComponent).collect(Collectors.toList());
            this.getChildren().removeAll(nodesToRemove);
            for(Point point : newValue){
                this.getChildren().add(new PointComponent(new SimpleObjectProperty<>(point), getWidth(), getHeight()));
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
