package com.grupog.eventospoo.utils;

import javafx.scene.control.Alert;

public class AlertUtils {
    // Metodo para caso dê algum erro
    public static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
