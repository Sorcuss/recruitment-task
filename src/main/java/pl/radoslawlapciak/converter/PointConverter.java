package pl.radoslawlapciak.converter;


import javafx.beans.property.*;
import pl.radoslawlapciak.model.Color;
import pl.radoslawlapciak.model.Point;
import pl.radoslawlapciak.modelfx.ColorFxModel;
import pl.radoslawlapciak.modelfx.PointFxModel;

public class PointConverter implements Converter<Point, PointFxModel> {

    @Override
    public Point convertTo(PointFxModel obj) {
        Converter<Color, ColorFxModel> converter = new ColorConverter();
        double x = obj.getX();
        double y = obj.getY();
        int id = obj.getId();
        Color color = converter.convertTo(obj.getColor());
        return new Point(x, y, id, color);
    }

    @Override
    public PointFxModel convertFrom(Point obj) {
        Converter<Color, ColorFxModel> converter = new ColorConverter();
        DoubleProperty x = new SimpleDoubleProperty(obj.getX());
        DoubleProperty y = new SimpleDoubleProperty(obj.getY());
        IntegerProperty id = new SimpleIntegerProperty(obj.getId());
        ObjectProperty<ColorFxModel> color = new SimpleObjectProperty<>(converter.convertFrom(obj.getColor()));
        return new PointFxModel(x, y, id, color);
    }
}
