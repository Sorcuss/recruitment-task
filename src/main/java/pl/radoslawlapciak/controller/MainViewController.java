package pl.radoslawlapciak.controller;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pl.radoslawlapciak.component.PointListComponent;
import pl.radoslawlapciak.component.PointPanelComponent;
import pl.radoslawlapciak.controller.util.FileUtils;
import pl.radoslawlapciak.model.Color;
import pl.radoslawlapciak.model.service.PointService;
import pl.radoslawlapciak.modelfx.Point;
import pl.radoslawlapciak.modelfx.Points;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainViewController {

    @FXML
    private PointListComponent pointsList;

    @FXML
    private GridPane imageGrid;

    private PointService pointService;

    Points points = new Points();

    @FXML
    private void initialize(){
        pointsList.pointsProperty().bindBidirectional(points.pointListProperty());
        for (Node node : imageGrid.getChildren()) {
            if (node instanceof PointPanelComponent) {
                PointPanelComponent pointPanelComponent = (PointPanelComponent) node;
                pointPanelComponent.pointsProperty().bindBidirectional(points.pointListProperty());
            }
        }

    }

    @FXML
    private void handleLoadImageButtonAction(ActionEvent event) {
        File file = FileUtils.showAndGetFileFromFileChooser("Select an image", "Image files", ".bmp", "*.png", "*.jpg", "*.gif");
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            for (ImageView imageView : getAllImageViewsFromGridPane()) {
                imageView.setImage(image);
            }
        }
    }

    @FXML
    private void handleImageClick(MouseEvent event) {
        event.consume();
        Color color = new Color((short) 255, (short) 0, (short) 0);
        Point point = new Point();
        point.setX(event.getX());
        point.setY(event.getY());
        point.setId("1");
        points.addPoint(point);
    }


    private List<ImageView> getAllImageViewsFromGridPane() {
        List<ImageView> imageViews = new ArrayList<>();
        for (Node node : imageGrid.getChildren()) {
            if (node instanceof PointPanelComponent) {
                for (Node imageView : ((PointPanelComponent) node).getChildren()) {
                    if (imageView instanceof ImageView) {
                        imageViews.add((ImageView) imageView);
                    }
                }
            }
        }
        return imageViews;
    }

    public void setPointService(PointService pointService) {
        this.pointService = pointService;
    }

}

