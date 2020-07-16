package pl.radoslawlapciak.util;

import javafx.scene.control.Alert;

public class AlertUtils {
    public static void showAlert(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.show();
    }
}
