package com.grupog.eventospoo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardView {
    private Scene scene;

    public DashboardView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/DashboardView.fxml"));
        Parent root = loader.load();

        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());
    }

    public Scene getScene() {
        return scene;
    }
}
