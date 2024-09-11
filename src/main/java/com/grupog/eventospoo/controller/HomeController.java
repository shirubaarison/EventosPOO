package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.exceptions.UsuarioException;
import com.grupog.eventospoo.model.SystemModel;
import com.grupog.eventospoo.model.Usuario;
import com.grupog.eventospoo.view.DashboardView;
import com.grupog.eventospoo.view.LoginView;
import com.grupog.eventospoo.view.RegisterView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // Método para inicialização
    public void initialize() throws UsuarioException {
        // Pegar a instância do SystemModel
        SystemModel systemModel = SystemModel.getInstance();

        // Escutar caso tenha o usuário logou e se sim, trocar para tela de Dashboard
        systemModel.usuarioLogadoProperty().addListener((_, _, novoUsuarioLogado) -> {
            if (novoUsuarioLogado != null) {
                try {
                    showDashboard(novoUsuarioLogado);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                primaryStage.close();
            }
        });
    }

    @FXML
    private void handleLogin() throws IOException {
        // Mostrar a view de Login como modal (tela que pode fechar)
        LoginView loginView = new LoginView(primaryStage);
        loginView.show();
    }

    @FXML
    private void handleRegister(ActionEvent event) throws IOException {
        // Mostrar a view de registro como modal (tela que pode fechar)
        RegisterView registerView = new RegisterView(primaryStage);
        registerView.show();
    }


    // Troca a tela pro dashboard após usuário ter logado
    private void showDashboard(Usuario usuarioConectado) throws IOException {
        DashboardView dashboardView = new DashboardView(usuarioConectado);
        primaryStage.setScene(dashboardView.getScene());
    }


    // Sair
    @FXML
    private void handleExit() {
        primaryStage.close();
    }
}
