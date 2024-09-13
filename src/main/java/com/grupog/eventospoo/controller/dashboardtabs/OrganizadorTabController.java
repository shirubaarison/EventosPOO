package com.grupog.eventospoo.controller.dashboardtabs;

import com.grupog.eventospoo.model.Evento;
import com.grupog.eventospoo.model.Local;
import com.grupog.eventospoo.model.SystemModel;
import com.grupog.eventospoo.utils.AlertUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrganizadorTabController {

    @FXML
    private TextField eventNameFieldInput;

    @FXML
    private TextField eventLocationFieldInput;

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

    // Modelo de sistema
    private SystemModel systemModel;

    @FXML
    public void initialize() {
        // Inicializa o modelo do sistema
        systemModel = SystemModel.getInstance();

        // Carregar a lista de eventos
        carregarEventosListView();

        // Configurar os botões
        addEventButton.setOnAction(e -> handleAddEvent());
        removeEventButton.setOnAction(e -> handleRemoveEvent());
    }

    private void carregarEventosListView() {
        // Atualiza a ListView com os eventos existentes
        eventosListView.getItems().clear();
        eventosListView.getItems().addAll(systemModel.getEventos().keySet());
    }

    private void handleAddEvent() {
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

        // Dar parse na data
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date parsedDate;
        try {
            parsedDate = dateFormat.parse(eventDate);
        } catch (ParseException ex) {
            AlertUtils.showAlert(Alert.AlertType.ERROR, "Data Inválida", "Formato de data inválido. Use dd/MM/yyyy.");
            return;
        }

        Evento newEvent = new Evento(eventName, eventDescription, parsedDate, eventTime, new Local(eventLocation));
        systemModel.addEvento(newEvent);

        // Limpar os campos após adicionar o evento
        eventNameFieldInput.clear();
        eventLocationFieldInput.clear();
        eventDateFieldInput.clear();
        eventTimeFieldInput.clear();
        eventDescriptionFieldInput.clear();

        // Atualiza a lista de eventos
        carregarEventosListView();
    }

    private void handleRemoveEvent() {
        String selectedEvent = eventosListView.getSelectionModel().getSelectedItem();
        if (selectedEvent != null) {
            systemModel.removerEvento(selectedEvent);
            eventosListView.getItems().remove(selectedEvent);
        } else {
            AlertUtils.showAlert(Alert.AlertType.WARNING, "Nenhum Evento Selecionado", "Selecione um evento para remover.");
        }
    }
}
