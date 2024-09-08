package com.grupog.eventospoo.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class RegisterController {
    @FXML
    private TextField nomeUsuario;

    @FXML
    private TextField senha;

    @FXML
    private TextField cpf;

    @FXML
    private ComboBox<String> tipoUsuario;

    @FXML
    private FXCollections tipoUsuarioItems;

    @FXML
    private Button registrarButton;

    @FXML
    private void initialize() {
        tipoUsuario.getItems().addAll("Visitante", "Organizador", "Autor");
    }

    @FXML
    private void handleRegistration() {
        String nome = nomeUsuario.getText().trim();
        String senhaValue = senha.getText().trim();
        String cpfValue = cpf.getText().trim();
        String tipo = tipoUsuario.getValue();

        if (nome.isEmpty() || senhaValue.isEmpty() || cpfValue.isEmpty() || tipo.isEmpty()) {
            showAlert("Há campos sem dados");
            return;
        }

        if (!isValidCPF(cpfValue)) {
            showAlert("CPF inválido");
            return;
        }

        String hashedPassword = hashPassword(senhaValue);

        System.out.println("Registration Successful!");
        System.out.println("Nome: " + nome);
        System.out.println("Senha: " + hashedPassword);
        System.out.println("CPF: " + cpfValue);
        System.out.println("Tipo de Usuário: " + tipo);

        nomeUsuario.clear();
        senha.clear();
        cpf.clear();
        tipoUsuario.setValue(null);
    }

    private boolean isValidCPF(String cpf) {
        // implementar logica
        return true;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Dar hash na senha, não vamos salvar ela plana né...
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] salt = generateSalt();
            digest.update(salt);

            byte[] hashedBytes = digest.digest(password.getBytes());

            String hashedPassword = Base64.getEncoder().encodeToString(hashedBytes);
            String saltString = Base64.getEncoder().encodeToString(salt);

            return saltString + ":" + hashedPassword;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error ao dar hashing na senha", e);
        }
    }

    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
}
