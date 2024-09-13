package com.grupog.eventospoo.controller.dashboardtabs;

import com.grupog.eventospoo.model.*;
import com.grupog.eventospoo.utils.AlertUtils;
import javafx.collections.MapChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.util.Map;

public class AvaliacaoTabController {
    @FXML
    private ComboBox<String> eventoAvaliadoComboBox;

    @FXML
    private TextField notaField;

    @FXML
    private TextField comentarioField;

    @FXML
    private Button butaoEnviarAvaliacao;

    @FXML
    private ListView<String> avaliacoesListView;

    private SystemModel systemModel;

    @FXML
    public void initialize() {
        systemModel = SystemModel.getInstance();
        setupListeners();
        popularEventoAvaliadoComboBox();

        systemModel.getEventosInscritos().addListener((MapChangeListener<String, Evento>) change -> {
            if (change.wasAdded() || change.wasRemoved()) {
                popularEventoAvaliadoComboBox();
            }
        });
    }

    private void setupListeners() {
        butaoEnviarAvaliacao.setOnAction(e -> handleEnviarAvaliacao());
    }

    @FXML
    private void handleEnviarAvaliacao() {
        // Obtém valores de entrada
        String nomeEvento = eventoAvaliadoComboBox.getValue();
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
        eventoAvaliadoComboBox.getSelectionModel().clearSelection();
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

    private void popularEventoAvaliadoComboBox() {
        eventoAvaliadoComboBox.getItems().clear();

        Map<String, Evento> eventosInscritos = systemModel.getEventosInscritos();

        // Sem eventos, desabilite o combobox
        if (eventosInscritos.isEmpty()) {
            eventoAvaliadoComboBox.setDisable(true);
            comentarioField.setDisable(true);
            notaField.setDisable(true);
            butaoEnviarAvaliacao.setDisable(true);

        } else {
            for (String eventName : eventosInscritos.keySet()) {
                eventoAvaliadoComboBox.getItems().add(eventName);
            }

            // Habilitar os field ja que tem evento inscrito
            eventoAvaliadoComboBox.setDisable(false);
            comentarioField.setDisable(false);
            notaField.setDisable(false);
            butaoEnviarAvaliacao.setDisable(false);

            // Selecionar o primeiro da lista pra nao ficar feio na view
            if (!eventoAvaliadoComboBox.getItems().isEmpty()) {
                eventoAvaliadoComboBox.getSelectionModel().selectFirst();
            }
        }
    }
}
