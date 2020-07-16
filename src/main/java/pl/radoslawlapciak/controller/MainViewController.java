package pl.radoslawlapciak.controller;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import pl.radoslawlapciak.component.PointListComponent;
import pl.radoslawlapciak.component.PointPanelComponent;
import pl.radoslawlapciak.modelfx.ImageFxModel;
import pl.radoslawlapciak.modelfx.PointFxModel;
import pl.radoslawlapciak.util.AlertUtils;
import pl.radoslawlapciak.util.FileUtils;

import javax.xml.bind.JAXBException;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainViewController {

    @FXML
    private PointListComponent pointsList;

    @FXML
    private GridPane imageGrid;

    ImageFxModel imageModel = new ImageFxModel();

    @FXML
    private void initialize() {
        double xBound = imageGrid.getPrefWidth() / 2;
        double yBound = imageGrid.getPrefHeight() / 2;
        pointsList.setXBoundValidationRule(xBound);
        pointsList.setYBoundValidationRule(yBound);
        pointsList.pointsProperty().bindBidirectional(imageModel.pointListProperty());
        for (Node node : imageGrid.getChildren()) {
            if (node instanceof PointPanelComponent) {
                PointPanelComponent pointPanelComponent = (PointPanelComponent) node;
                pointPanelComponent.pointsProperty().bindBidirectional(imageModel.pointListProperty());
            }
        }
    }

    @FXML
    private void handleLoadImageButtonAction(ActionEvent event){
        File file = FileUtils.showAndGetFileFromFileChooser("Select an image", "Image files", "*.bmp", "*.png", "*.jpg", "*.gif");
        try {
            imageModel.setImageFromFile(file);
            InputStream inputStream = new FileInputStream(file);
            loadImageToPanelsFromInputStream(inputStream);
        } catch (IOException e) {
            AlertUtils.showAlert("Error", "File does not found", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleSaveProjectButtonAction(ActionEvent event){
        File file = FileUtils.showAndGetFileToSaveFromFileChooser("save to file", "XML files", "*.xml");
        if(file != null){
            try {
                this.imageModel.marshal(file);
                AlertUtils.showAlert("Success","Project has been saved successfully", Alert.AlertType.INFORMATION);
            } catch (JAXBException e) {
                AlertUtils.showAlert("Error","Error during save project", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    private void handleLoadProjectButtonAction(ActionEvent event){
        File file = FileUtils.showAndGetFileFromFileChooser("Load project", "XML files", "*.xml");
        if(file != null){
            try{
                imageModel = imageModel.unmarshal(file);
                InputStream inputStream = new ByteInputStream(imageModel.getContent(), imageModel.getContent().length);
                loadImageToPanelsFromInputStream(inputStream);
                initialize();
                AlertUtils.showAlert("Success","Project has been loaded successfully", Alert.AlertType.INFORMATION);
            }catch(JAXBException e){
                AlertUtils.showAlert("Error","Error during load project", Alert.AlertType.ERROR);

            }
        }
    }

    @FXML
    private void handleImageClick(MouseEvent event) {
        event.consume();
        PointFxModel point = new PointFxModel(event.getX(), event.getY());
        imageModel.addPoint(point);
        System.out.println(imageModel.getContent().length);
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

    private void loadImageToPanelsFromInputStream(InputStream inputStream){
        Image image = new Image(inputStream);
        for (ImageView imageView : getAllImageViewsFromGridPane()) {
            imageView.setImage(image);
        }
    }
}

