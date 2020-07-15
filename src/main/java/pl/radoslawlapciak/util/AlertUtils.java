package pl.radoslawlapciak.util;

import javafx.scene.control.Alert;

public class AlertUtils {

    public static void showErrorAlert(String title, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.show();
    }
}
