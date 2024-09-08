package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.SystemModel;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import static com.grupog.eventospoo.utils.PasswordUtils.showAlert;

public class LoginController {
    private SystemModel systemModel;

    @FXML
    private TextField nomeUsuario;

    @FXML
    private PasswordField senha;

    public void initialize() {
        systemModel = SystemModel.getInstance();
    }

    @FXML
    private void handleLogin() {
        String nome = nomeUsuario.getText().trim();
        String senhaValue = senha.getText().trim();

        if (systemModel.login(nome, senhaValue)) {
            System.out.println("Login Successful!");
        } else {
            showAlert("Usuário e/ou senha incorreto(s)");
        }
    }
}
