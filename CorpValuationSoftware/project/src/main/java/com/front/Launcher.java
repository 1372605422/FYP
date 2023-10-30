package com.front;
/*
  This class is the start the of program.
  @author [Zihao ZHANG]
 * @version [V1.0]
 * @since [2023/2/11]
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 660, 877);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
