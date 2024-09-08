package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.view.LoginView;
import com.grupog.eventospoo.view.RegisterView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    @FXML
    private void handleLogin() throws IOException {
        LoginView loginView = new LoginView(primaryStage);
        loginView.show();
    }

    @FXML
    private void handleRegister(ActionEvent event) throws IOException {
        RegisterView registerView = new RegisterView(primaryStage);
        registerView.show();
    }

}
