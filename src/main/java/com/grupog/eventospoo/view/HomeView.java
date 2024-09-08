package com.grupog.eventospoo.view;

import com.grupog.eventospoo.controller.HomeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HomeView {

    public HomeView(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/HomeView.fxml"));
        Parent root = loader.load();

        Scene homeScene = new Scene(root);
        homeScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());

        stage.setTitle("Eventos Acadêmicos");
        stage.setScene(homeScene);

        HomeController homeController = loader.getController();
        homeController.setPrimaryStage(stage);

        stage.show();
    }
}
