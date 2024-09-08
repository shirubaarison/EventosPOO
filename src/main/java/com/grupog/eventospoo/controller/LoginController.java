package com.grupog.eventospoo.controller;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {

    private final Scene cenaLogin;

    public LoginController() {
        VBox layout = new VBox(10);
        Label tipoLabel = new Label("Tipo de Usuário:");
        ComboBox<String> tipoComboBox = new ComboBox<>();
        tipoComboBox.getItems().addAll("Visitante", "Organizador", "Patrocinador");

        Label nomeLabel = new Label("Nome:");
        TextField campoNome = new TextField();
        campoNome.setPromptText("Digite seu nome");

        Label senhaLabel = new Label("Senha:");
        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> autenticarUsuario(tipoComboBox.getValue(), campoNome.getText(), campoSenha.getText()));

        Button voltarButton = new Button("Voltar");
        voltarButton.setOnAction(e -> voltar());

        layout.getChildren().addAll(tipoLabel, tipoComboBox, nomeLabel, campoNome, senhaLabel, campoSenha, loginButton, voltarButton);
        cenaLogin = new Scene(layout, 600, 400);
        layout.setAlignment(Pos.CENTER);
    }

    public Scene getCenaLogin() {
        return cenaLogin;
    }

    private void autenticarUsuario(String tipo, String nome, String senha) {
        if (com.grupog.eventospoo.model.Usuario.autenticar(tipo, nome, senha)) {
            showAlert("Login Bem-sucedido", "Logado como " + tipo);
            Stage stage = (Stage) cenaLogin.getWindow();
            switch (tipo) {
                case "Visitante" -> {
                    VisitanteController visitanteController = new VisitanteController();
                    stage.setScene(visitanteController.getCenaVisitante());
                }
                case "Organizador" -> {
                    OrganizadorController organizadorController = new OrganizadorController();
                    stage.setScene(organizadorController.getCenaOrganizador());
                }
                case "Patrocinador" -> {
                    PatrocinadorController patrocinadorController = new PatrocinadorController();
                    stage.setScene(patrocinadorController.getCenaPatrocinador());
                }
            }
        } else {
            showAlert("Erro", "Nome ou senha inválidos.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void voltar() {
        Stage stage = (Stage) cenaLogin.getWindow();
        MainController mainController = new MainController();
        stage.setScene(mainController.getCenaPrincipal());
    }
}
