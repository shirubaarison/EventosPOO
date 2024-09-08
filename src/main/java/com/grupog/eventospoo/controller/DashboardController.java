package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.Evento;
import com.grupog.eventospoo.model.SystemModel;
import com.grupog.eventospoo.model.Usuario;
import com.grupog.eventospoo.view.HomeView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class DashboardController {

    @FXML
    private Text boasVindas;

    @FXML
    private HBox eventosCard;

    @FXML
    private VBox eventosInscritosCard;

    @FXML
    private Tab tab;

    @FXML
    private Menu tipoUsuario;

    @FXML
    private VBox usersVBox;


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

    private void carregarEventos() {
        // Deletar elementos existentes (se houver)
        eventosCard.getChildren().clear();

        Map<String, Evento> eventos = systemModel.getEventos();

        for (Map.Entry<String, Evento> entry : eventos.entrySet()) {
            String eventId = entry.getKey();
            Evento evento = entry.getValue();

            Label eventNameLabel = new Label(evento.getNome());

            Label eventLocationLabel = new Label("Local: " + evento.getLocalizacao().getNome());

            Label eventTimeLabel = new Label("Hora: " + evento.getHora());

            VBox eventContainer = new VBox();
            eventContainer.getChildren().addAll(eventNameLabel, eventLocationLabel, eventTimeLabel);
            eventContainer.setSpacing(10);

            eventosCard.getChildren().add(eventContainer);
        }
    }

    private void carregarEventosInscritos() {
        // Clear existing elements (if any)
        eventosInscritosCard.getChildren().clear();

        Map<String, Evento> eventosInscritos = systemModel.getEventosIncritos();

        for (Map.Entry<String, Evento> entry : eventosInscritos.entrySet()) {
            String eventName = entry.getKey();
            Evento evento = entry.getValue();

            Label eventNameLabel = new Label(evento.getNome());
            Label eventLocationLabel = new Label("Local: " + evento.getLocalizacao().getNome());
            Label eventTimeLabel = new Label("Hora: " + evento.getHora());

            VBox eventContainer = new VBox();
            eventContainer.getChildren().addAll(eventNameLabel, eventLocationLabel, eventTimeLabel);
            eventContainer.setSpacing(10);

            eventosInscritosCard.getChildren().add(eventContainer);
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
        carregarEventos();
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
                throw new IllegalArgumentException("Tipo de usuário desconhecido: " + usuario.getTipoUsuario());
        }
    }

    private void setupForVisitante() {
        //
    }

    private void setupForOrganizador() {
        // Adicionar tab de organizador
        tab.getTabPane().getTabs().add(new Tab("Organização"));

    }

    private void setupForAutor() {
        // Adicionar tab de Autor
        tab.getTabPane().getTabs().add(new Tab("Autor"));
    }

    @FXML
    private void handleLogout() throws IOException {
        systemModel.logout();

        // Pegar a tela
        Stage stage = (Stage) boasVindas.getScene().getWindow();

        stage.close();

        Stage primaryStage = (Stage) boasVindas.getScene().getWindow();
        primaryStage.close();

        // Voltar para página inicial
        Stage newStage = new Stage();
        new HomeView(newStage);
    }
}
