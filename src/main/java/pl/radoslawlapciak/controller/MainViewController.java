package pl.radoslawlapciak.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainViewController {

    @FXML
    private void handleLoadImageButtonAction(ActionEvent event){
        event.consume();
        System.out.println("Hello, World!");
    }

}

