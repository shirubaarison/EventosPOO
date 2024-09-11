package com.grupog.eventospoo.utils;

import javafx.scene.control.Alert;

public class AlertUtils {

    // Metodo para caso dê algum erro mostrar ao usuário
    public static void showAlert(String message) {

        // Criar alerta
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Esse aqui caso seja um 'Warning' ou outro tipo de erro
    public static void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
