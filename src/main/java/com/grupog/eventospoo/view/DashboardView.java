package com.grupog.eventospoo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardView {
    private final Stage stage;

    public DashboardView(Stage stage) {
        this.stage = stage;
    }

    public void show() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/DashboardView.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.show();
    }
}
