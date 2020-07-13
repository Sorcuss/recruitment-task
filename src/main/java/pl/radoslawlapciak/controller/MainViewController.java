package pl.radoslawlapciak.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainViewController {

    @FXML
    private GridPane imageGrid;

    @FXML
    private void handleLoadImageButtonAction(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image files", ".bmp", "*.png", "*.jpg", "*.gif"));
        fileChooser.setTitle("select an image");
        File file = fileChooser.showOpenDialog(new Stage());
        if(file != null){
            for(Node node : imageGrid.getChildren()){
                if(node instanceof ImageView){
                    ImageView imageView = (ImageView) node;
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                }
            }
        }
    }

}

