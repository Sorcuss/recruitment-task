package pl.radoslawlapciak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.radoslawlapciak.controller.MainViewController;
import pl.radoslawlapciak.model.repositroy.PointRepository;
import pl.radoslawlapciak.model.service.PointServiceImpl;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainView"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        MainViewController mainViewController = fxmlLoader.getController();
        mainViewController.setPointService(new PointServiceImpl(new PointRepository()));
        return root;
    }

    public static void main(String[] args) {
        launch();
    }

}