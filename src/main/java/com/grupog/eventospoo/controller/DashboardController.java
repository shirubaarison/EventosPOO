package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.SystemModel;
import com.grupog.eventospoo.model.Usuario;
import com.grupog.eventospoo.view.HomeView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class DashboardController {

    @FXML
    private Menu tipoUsuario;

    @FXML
    private VBox usersVBox;

    @FXML
    private Text boasVindas;

    public void carregarUsuarios() {
        // Map dos usuários do sistema
        Map<String, Usuario> usuarios = systemModel.getUsuarios();

        // Deletar elementos existentes (se houver)
        usersVBox.getChildren().clear();

        // Criar Label para cada usuário que existe no sistema
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            String userName = entry.getKey();
            Label userLabel = new Label(userName);
            userLabel.setStyle("-fx-padding:10;");

            VBox userContainer = new VBox(userLabel);
            userContainer.setPrefHeight(45.0);
            userContainer.setPrefWidth(262.0);

            usersVBox.getChildren().add(userContainer);
        }
    }

    private SystemModel systemModel;

    @FXML
    public void initialize() {
        systemModel = SystemModel.getInstance();
        boasVindas.setText("Boas vindas " + systemModel.getUsuarioLogado().getNome() + "!");
        tipoUsuario.setText(systemModel.getUsuarioLogado().getTipoUsuario().toString());

        Usuario usuarioConectado = systemModel.getUsuarioLogado();

        carregarUsuarios();
        inicializarPorUsuario(usuarioConectado);
    }

    public void inicializarPorUsuario(Usuario usuario) {
        switch (usuario.getTipoUsuario()) {
            case VISITANTE:
                setupForVisitante();
                break;
            case ORGANIZADOR:
                setupForOrganizador();
                break;
            case AUTOR:
                setupForAutor();
                break;
            default:
                throw new IllegalArgumentException("Unknown user type: " + usuario.getTipoUsuario());
        }
    }

    private void setupForVisitante() {
        // Setup UI for VISITANTE
    }

    private void setupForOrganizador() {
        // Setup UI for ORGANIZADOR
    }

    private void setupForAutor() {
        // Setup UI for AUTOR
    }

    @FXML
    private void handleLogout() throws IOException {
        systemModel.logout();

        // Pegar a tela
        Stage stage = (Stage) boasVindas.getScene().getWindow();

        stage.close();

        Stage primaryStage = (Stage) boasVindas.getScene().getWindow();
        primaryStage.close();

        Stage newStage = new Stage();
        new HomeView(newStage);
    }
}
