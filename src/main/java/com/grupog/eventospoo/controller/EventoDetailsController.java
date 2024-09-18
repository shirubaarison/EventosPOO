package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.exceptions.AtividadeException;
import com.grupog.eventospoo.exceptions.UsuarioException;
import com.grupog.eventospoo.model.Atividade;
import com.grupog.eventospoo.model.Evento;
import com.grupog.eventospoo.model.SystemModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

    @FXML
    private ListView<String> atividadesListView;

    private Evento evento;

    @FXML
    private void initialize() {
    }

    public void setEvento(Evento evento) throws UsuarioException, AtividadeException {
        this.evento = evento;

        eventNameLabel.setText("Nome: " + evento.getNome());
        eventLocationLabel.setText("Localização: " + evento.getLocalizacao().getNome());
        eventTimeLabel.setText("Hora: " + evento.getHora());
        eventDescriptionLabel.setText("Descrição: " + evento.getDescricao());

        updateInscricaoButton();
        initializeAtividades();
    }

    public void setStage(Stage stage) {
    }

    @FXML
    private void handleInscricao() throws UsuarioException, AtividadeException {
        SystemModel systemModel = SystemModel.getInstance();
        boolean isSubscribed = systemModel.getEventosInscritos().containsValue(evento);

        if (isSubscribed) {
            systemModel.desinscrever(evento);
        } else {
            systemModel.inscrever(evento);
        }

        updateInscricaoButton();
    }

    private void updateInscricaoButton() {
        SystemModel systemModel = SystemModel.getInstance();
        boolean isSubscribed = systemModel.getEventosInscritos().containsValue(evento);
        inscricaoButton.setText(isSubscribed ? "Desinscrever" : "Se inscrever");

        // Fechar automaticamente
        Stage stage = (Stage) eventDescriptionLabel.getScene().getWindow();
        stage.close();
    }

    private void initializeAtividades() {
        if (evento != null && evento.getAtividades() != null) {
            atividadesListView.getItems().clear();
            for (Atividade atividade : evento.getAtividades()) {
                atividadesListView.getItems().add(atividade.getTitulo());
            }
        }
    }
}
