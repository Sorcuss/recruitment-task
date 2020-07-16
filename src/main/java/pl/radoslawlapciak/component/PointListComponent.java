package pl.radoslawlapciak.component;

import javafx.beans.property.*;

import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import pl.radoslawlapciak.modelfx.PointFxModel;


public class PointListComponent extends VBox {

    private ListProperty<PointFxModel> points = new SimpleListProperty<>();
    private DoubleProperty xBoundValidationRule = new SimpleDoubleProperty();
    private DoubleProperty yBoundValidationRule = new SimpleDoubleProperty();

    private ChangeListener<ObservableList<PointFxModel>> onChangePointListAction = (observable, oldValue, newValue) -> {
        this.getChildren().clear();
        for (PointFxModel point : newValue) {
            this.getChildren().add(new PointListItemComponent(new SimpleObjectProperty<>(point), xBoundValidationRule, yBoundValidationRule));
        }
    };

    public PointListComponent() {
        super();
        setSpacing(5);
        points.addListener(onChangePointListAction);
    }

    public ListProperty<PointFxModel> pointsProperty() {
        return points;
    }

    public void setXBoundValidationRule(double xBoundValidationRule) {
        this.xBoundValidationRule.set(xBoundValidationRule);
    }


    public void setYBoundValidationRule(double yBoundValidationRule) {
        this.yBoundValidationRule.set(yBoundValidationRule);
    }
}
