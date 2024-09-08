package com.grupog.eventospoo.controller;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.TextFormatter;

public class PatrocinadorController {

    private final Scene cenaPatrocinador;

    public PatrocinadorController() {
        VBox layout = new VBox(10);

        Label nomeLabel = new Label("Nome:");
        TextField campoNome = new TextField();
        campoNome.setPromptText("Digite o nome de sua empresa");

        Label senhaLabel = new Label("Senha:");
        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");

        Label contribuicaoLabel = new Label("Contribuição:");
        TextField campoContribuicao = new TextField();
        campoContribuicao.setPromptText("Digite sua contribuição");


        campoContribuicao.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*(\\.\\d*)?")) {  //pra aceitar so decimais
                return change;
            } else {
                return null; 
            }
        }));

        Button registrarButton = new Button("Registrar");
        registrarButton.setOnAction(e -> registrarPatrocinador(campoNome.getText(), campoSenha.getText(), campoContribuicao.getText()));

        Button voltarButton = new Button("Voltar");
        voltarButton.setOnAction(e -> voltar());

        layout.getChildren().addAll(nomeLabel, campoNome, senhaLabel, campoSenha, contribuicaoLabel, campoContribuicao, registrarButton, voltarButton);
        cenaPatrocinador = new Scene(layout, 600, 400);
        layout.setAlignment(Pos.CENTER);
    }

    public Scene getCenaPatrocinador() {
        return cenaPatrocinador;
    }

    private void registrarPatrocinador(String nome, String senha, String contribuicaoTexto) {
        try {
            double contribuicao = Double.parseDouble(contribuicaoTexto);
            if (contribuicao < 0) {
                showAlert("Erro", "A contribuição não pode ser negativa.");
            } else {
                System.out.println("Patrocinador registrado:");
                System.out.println("Nome: " + nome);
                System.out.println("Senha: " + senha);
                System.out.println("Contribuição: " + contribuicao);
                showAlert("Registro Bem-sucedido", "Patrocinador registrado com sucesso!");
            }
        } catch (NumberFormatException e) {
            showAlert("Erro", "Valor de contribuição inválido.");
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
        Stage stage = (Stage) cenaPatrocinador.getWindow();
        MainController mainController = new MainController();
        stage.setScene(mainController.getCenaPrincipal());
    }
}
