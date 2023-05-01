package app.oop_proj;

import app.oop_proj.controllers.Constructor;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*public class ApplicationInAt extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationInAt.class.getResource("scene1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        launch();
    }
}*/
import javafx.concurrent.Task;

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
            protected Void call() throws Exception {
                //here can be another task...
                return null;
            }
        };
        new Thread(task).start();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        launch();
    }
}