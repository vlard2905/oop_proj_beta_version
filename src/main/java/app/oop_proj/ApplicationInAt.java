package app.oop_proj;

import app.oop_proj.controllers.Constructor;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.concurrent.Task;

/**
 * @author Chesnykov Vladyslav
 */
public class ApplicationInAt extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationInAt.class.getResource("scene1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setScene(scene);
        stage.show();
        // Create and execute a new task on a separate thread
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Now 2nd thread is working...");
                }
                return null;
            }
        };
        new Thread(task).start();
    }
    public static void main(String[] args) {
        launch();
    }
}