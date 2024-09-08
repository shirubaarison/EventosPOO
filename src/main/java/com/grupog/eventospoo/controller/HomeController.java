package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.SystemModel;
import com.grupog.eventospoo.view.DashboardView;
import com.grupog.eventospoo.view.LoginView;
import com.grupog.eventospoo.view.RegisterView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Stage primaryStage;

    private SystemModel systemModel;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initialize() {
        systemModel = SystemModel.getInstance();

        // Escutar caso tenha o usuário logou...
        systemModel.usuarioLogadoProperty().addListener((_, _, novoUsuarioLogado) -> {
            if (novoUsuarioLogado != null) {
                System.out.println("Bem vindo ao gigante... " + novoUsuarioLogado.getNome() + ".");
                try {
                    showDashboard();
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
        // Mostrar a view de Login como modal
        LoginView loginView = new LoginView(primaryStage);
        loginView.show();
    }

    @FXML
    private void handleRegister(ActionEvent event) throws IOException {
        // Mostrar a view de registro como modal
        RegisterView registerView = new RegisterView(primaryStage);
        registerView.show();
    }


    // Troca a tela pro dashboard
    private void showDashboard() throws IOException {
        DashboardView dashboardView = new DashboardView();
        primaryStage.setScene(dashboardView.getScene());
    }

    @FXML
    private void handleExit() {
        primaryStage.close();
    }
}
