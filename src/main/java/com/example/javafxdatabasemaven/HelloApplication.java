package com.example.javafxdatabasemaven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane borderPaneRoot =  FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(borderPaneRoot, 600, 400);
         stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}