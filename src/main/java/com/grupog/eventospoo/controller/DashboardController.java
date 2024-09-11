package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.exceptions.UsuarioException;
import com.grupog.eventospoo.model.*;
import com.grupog.eventospoo.utils.AlertUtils;
import javafx.collections.MapChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public class DashboardController {
    @FXML
    private Button butaoEnviarAvaliacao;

    @FXML
    private TextField eventDateFieldInput;

    @FXML
    private TextField eventTimeFieldInput;

    @FXML
    private TextField eventDescriptionFieldInput;

    @FXML
    private Button addEventButton;

    @FXML
    private ListView<String> eventosListView;

    @FXML
    private Button removeEventButton;

    @FXML
    private TextField eventNameFieldInput;

    @FXML
    private TextField eventLocationFieldInput;

    @FXML
    private Tab organizadorTab;

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

    @FXML
    private ComboBox<String> eventoAvaliadoField;

    @FXML
    private TextField notaField;

    @FXML
    private TextField comentarioField;

    @FXML
    private ListView<String> avaliacoesListView;

    // Modelo de sistema
    private SystemModel systemModel;

    @FXML
    public void initialize() throws UsuarioException {
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
        popularAvaliacaoComboBox();

        // Escuta mudanças no mapa de eventos
        systemModel.getEventos().addListener(new MapChangeListener<String, Evento>()  {
            @Override
            public void onChanged(Change<? extends String, ? extends Evento> change) {
                if (change.wasAdded() || change.wasRemoved()) {
                    // Atualiza a lista de eventos quando um novo evento é adicionado ou removido
                    try {
                        carregarEventos();
                        carregarEventosInscritos();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        // Escuta mudanças no mapa de eventos inscritos
        systemModel.getEventosInscritos().addListener(new MapChangeListener<String, Evento>() {
            @Override
            public void onChanged(Change<? extends String, ? extends Evento> change) {
                if (change.wasAdded() || change.wasRemoved()) {
                    // Atualiza a visualização dos eventos inscritos
                    try {
                        carregarEventos();
                        carregarEventosInscritos();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    popularAvaliacaoComboBox();
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

    private void popularAvaliacaoComboBox() {
        eventoAvaliadoField.getItems().clear();

        Map<String, Evento> eventosInscritos = systemModel.getEventosInscritos();

        // Sem eventos, desabilite o combobox
        if (eventosInscritos.isEmpty()) {
            eventoAvaliadoField.setDisable(true);
            comentarioField.setDisable(true);
            notaField.setDisable(true);
            butaoEnviarAvaliacao.setDisable(true);

        } else {
            for (String eventName : eventosInscritos.keySet()) {
                eventoAvaliadoField.getItems().add(eventName);
            }

            eventoAvaliadoField.setDisable(false);
            comentarioField.setDisable(false);
            notaField.setDisable(false);
            butaoEnviarAvaliacao.setDisable(false);
        }
    }

    public void inicializarPorUsuario(Usuario usuario) {
        // Configura a interface com base no tipo de usuário
        switch (usuario.getTipoUsuario()) {
            case VISITANTE:
                // Configuração para visitante (nenhuma específica aqui)
                break;
            case ORGANIZADOR:
                setupOrganizador(); // Configuração para organizador
                break;
            case AUTOR:
                setupAutor(); // Configuração para autor
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuário desconhecido: " + usuario.getTipoUsuario());
        }
    }

    private void setupOrganizador() {
        // Configura a aba do organizador
        organizadorTab.setDisable(false); // habilitar tab

        addEventButton.setOnAction(e -> {
            // Adiciona um novo evento ao sistema
            String eventName = eventNameFieldInput.getText();
            String eventLocation = eventLocationFieldInput.getText();
            String eventDate = eventDateFieldInput.getText();
            String eventTime = eventTimeFieldInput.getText();
            String eventDescription = eventDescriptionFieldInput.getText();

            // Validação dos campos
            if (eventName.isEmpty() || eventLocation.isEmpty() || eventDate.isEmpty() || eventTime.isEmpty() || eventDescription.isEmpty()) {
                AlertUtils.showAlert(Alert.AlertType.WARNING, "Campos Obrigatórios", "Por favor, preencha todos os campos.");
                return;
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parsedDate;
            try {
                parsedDate = dateFormat.parse(eventDate);
            } catch (ParseException ex) {
                AlertUtils.showAlert(Alert.AlertType.ERROR, "Data Inválida", "Formato de data inválido. Use dd/MM/yyyy.");
                return;
            }

            Evento newEvent = new Evento(eventName, eventDescription, parsedDate, eventTime, new Local(eventLocation, "Endereço exemplo"));

            systemModel.addEvento(newEvent);

            // Limpa os campos após adicionar o evento
            eventNameFieldInput.clear();
            eventLocationFieldInput.clear();
            eventDateFieldInput.clear();
            eventTimeFieldInput.clear();
            eventDescriptionFieldInput.clear();
        });

        // Seção para remover evento
        eventosListView.getItems().addAll(systemModel.getEventos().keySet());

        removeEventButton.setOnAction(e -> {
            String selectedEvent = (String) eventosListView.getSelectionModel().getSelectedItem();
            if (selectedEvent != null) {
                systemModel.removerEvento(selectedEvent);
                eventosListView.getItems().remove(selectedEvent);
            } else {
                AlertUtils.showAlert(Alert.AlertType.WARNING, "Nenhum Evento Selecionado", "Selecione um evento para remover.");
            }
        });

        // Atualiza a lista de eventos quando eventos são adicionados ou removidos
        systemModel.getEventos().addListener((MapChangeListener<String, Evento>) change -> {
            eventosListView.getItems().clear();
            eventosListView.getItems().addAll(systemModel.getEventos().keySet());
        });
    }

    private void setupAutor() {
        //
    }

    @FXML
    private void handleLogout() throws IOException {
        // Realiza o logout e fecha a tela atual
        systemModel.logout();

        Stage stage = (Stage) boasVindas.getScene().getWindow();
        stage.close();

        // Volta pra tela inicial
        // implementar :)
    }

    @FXML
    private void handleEnviarAvaliacao() {
        // Obtém valores de entrada
        String nomeEvento = eventoAvaliadoField.getValue();
        String notaText = notaField.getText();
        String comentario = comentarioField.getText();

        // Valida a entrada
        if (nomeEvento.isEmpty() || notaText.isEmpty() || comentario.isEmpty()) {
            AlertUtils.showAlert("Por favor, preencha todos os campos.");
            return;
        }

        int nota;
        try {
            nota = Integer.parseInt(notaText);
            if (nota < 0 || nota > 10) {
                AlertUtils.showAlert("A nota deve estar entre 0 e 10.");
                return;
            }
        } catch (NumberFormatException e) {
            AlertUtils.showAlert("Por favor, insira um número válido para a nota.");
            return;
        }

        // Cria um novo objeto Avaliacao
        Evento evento = systemModel.getEventos().get(nomeEvento);

        if (evento == null) {
            AlertUtils.showAlert("Evento inexistente, bro..");
            return;
        }

        if (!systemModel.getEventosInscritos().containsValue(evento)) {
            AlertUtils.showAlert("Você não está inscrito em " + nomeEvento);
        }

        Usuario usuarioConectado = systemModel.getUsuarioLogado();
        Avaliacao avaliacao = new Avaliacao(evento, nota, comentario, LocalDateTime.now(), usuarioConectado);
        systemModel.addAvaliacao(avaliacao);

        // Adiciona a avaliação à lista e limpa os campos
        avaliacoesListView.getItems().add(formatAvaliacao(avaliacao));
        eventoAvaliadoField.getSelectionModel().clearSelection();
        notaField.clear();
        comentarioField.clear();
    }

    private String formatAvaliacao(Avaliacao avaliacao) {
        // Formata a avaliação para exibição
        return String.format("Evento: %s\nNota: %d\nComentário: %s\nData: %s\nUsuário: %s",
                avaliacao.getEvento().getNome(),
                avaliacao.getNota(),
                avaliacao.getComentario(),
                avaliacao.getDateTime().toString(),
                avaliacao.getUsuario().getNome());
    }
}
