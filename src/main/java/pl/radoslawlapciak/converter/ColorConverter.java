package pl.radoslawlapciak.converter;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import pl.radoslawlapciak.model.Color;
import pl.radoslawlapciak.modelfx.ColorFxModel;

public class ColorConverter implements Converter<Color, ColorFxModel> {
    @Override
    public Color convertTo(ColorFxModel obj) {
        double r = obj.getR();
        double g = obj.getG();
        double b = obj.getB();
        return new Color(r, g, b);
    }

    @Override
    public ColorFxModel convertFrom(Color obj) {
        DoubleProperty r = new SimpleDoubleProperty(obj.getR());
        DoubleProperty g = new SimpleDoubleProperty(obj.getG());
        DoubleProperty b = new SimpleDoubleProperty(obj.getB());
        return new ColorFxModel(r, g, b);
    }
}
