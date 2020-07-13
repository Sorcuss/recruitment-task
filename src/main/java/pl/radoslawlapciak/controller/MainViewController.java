package pl.radoslawlapciak.controller;

import com.sun.webkit.dom.KeyboardEventImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pl.radoslawlapciak.control.PointListItem;
import pl.radoslawlapciak.model.Color;
import pl.radoslawlapciak.model.Point;
import pl.radoslawlapciak.model.service.PointService;

import javax.swing.event.DocumentEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainViewController {

    @FXML
    private VBox pointsList;

    @FXML
    private AnchorPane imagesPane;

    @FXML
    private GridPane imageGrid;

    private PointService pointService;

    private List<Circle> circles = new ArrayList<>();

    @FXML
    private void handleLoadImageButtonAction(ActionEvent event) {
        File file = showAndGetFileFromFileChooser("Select an image", "Image files", ".bmp", "*.png", "*.jpg", "*.gif");
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
        Point point = new Point(event.getX(), event.getY(), color);
        pointService.add(point);
        pointsList.getChildren().add(buildListItem(point));
        showPoints();
    }

    private void showPoints() {
            for (Node node : imageGrid.getChildren()) {
                if (node instanceof AnchorPane) {
                    AnchorPane anchorPane = (AnchorPane) node;
                    anchorPane.getChildren().removeAll(circles);
                    for(Point point : pointService.getAll()) {
                        Circle circle = new Circle(point.getX(), point.getY(), 3);
                        circle.setFill(javafx.scene.paint.Color.rgb(point.getColor().getRedColorValue(), point.getColor().getGreenColorValue(), point.getColor().getBlueColorValue()));
                        circles.add(circle);
                        anchorPane.getChildren().add(circle);
                    }
                }

        }
    }

    private File showAndGetFileFromFileChooser(String title, String description, String... extensions) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(description, extensions));
        fileChooser.setTitle(title);
        return fileChooser.showOpenDialog(new Stage());
    }

    private List<ImageView> getAllImageViewsFromGridPane() {
        List<ImageView> imageViews = new ArrayList<>();
        for (Node node : imageGrid.getChildren()) {
            if (node instanceof AnchorPane) {
                for (Node imageView : ((AnchorPane) node).getChildren()) {
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

    private PointListItem buildListItem(Point point){
        PointListItem pointListItem = new PointListItem(point.getId(), point.getX(), point.getY());
        pointListItem.addXTextFieldChangeListener((observable, oldValue, newValue) -> {
            Point pointToChange = pointService.get(pointListItem.getPointId());
            pointToChange.setX(Double.parseDouble(newValue));
            pointService.update(pointToChange);
            showPoints();
        });

        pointListItem.addYTextFieldChangeListener((observable, oldValue, newValue) -> {
            Point pointToChange = pointService.get(pointListItem.getPointId());
            pointToChange.setY(Double.parseDouble(newValue));
            pointService.update(pointToChange);
            showPoints();
        });

        return pointListItem;
    }

}

