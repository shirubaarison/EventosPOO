package com.grupog.eventospoo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginView {
    private final Stage stage;

    public LoginView(Stage ownerStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/LoginView.fxml"));
        Parent root = loader.load();

        Scene loginScene = new Scene(root);
        loginScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());

        stage = new Stage();
        stage.initOwner(ownerStage);
        stage.setTitle("Login");
        stage.setScene(loginScene);
        stage.initModality(javafx.stage.Modality.WINDOW_MODAL);  // Optional: Makes the login window modal
    }

    public void show() {
        stage.show();
    }
}
