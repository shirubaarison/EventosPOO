package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.exceptions.UsuarioException;
import com.grupog.eventospoo.model.Evento;
import com.grupog.eventospoo.model.SystemModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EventoDetailsController {

    @FXML
    private Label eventNameLabel;

    @FXML
    private Label eventLocationLabel;

    @FXML
    private Label eventTimeLabel;

    @FXML
    private Label eventDescriptionLabel;

    @FXML
    private Button inscricaoButton;

    private Evento evento;

    @FXML
    private void initialize() {
    }

    public void setEvento(Evento evento) throws UsuarioException {
        this.evento = evento;
        eventNameLabel.setText("Nome: " + evento.getNome());
        eventLocationLabel.setText("Localização: " + evento.getLocalizacao().getNome());
        eventTimeLabel.setText("Hora: " + evento.getHora());
        eventDescriptionLabel.setText("Descrição: " + evento.getDescricao());

        updateInscricaoButton();
    }

    public void setStage(Stage stage) {
    }

    @FXML
    private void handleInscricao() throws UsuarioException {
        SystemModel systemModel = SystemModel.getInstance();
        boolean isSubscribed = systemModel.getEventosInscritos().containsValue(evento);

        if (isSubscribed) {
            systemModel.desinscrever(evento);
        } else {
            systemModel.inscrever(evento);
        }

        updateInscricaoButton();
    }

    private void updateInscricaoButton() throws UsuarioException {
        SystemModel systemModel = SystemModel.getInstance();
        boolean isSubscribed = systemModel.getEventosInscritos().containsValue(evento);
        inscricaoButton.setText(isSubscribed ? "Desinscrever" : "Se inscrever");

        // Fechar automaticamente
        Stage stage = (Stage) eventDescriptionLabel.getScene().getWindow();
        stage.close();
    }
}
