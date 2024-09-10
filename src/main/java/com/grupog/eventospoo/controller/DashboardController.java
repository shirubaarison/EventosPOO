package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.Evento;
import com.grupog.eventospoo.model.SystemModel;
import com.grupog.eventospoo.model.Usuario;
import com.grupog.eventospoo.view.HomeView;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

    private SystemModel systemModel;

    @FXML
    public void initialize() {
        systemModel = SystemModel.getInstance();
        boasVindas.setText("Boas vindas " + systemModel.getUsuarioLogado().getNome() + "!");
        tipoUsuario.setText(systemModel.getUsuarioLogado().getTipoUsuario().toString());

        Usuario usuarioConectado = systemModel.getUsuarioLogado();

        // Carregar tudo...
        carregarUsuarios();
        carregarEventos();
        carregarEventosInscritos();
        inicializarPorUsuario(usuarioConectado);

        // Escuta de novos eventos
        systemModel.getEventos().addListener(new MapChangeListener<String, Evento>()  {
            @Override
            public void onChanged(Change<? extends String, ? extends Evento> change) {
                if (change.wasAdded() || change.wasRemoved()) {
                    // Handle added event
                    System.out.println("Novo evento adicionado: " + change.getValueAdded().getNome());
                    // Optionally update UI or trigger other logic
                }
            }
        });

        // Escutar mudanças caso evento tenha sido inscrito
        systemModel.getEventosInscritos().addListener(new MapChangeListener<String, Evento>() {
            @Override
            public void onChanged(Change<? extends String, ? extends Evento> change) {
                if (change.wasAdded() || change.wasRemoved()) {
                    // Atualizar a view
                    carregarEventos();
                    carregarEventosInscritos();
                }
            }
        });
    }

    public void carregarUsuarios() {
        // Map dos usuários do sistema
        Map<String, Usuario> usuarios = systemModel.getUsuarios();

        // Deletar elementos existentes (se houver)
        usersVBox.getChildren().clear();

        String usuarioConectadoNome = systemModel.getUsuarioLogado().getNome();

        // Criar Label para cada usuário que existe no sistema, é o sistema de chat
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            String userName = entry.getKey();

            // dar skip se for o proprio usuario
            if (userName.equals(usuarioConectadoNome)) {
                continue;
            }

            Label userLabel = new Label(userName);
            userLabel.setStyle("-fx-padding:10;");

            VBox userContainer = new VBox(userLabel);
            userContainer.setPrefHeight(45.0);
            userContainer.setPrefWidth(262.0);

            usersVBox.getChildren().add(userContainer);
        }
    }

    private void carregarEventos() {
        eventosCard.getChildren().clear();

        // Map dos eventos existentes
        Map<String, Evento> eventos = systemModel.getEventos();

        if (eventos == null || eventos.isEmpty()) {
            Label noEventsLabel = new Label("Nenhum evento disponível.");
            eventosCard.getChildren().add(noEventsLabel);
            return;
        }

        // Criar uma card para cada evento existente
        for (Map.Entry<String, Evento> entry : eventos.entrySet()) {
            Evento evento = entry.getValue();

            Label nomeEvento = new Label(evento.getNome());
            Label localizacaoEvento = new Label("Local: " + evento.getLocalizacao().getNome());
            Label horaEvento = new Label("Hora: " + evento.getHora());

            Button verMaisButao = getDetalhesEventoButton(evento);

            VBox eventoContainer = new VBox();
            eventoContainer.getChildren().addAll(nomeEvento, localizacaoEvento, horaEvento, verMaisButao);
            eventoContainer.setSpacing(15);

            eventoContainer.setStyle("-fx-border-color: #000000;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-radius: 10;" +
                    "-fx-background-radius: 10;" +
                    "-fx-padding: 15;" +
                    "-fx-background-color: #f0f0f0;");

            eventosCard.getChildren().add(eventoContainer);
        }
    }


    private Button getDetalhesEventoButton(Evento evento) {
        Button verMaisButao = new Button("Ver Detalhes");

        verMaisButao.setOnAction(e -> {
            Stage detailsStage = new Stage();
            detailsStage.setTitle("Detalhes do Evento");

            VBox detailsLayout = new VBox(10);
            detailsLayout.setPadding(new Insets(10));

            Label detailsNameLabel = new Label("Nome: " + evento.getNome());
            Label detailsLocationLabel = new Label("Localização: " + evento.getLocalizacao().getNome());
            Label detailsTimeLabel = new Label("Hora: " + evento.getHora());
            Label detailsDescriptionLabel = new Label("Descrição: " + evento.getDescricao());

            detailsLayout.getChildren().addAll(detailsNameLabel, detailsLocationLabel, detailsTimeLabel, detailsDescriptionLabel);

            Scene detailsScene = new Scene(detailsLayout, 300, 200);
            Button inscricaoButton = getInscricaoButton(evento, detailsStage);
            detailsLayout.getChildren().add(inscricaoButton);
            detailsStage.setScene(detailsScene);
            detailsStage.show();
        });

        return verMaisButao;
    }

    private Button getInscricaoButton(Evento evento, Stage detailsStage) {
        Button inscricaoButton = new Button();

        boolean isSubscribed = systemModel.getEventosInscritos().containsValue(evento);
        inscricaoButton.setText(isSubscribed ? "Desinscrever" : "Se inscrever");

        inscricaoButton.setOnAction(inscricaoEvent -> {
            if (isSubscribed) {
                System.out.println("Desinscrevendo evento: " + evento.getNome());
                systemModel.desinscrever(evento);
            } else {
                System.out.println("Inscrevendo no evento: " + evento.getNome());
                systemModel.inscrever(evento);
            }

            // Fechar após a pessoa clicar para se inscrever ou desinscrever do evento
            Platform.runLater(() -> {
                boolean updatedSubscribedStatus = systemModel.getEventosInscritos().containsValue(evento);
                inscricaoButton.setText(updatedSubscribedStatus ? "Desinscrever" : "Se inscrever");
                detailsStage.close(); // Close the details window
            });
        });

        return inscricaoButton;
    }


    // Mesma coisa de carregar eventos, mas esse apenas para eventos inscritos pelo usuário
    private void carregarEventosInscritos() {
        eventosInscritosCard.getChildren().clear();

        // Get the list of subscribed events
        Map<String, Evento> eventosInscritos = systemModel.getEventosInscritos();

        if (eventosInscritos.isEmpty()) {
            Label noInscritosLabel = new Label("Você não está inscrito em nenhum evento.");
            eventosInscritosCard.getChildren().add(noInscritosLabel);

            noInscritosLabel.setMaxWidth(300);
            return;
        }

        for (Map.Entry<String, Evento> entry : eventosInscritos.entrySet()) {
            Evento evento = entry.getValue();

            Label nomeEvento = new Label(evento.getNome());
            Label localizacaoEvento = new Label("Local: " + evento.getLocalizacao().getNome());
            Label horaEvento = new Label("Hora: " + evento.getHora());
            Button verMaisButao = getDetalhesEventoButton(evento);

            VBox eventoContainer = new VBox();
            eventoContainer.getChildren().addAll(nomeEvento, localizacaoEvento, horaEvento, verMaisButao);
            eventoContainer.setSpacing(15);
            eventoContainer.setStyle("-fx-border-color: #000000;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-radius: 10;" +
                    "-fx-background-radius: 10;" +
                    "-fx-padding: 15;" +
                    "-fx-background-color: #f0f0f0;");

            eventosInscritosCard.getChildren().add(eventoContainer);
        }
    }


    public void inicializarPorUsuario(Usuario usuario) {
        switch (usuario.getTipoUsuario()) {
            case VISITANTE:
                break;
            case ORGANIZADOR:
                setupOrganizador();
                break;
            case AUTOR:
                setupAutor();
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuário desconhecido: " + usuario.getTipoUsuario());
        }
    }

    private void setupOrganizador() {
        // Adicionar tab de organizador
        tab.getTabPane().getTabs().add(new Tab("Organização"));

    }

    private void setupAutor() {
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
