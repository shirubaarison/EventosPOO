package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.SystemModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Button butao;

    private Stage primaryStage;

    // Método para inicialização
    public void initialize() {
        // Pegar a instância do SystemModel
        SystemModel systemModel = SystemModel.getInstance();

        // Escutar caso o usuário tenha logado e se sim, trocar para tela de Dashboard
        systemModel.usuarioLogadoProperty().addListener((_, _, novoUsuarioLogado) -> {
            if (novoUsuarioLogado != null) {
                try {
                    showDashboard();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    private void handleLogin() throws IOException {
        // Mostrar a view de Login como modal (tela que pode fechar)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/LoginView.fxml"));
        Parent root = loader.load();

        Scene loginScene = new Scene(root);

        Stage stage = new Stage();
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
        stage.setTitle("Login");
        stage.setScene(loginScene);

        stage.initModality(javafx.stage.Modality.WINDOW_MODAL);

        stage.show();
    }

    // Troca a tela pro dashboard após o usuário ter logado
    private void showDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/dashboard/DashboardView.fxml"));

        // Carregar o FXML correspondente
        Parent root = loader.load();

        Scene dashboardScene = new Scene(root);

        if (primaryStage != null) {
            primaryStage.setScene(dashboardScene);
            primaryStage.setTitle("Dashboard");
            primaryStage.show();
        }
    }

    // Sair
    @FXML
    private void handleExit() {
        Stage currentStage = (Stage) butao.getScene().getWindow();
        currentStage.close();
    }
}
