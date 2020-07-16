package pl.radoslawlapciak.converter;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import pl.radoslawlapciak.model.Point;
import pl.radoslawlapciak.modelfx.PointFxModel;

public class PointConverter implements Converter<Point, PointFxModel> {

    @Override
    public Point convertTo(PointFxModel obj) {
        double x = obj.getX();
        double y = obj.getY();
        int id = obj.getId();
        return new Point(x, y, id);
    }

    @Override
    public PointFxModel convertFrom(Point obj) {
        DoubleProperty x = new SimpleDoubleProperty(obj.getX());
        DoubleProperty y = new SimpleDoubleProperty(obj.getY());
        IntegerProperty id = new SimpleIntegerProperty(obj.getId());
        return new PointFxModel(x, y, id);
    }
}
