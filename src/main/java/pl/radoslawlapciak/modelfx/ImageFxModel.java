package pl.radoslawlapciak.modelfx;


import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ImageFxModel {
    private byte[] content;
    private ObservableList<PointFxModel> points = FXCollections.observableArrayList();
    private ListProperty<PointFxModel> pointList = new SimpleListProperty<>();

    public ImageFxModel() {
        this.pointList.set(this.points);
    }

    public ImageFxModel(byte[] content, ObservableList<PointFxModel> points) {
        this.content = content;
        this.points = points;
        this.pointList.set(this.points);
    }

    public void setImageFromFile(File file) throws IOException {
        content = Files.readAllBytes(file.toPath());
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public ListProperty<PointFxModel> pointListProperty() {
        return pointList;
    }

    public void addPoint(PointFxModel point){
        points.add(point);
    }


}
