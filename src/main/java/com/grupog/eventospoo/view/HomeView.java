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
        // Inicializar a tela Home pelo arquivo fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/HomeView.fxml"));
        Parent root = loader.load();

        Scene homeScene = new Scene(root);

        stage.setTitle("Eventos Acadêmicos");
        stage.setScene(homeScene);

        // Pegar controller
        HomeController homeController = loader.getController();
        // setar o stage
        homeController.setPrimaryStage(stage);

        stage.show();
    }
}
