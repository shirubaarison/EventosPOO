package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.*;
import javafx.collections.MapChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    private TabPane tabsPrincipal;

    @FXML
    private Tab avaliacoesTab;

    @FXML
    private Tab organizadorTab;

    @FXML
    private Tab atividadesTab;

    @FXML
    private Text boasVindas;

    @FXML
    private HBox eventosCard;

    @FXML
    private HBox eventosInscritosCard;

    @FXML
    private Menu tipoUsuario;

    @FXML
    private VBox usersVBox;

    // Modelo de sistema
    private SystemModel systemModel;

    @FXML
    public void initialize() throws IOException {
        // Inicializa o modelo do sistema
        systemModel = SystemModel.getInstance();

        boasVindas.setText("Boas vindas " + systemModel.getUsuarioLogado().getNome() + "!");
        tipoUsuario.setText(systemModel.getUsuarioLogado().getTipoUsuario().toString());

        Usuario usuarioConectado = systemModel.getUsuarioLogado();

        // Carrega dados
        carregarUsuarios();
        try {
            carregarEventos();
            carregarEventosInscritos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        inicializarPorUsuario(usuarioConectado);
        carregarAvaliacoesTab();
        configurarListenersDeEventos();
    }

    private void carregarAvaliacoesTab() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/dashboard/tabs/AvaliacoesTab.fxml"));
        Parent tabContent = loader.load();
        avaliacoesTab.setContent(tabContent);
    }

    private void configurarListenersDeEventos() {
        // Escuta mudanças no mapa de eventos
        systemModel.getEventos().addListener((MapChangeListener<String, Evento>) change -> {
            if (change.wasAdded() || change.wasRemoved()) {
                // Atualiza a lista de eventos quando um novo evento é adicionado ou removido
                try {
                    carregarEventos();
                    carregarEventosInscritos();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Escuta mudanças no mapa de eventos inscritos
        systemModel.getEventosInscritos().addListener((MapChangeListener<String, Evento>) change -> {
            if (change.wasAdded() || change.wasRemoved()) {
                // Atualiza a visualização dos eventos inscritos
                try {
                    carregarEventos();
                    carregarEventosInscritos();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void carregarUsuarios() {
        // Obtém o mapa de usuários do sistema
        Map<String, Usuario> usuarios = systemModel.getUsuarios();

        // Limpa a lista de usuários exibidos
        usersVBox.getChildren().clear();

        String usuarioConectadoNome = systemModel.getUsuarioLogado().getNome();

        // Cria uma label para cada usuário no sistema, exceto o usuário logado
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            String userName = entry.getKey();

            if (userName.equals(usuarioConectadoNome)) {
                continue; // Pular o usuário logado
            }

            Label userLabel = new Label(userName);
            userLabel.setStyle("-fx-padding:10;");

            VBox userContainer = new VBox(userLabel);
            userContainer.setPrefHeight(45.0);
            userContainer.setPrefWidth(262.0);

            usersVBox.getChildren().add(userContainer);
        }
    }

    private void carregarEventos() throws IOException {
        Map<String, Evento> eventos = systemModel.getEventos();
        carregarEventosComuns(eventos, eventosCard, "Nenhum evento disponível.");
    }

    private void carregarEventosInscritos() throws IOException {
        Map<String, Evento> eventosInscritos = systemModel.getEventosInscritos();
        carregarEventosComuns(eventosInscritos, eventosInscritosCard, "Você não está inscrito em nenhum evento.");
    }

    private void carregarEventosComuns(Map<String, Evento> eventos, HBox container, String emptyMessage) throws IOException {
        container.getChildren().clear();

        if (eventos == null || eventos.isEmpty()) {
            Label noEventsLabel = new Label(emptyMessage);
            container.getChildren().add(noEventsLabel);
            return;
        }

        // Carregar eventoCard para cada evento
        for (Evento evento : eventos.values()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/dashboard/EventoCard.fxml"));
                VBox eventoCard = loader.load();
                EventoCardController cardController = loader.getController();
                cardController.setEvento(evento);

                container.getChildren().add(eventoCard);
        }
    }

    public void inicializarPorUsuario(Usuario usuario) throws IOException {
        // Configura a interface com base no tipo de usuário
        switch (usuario.getTipoUsuario()) {
            case VISITANTE:
                // desabilitar duas tabs do organizador e autor
                tabsPrincipal.getTabs().remove(organizadorTab);
                tabsPrincipal.getTabs().remove(atividadesTab);
                break;
            case ORGANIZADOR:
                setupOrganizador(); // Configuração para organizador
                setupAutor();
                break;
            case AUTOR:
                tabsPrincipal.getTabs().remove(organizadorTab);
                setupAutor(); // Configuração para autor
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuário desconhecido: " + usuario.getTipoUsuario());
        }
    }

    private void setupOrganizador() throws IOException {
        // Configura a aba do organizador
        organizadorTab.setDisable(false); // habilitar tab

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/dashboard/tabs/OrganizadorTab.fxml"));
        Parent tabContent = loader.load();
        organizadorTab.setContent(tabContent);
    }

    private void setupAutor() throws IOException {
        // Configura a tab do autor
        atividadesTab.setDisable(false); // habilitar a tab

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/dashboard/tabs/AtividadesTab.fxml"));
        Parent tabContent = loader.load();
        atividadesTab.setContent(tabContent);
    }

    @FXML
    private void handleLogout() throws IOException {
        systemModel.logout();

        Stage currentStage = (Stage) boasVindas.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/HomeView.fxml"));
        Parent root = loader.load();

        currentStage.setScene(new Scene(root));
        currentStage.setTitle("Tela Inicial");
    }
}
