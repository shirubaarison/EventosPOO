package com.grupog.eventospoo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegisterView {
    private final Stage stage;

    public RegisterView(Stage ownerStage) throws IOException {
        // carregar fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/RegisterView.fxml"));
        Parent root = loader.load();

        Scene loginScene = new Scene(root);

        stage = new Stage();
        stage.initOwner(ownerStage);
        stage.setTitle("Login");
        stage.setScene(loginScene);

        // essa tela é modal, nao abre no display principal
        stage.initModality(javafx.stage.Modality.WINDOW_MODAL);
    }

    public void show() {
        stage.show();
    }
}
