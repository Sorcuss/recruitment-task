package pl.radoslawlapciak.model;

import java.util.Objects;

public class Point implements Identifiable{
    private static int nextId = 0;

    private int id;
    private double x;
    private double y;
    private Color color;

    public Point(double x, double y, Color color) {
        this.id = nextId++;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return getId() == point.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
