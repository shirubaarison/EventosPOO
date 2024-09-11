package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.exceptions.UsuarioException;
import com.grupog.eventospoo.model.Evento;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EventoCardController {

    @FXML
    private Button detailsButton;

    @FXML
    private Label eventLocationLabel;

    @FXML
    private Label eventNameLabel;

    @FXML
    private Label eventTimeLabel;

    public void setEvento(Evento evento) {
        eventNameLabel.setText(evento.getNome());
        eventLocationLabel.setText(evento.getLocalizacao().getNome());
        eventTimeLabel.setText(evento.getHora());
        detailsButton.setOnAction(e -> showEventoDetails(evento));
    }

    private void showEventoDetails(Evento evento) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/dashboard/DetalhesEventoView.fxml"));
            Parent root = loader.load();

            Scene detailEventoScene = new Scene(root);

            Stage detailsStage = new Stage();
            detailsStage.setScene(detailEventoScene);

            detailsStage.initModality(javafx.stage.Modality.WINDOW_MODAL);

            detailsStage.setTitle("Detalhes do Evento");

            EventoDetailsController controller = loader.getController();
            controller.setEvento(evento);

            controller.setStage(detailsStage);

            detailsStage.show();

            // Aparecer com foco
            detailsStage.toFront();
            detailsStage.requestFocus();
            detailsStage.setIconified(false);
        } catch (UsuarioException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
