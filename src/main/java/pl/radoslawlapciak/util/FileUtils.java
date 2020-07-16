package pl.radoslawlapciak.util;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileUtils {
    public static File showAndGetFileFromFileChooser(String title, String description, String... extensions) {
        return buildFileChooser(title, description, extensions).showOpenDialog(new Stage());
    }

    public static File showAndGetFileToSaveFromFileChooser(String title, String description, String... extensions) {
        return buildFileChooser(title, description, extensions).showSaveDialog(new Stage());
    }

    private static FileChooser buildFileChooser(String title, String description, String... extensions) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(description, extensions));
        fileChooser.setTitle(title);
        return fileChooser;
    }
}
