package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.*;
import com.grupog.eventospoo.utils.AlertUtils;
import javafx.collections.MapChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventoTabController {

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
    private Button removeEventButton;

    @FXML
    private ListView<String> eventosListView;

    @FXML
    private HBox eventosCard;

    private SystemModel systemModel;

    @FXML
    public void initialize() {
        systemModel = SystemModel.getInstance();
        setupEventListeners();
        loadEvents();
    }

    private void setupEventListeners() {
        addEventButton.setOnAction(e -> handleAddEvent());
        removeEventButton.setOnAction(e -> handleRemoveEvent());

        systemModel.getEventos().addListener((MapChangeListener<String, Evento>) change -> {
            loadEvents();
        });
    }

    private void handleAddEvent() {
        // Add event logic
    }

    private void handleRemoveEvent() {
        String selectedEvent = eventosListView.getSelectionModel().getSelectedItem();
        if (selectedEvent != null) {
            systemModel.removerEvento(selectedEvent);
        } else {
            AlertUtils.showAlert(Alert.AlertType.WARNING, "Nenhum Evento Selecionado", "Selecione um evento para remover.");
        }
    }

    private void loadEvents() {
        // Logic to load events into eventosCard
    }
}
