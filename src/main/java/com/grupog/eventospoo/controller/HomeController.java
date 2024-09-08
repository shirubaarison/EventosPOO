package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.SystemModel;
import com.grupog.eventospoo.model.Usuario;
import com.grupog.eventospoo.view.LoginView;
import com.grupog.eventospoo.view.RegisterView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    private Stage primaryStage;

    private SystemModel systemModel;

    public void initialize() {
        systemModel = SystemModel.getInstance();

        // escutar caso tenha o usuário logou...
        systemModel.usuarioLogadoProperty().addListener(new ChangeListener<Usuario>() {
            @Override
            public void changed(ObservableValue<? extends Usuario> observableValue, Usuario usuario, Usuario novo) {
                if (novo != null) {
                    System.out.println("Bem vindo ao gigante... " + novo.getNome() + ".");
                }
            }
        });
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
