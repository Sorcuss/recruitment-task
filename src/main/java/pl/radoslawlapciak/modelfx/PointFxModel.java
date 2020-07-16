package pl.radoslawlapciak.modelfx;

import javafx.beans.property.*;

public class PointFxModel {
    private static int nextId = 0;
    private DoubleProperty x = new SimpleDoubleProperty(this, "xProperty");
    private DoubleProperty y = new SimpleDoubleProperty(this, "yProperty");
    private IntegerProperty id = new SimpleIntegerProperty(this, "idProperty");

    public PointFxModel(double x, double y){
        this.x.set(x);
        this.y.set(y);
        this.id.set(nextId++);
    }

    public PointFxModel(DoubleProperty x, DoubleProperty y, IntegerProperty id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public double getX() {
        return x.get();
    }

    public DoubleProperty xProperty() {
        return x;
    }


    public double getY() {
        return y.get();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public int getId() {
        return id.get();
    }

}