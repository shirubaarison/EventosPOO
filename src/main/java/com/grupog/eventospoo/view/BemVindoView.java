package com.grupog.eventospoo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class BemVindoView {

    public BemVindoView(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/BemVindoView.fxml"));
        Parent root = loader.load();

        Scene bemVindoScene = new Scene(root);
        bemVindoScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());

        stage.setTitle("Eventos Acadêmicos");
        stage.setScene(bemVindoScene);

        stage.show();
    }
}
