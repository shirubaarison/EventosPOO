package com.grupog.eventospoo;

import com.grupog.eventospoo.controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Configura o controlador e a cena inicial
        MainController controlador = new MainController();
        primaryStage.setScene(controlador.getCenaPrincipal());
        primaryStage.setTitle("Eventos POO");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

