package pl.radoslawlapciak.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainViewController {

    @FXML
    private AnchorPane imagesPane;

    @FXML
    private GridPane imageGrid;

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
        for (Node node : imageGrid.getChildren()) {
            if (node instanceof AnchorPane) {
                Circle circle = new Circle(event.getX() + 5, event.getY() + 5, 5);
                circle.setFill(Color.RED);
                AnchorPane anchorPane = (AnchorPane) node;
                anchorPane.getChildren().add(circle);
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

}

