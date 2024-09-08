package com.grupog.eventospoo.utils;

import javafx.scene.control.Alert;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtils {

    public static String hashPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("A senha não pode ser nula ou vazia");
        }

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hashedBytes = digest.digest(password.getBytes());

            return Base64.getEncoder().encodeToString(hashedBytes);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error ao dar hashing na senha", e);
        }
    }

    public static boolean verificarSenha(String rawPassword, String storedHash) {
        String hashedPassword = hashPassword(rawPassword);
        System.out.println("Are they equal??");

        System.out.println(hashedPassword);
        System.out.println(storedHash);

        return hashedPassword.equals(storedHash);
    }

    // Metodo para caso dê algum erro
    public static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
