package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.SystemModel;
import com.grupog.eventospoo.model.TipoUsuario;
import com.grupog.eventospoo.model.Usuario;
import com.grupog.eventospoo.model.Visitante;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static com.grupog.eventospoo.utils.PasswordUtils.hashPassword;
import static com.grupog.eventospoo.utils.PasswordUtils.showAlert;

public class RegisterController {
    private SystemModel systemModel;

    @FXML
    private TextField email;

    @FXML
    private TextField nomeUsuario;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField cpf;

    @FXML
    private ComboBox<TipoUsuario> tipoUsuario;

    @FXML
    private void initialize() {
        tipoUsuario.getItems().addAll(TipoUsuario.VISITANTE, TipoUsuario.ORGANIZADOR, TipoUsuario.AUTOR);

        systemModel = SystemModel.getInstance();
    }

    @FXML
    private void handleRegistration() {
        String emailValue = email.getText().trim();
        String nome = nomeUsuario.getText().trim();
        String senhaValue = senha.getText().trim();
        String cpfValue = cpf.getText().trim();
        TipoUsuario tipo = tipoUsuario.getValue();

        if (emailValue.isEmpty() || nome.isEmpty() || senhaValue.isEmpty() || cpfValue.isEmpty() || tipo == null) {
            showAlert("Há campos sem dados");
            return;
        }

        if (!isValidCPF(cpfValue)) {
            showAlert("CPF inválido");
            return;
        }

        // Dar hash na senha, não vamos salvar ela plana né...
        String hashedPassword = hashPassword(senhaValue);

        // Criar e adicionar o novo usuário ao sistema
        Usuario novoUsuario = new Usuario(nome, cpfValue, hashedPassword , emailValue);
        systemModel.addUsuario(novoUsuario);

        closeModal();

        System.out.println("Registration Successful!");
        System.out.println("Nome: " + nome);
        System.out.println("Senha: " + hashedPassword);
        System.out.println("CPF: " + cpfValue);
        System.out.println("Tipo de Usuário: " + tipo);

        email.clear();
        nomeUsuario.clear();
        senha.clear();
        cpf.clear();
        tipoUsuario.setValue(null);
    }

    private boolean isValidCPF(String cpf) {
        // implementar logica
        return true;
    }

    // fechar janela após registrar
    private void closeModal() {
        Stage stage = (Stage) nomeUsuario.getScene().getWindow();
        stage.close();
    }
}
