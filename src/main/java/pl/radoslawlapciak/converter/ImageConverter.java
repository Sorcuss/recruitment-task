package pl.radoslawlapciak.converter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.radoslawlapciak.model.Image;
import pl.radoslawlapciak.model.Point;
import pl.radoslawlapciak.modelfx.ImageFxModel;
import pl.radoslawlapciak.modelfx.PointFxModel;

import java.util.List;
import java.util.stream.Collectors;

public class ImageConverter implements Converter<Image, ImageFxModel> {

    @Override
    public Image convertTo(ImageFxModel obj) {
        Converter<Point, PointFxModel> pointConverter = new PointConverter();
        byte[] content = obj.getContent();
        List<Point> points = obj.pointListProperty().get()
                .stream()
                .map(pointConverter::convertTo)
                .collect(Collectors.toList());
        return new Image(content, points);
    }

    @Override
    public ImageFxModel convertFrom(Image obj) {
        Converter<Point, PointFxModel> pointConverter = new PointConverter();
        byte [] content = obj.getContent();
        List<PointFxModel> pointList = obj.getPoints()
                .stream()
                .map(pointConverter::convertFrom)
                .collect(Collectors.toList());
        ObservableList<PointFxModel> points = FXCollections.observableArrayList(pointList);
        return new ImageFxModel(content, points);
    }
}
