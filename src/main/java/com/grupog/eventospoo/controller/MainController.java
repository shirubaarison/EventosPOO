package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.view.LoginView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    private Stage primaryStage;

    public MainController() {
    }

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    private void handleLogin() throws IOException {
        LoginView loginView = new LoginView(primaryStage);
        loginView.show();
    }

    @FXML
    private void handleRegister(ActionEvent event) {
        // Handle the register button click
    }

}
