package pl.radoslawlapciak.modelfx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ColorFxModel {

    private DoubleProperty r = new SimpleDoubleProperty(this, "rColorValue");
    private DoubleProperty g = new SimpleDoubleProperty(this, "gColorValue");
    private DoubleProperty b = new SimpleDoubleProperty(this, "bColorValue");

    public ColorFxModel() {
        this.r.set(Math.random());
        this.g.set(Math.random());
        this.b.set(Math.random());
    }

    public ColorFxModel(double r, double g, double b) {
        this.r.set(r);
        this.g.set(g);
        this.b.set(b);
    }

    public ColorFxModel(DoubleProperty r, DoubleProperty g, DoubleProperty b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public double getR() {
        return r.get();
    }

    public DoubleProperty rProperty() {
        return r;
    }

    public void setR(double r) {
        this.r.set(r);
    }

    public double getG() {
        return g.get();
    }

    public DoubleProperty gProperty() {
        return g;
    }

    public void setG(double g) {
        this.g.set(g);
    }

    public double getB() {
        return b.get();
    }

    public DoubleProperty bProperty() {
        return b;
    }

    public void setB(double b) {
        this.b.set(b);
    }
}
