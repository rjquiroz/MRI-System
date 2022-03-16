package mriSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mrifx.fxml"));
        primaryStage.setTitle("MRI System");
        primaryStage.setScene(new Scene(root, 1400, 670));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}