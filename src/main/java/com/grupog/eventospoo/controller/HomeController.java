package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.SystemModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // Método para inicialização
    public void initialize() {
        // Pegar a instância do SystemModel
        SystemModel systemModel = SystemModel.getInstance();

        // Escutar caso tenha o usuário logou e se sim, trocar para tela de Dashboard
        systemModel.usuarioLogadoProperty().addListener((_, _, novoUsuarioLogado) -> {
            if (novoUsuarioLogado != null) {
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
        // Mostrar a view de Login como modal (tela que pode fechar)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/LoginView.fxml"));
        Parent root = loader.load();

        Scene loginScene = new Scene(root);

        Stage stage = new Stage();
        stage.initOwner(primaryStage);
        stage.setTitle("Login");
        stage.setScene(loginScene);

        stage.initModality(javafx.stage.Modality.WINDOW_MODAL);

        stage.show();
    }

    @FXML
    private void handleRegister(ActionEvent event) throws IOException {
        // Mostrar a view de registro como modal (tela que pode fechar)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/RegisterView.fxml"));
        Parent root = loader.load();

        Scene loginScene = new Scene(root);

        Stage stage = new Stage();
        stage.initOwner(primaryStage);
        stage.setTitle("Login");
        stage.setScene(loginScene);

        stage.initModality(javafx.stage.Modality.WINDOW_MODAL);

        stage.show();
    }


    // Troca a tela pro dashboard após usuário ter logado
    private void showDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/dashboard/DashboardView.fxml"));

        // Carregar o FXML correspondente
        Parent root = loader.load();

        Scene dashboardScene = new Scene(root);

        // Configurar e exibir a nova tela
        this.primaryStage.setScene(dashboardScene);
    }

    // Sair
    @FXML
    private void handleExit() {
        primaryStage.close();
    }
}
