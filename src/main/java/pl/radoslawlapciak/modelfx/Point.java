package pl.radoslawlapciak.modelfx;

import javafx.beans.property.*;

public class Point {
    private static int nextId = 0;
    private DoubleProperty x = new SimpleDoubleProperty(this, "xProperty");
    private DoubleProperty y = new SimpleDoubleProperty(this, "yProperty");
    private IntegerProperty id = new SimpleIntegerProperty(this, "idProperty");

    public Point(double x, double y){
        this.x.set(x);
        this.y.set(y);
        this.id.set(nextId++);
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
