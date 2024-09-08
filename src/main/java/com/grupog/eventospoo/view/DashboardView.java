package com.grupog.eventospoo.view;

import com.grupog.eventospoo.model.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardView {
    private Scene scene;

    public DashboardView(Usuario usuario) throws IOException {
        // View depende totalmente do tipo de usuário!!
        switch (usuario.getTipoUsuario()) {
            case VISITANTE:
                setupVisitante();
                break;
            case ORGANIZADOR:
                setupOrganizador();
                break;
            case AUTOR:
                setupAutor();
                break;
            default:
                throw new IllegalArgumentException("Tipo desconhecido de usuário: " + usuario.getTipoUsuario());
        }
    }

    public Scene getScene() {
        return scene;
    }

    public void setupOrganizador() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/DashboardView.fxml"));
        Parent root = loader.load();

        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());
    }

    public void setupVisitante() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/DashboardView.fxml"));
        Parent root = loader.load();

        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());
    }

    public void setupAutor() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/DashboardView.fxml"));
        Parent root = loader.load();

        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());
    }

}
