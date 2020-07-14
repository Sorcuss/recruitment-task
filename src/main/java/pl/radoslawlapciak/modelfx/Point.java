package pl.radoslawlapciak.modelfx;

import javafx.beans.property.*;

public class Point {
    private DoubleProperty x = new SimpleDoubleProperty(this, "xProperty");
    private DoubleProperty y = new SimpleDoubleProperty(this, "yProperty");
    private StringProperty id = new SimpleStringProperty(this, "idProperty");



    public double getX() {
        return x.get();
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x.get() +
                ", y=" + y.get() +
                ", id=" + id.get() +
                '}';
    }
}
