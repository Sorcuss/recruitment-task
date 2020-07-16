package pl.radoslawlapciak.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "point")
@XmlAccessorType(XmlAccessType.FIELD)
public class Point implements Serializable {

    @XmlElement
    private double x;

    @XmlElement
    private double y;

    @XmlAttribute
    private int id;

    public Point(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
