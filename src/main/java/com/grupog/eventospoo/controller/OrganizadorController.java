package com.grupog.eventospoo.controller;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OrganizadorController {

    private Scene cenaOrganizador;

    public OrganizadorController() {
        VBox layout = new VBox(10);
        Label nomeLabel = new Label("Nome:");
        TextField campoNome = new TextField();
        campoNome.setPromptText("Digite seu nome");

        Label senhaLabel = new Label("Senha:");
        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");

        Label cpfLabel = new Label("CPF:");
        TextField campoCpf = new TextField();
        campoCpf.setPromptText("Digite seu CPF");
        campoCpf.setTextFormatter(new TextFormatter<String>(change ->
            change.getControlNewText().matches("\\d{0,11}") ? change : null
        ));

        Button registrarButton = new Button("Registrar");
        registrarButton.setOnAction(e -> registrarOrganizador(campoNome.getText(), campoSenha.getText(), campoCpf.getText()));

        Button voltarButton = new Button("Voltar");
        voltarButton.setOnAction(e -> voltar());

        layout.getChildren().addAll(nomeLabel, campoNome, senhaLabel, campoSenha, cpfLabel, campoCpf, registrarButton, voltarButton);
        cenaOrganizador = new Scene(layout, 600, 400);
        layout.setAlignment(Pos.CENTER);
    }

    public Scene getCenaOrganizador() {
        return cenaOrganizador;
    }

    private void registrarOrganizador(String nome, String senha, String cpf) {
        System.out.println("Organizador registrado:");
        System.out.println("Nome: " + nome);
        System.out.println("Senha: " + senha);
        System.out.println("CPF: " + cpf);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro Bem-sucedido");
        alert.setHeaderText(null);
        alert.setContentText("Organizador registrado com sucesso!");
        alert.showAndWait();
        voltar();
    }

    private void voltar() {
        Stage stage = (Stage) cenaOrganizador.getWindow();
        MainController mainController = new MainController();
        stage.setScene(mainController.getCenaPrincipal());
    }
}
