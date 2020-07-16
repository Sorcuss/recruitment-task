package pl.radoslawlapciak.component;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import pl.radoslawlapciak.modelfx.PointFxModel;

import java.util.List;
import java.util.stream.Collectors;

public class PointPanelComponent extends BorderPane {
    private ListProperty<PointFxModel> points = new SimpleListProperty<>();

    private ChangeListener<ObservableList<PointFxModel>> onChangePointListAction = (observable, oldValue, newValue) -> {
        List<Node> nodesToRemove = this.getChildren().stream().filter(node -> node instanceof PointComponent).collect(Collectors.toList());
        this.getChildren().removeAll(nodesToRemove);
        for (PointFxModel point : newValue) {
            this.getChildren().add(new PointComponent(new SimpleObjectProperty<>(point), getWidth(), getHeight(), getTranslateVector()));
        }
    };


    public PointPanelComponent() {
        super();
        points.addListener(onChangePointListAction);
    }


    public ListProperty<PointFxModel> pointsProperty() {
        return points;
    }

    private double[] getTranslateVector() {
        double[] result = new double[2];
        ImageView imageView = (ImageView) this.getChildren().stream().filter(node -> node instanceof ImageView).findAny().orElse(null);
        if (imageView != null) {
            result[0] = imageView.getLayoutX();
            result[1] = imageView.getLayoutY();
        }
        return result;
    }
}
