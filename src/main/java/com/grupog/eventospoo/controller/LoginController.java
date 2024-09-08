package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.SystemModel;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.grupog.eventospoo.utils.AlertUtils.showAlert;

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

            // Fechar essa janela
            Stage stage = (Stage) nomeUsuario.getScene().getWindow();
            stage.close();

            nomeUsuario.clear();
            senha.clear();
        } else {
            showAlert("Usuário e/ou senha incorreto(s)");
        }

    }
}
