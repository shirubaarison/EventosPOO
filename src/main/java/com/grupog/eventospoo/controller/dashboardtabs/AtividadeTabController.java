package com.grupog.eventospoo.controller.dashboardtabs;

import com.grupog.eventospoo.exceptions.AtividadeException;
import com.grupog.eventospoo.model.*;
import com.grupog.eventospoo.utils.AlertUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AtividadeTabController {
    @FXML
    private ComboBox<String> atividadeEventoComboBox;

    @FXML
    private TextField atividadeHorarioField;

    @FXML
    private TextField atividadeDescricaoField;

    @FXML
    private ListView<String> atividadesListView;

    @FXML
    private Button addAtividadeButton;

    @FXML
    private Button removeAtividadeButton;

    private SystemModel systemModel;

    @FXML
    public void initialize() {
        systemModel = SystemModel.getInstance();
        popularEventoComboBox();
        setupListeners();
    }

    private void popularEventoComboBox() {
        atividadeEventoComboBox.getItems().clear();

        systemModel.getEventos().forEach((nomeEvento, evento) -> {
            atividadeEventoComboBox.getItems().add(nomeEvento);
        });

        if (!atividadeEventoComboBox.getItems().isEmpty()) {
            atividadeEventoComboBox.getSelectionModel().selectFirst();
            atualizarListaDeAtividades(atividadeEventoComboBox.getValue());
        }
    }

    private void setupListeners() {
        addAtividadeButton.setOnAction(e -> {
            try {
                handleAddAtividade();
            } catch (AtividadeException ex) {
                throw new RuntimeException(ex);
            }
        });

        removeAtividadeButton.setOnAction(e -> {
            try {
                handleRemoveAtividade();
            } catch (AtividadeException ex) {
                throw new RuntimeException(ex);
            }

        });

        atividadeEventoComboBox.getSelectionModel().selectedItemProperty().addListener((obs, _, novaAtividade) -> {
            atualizarListaDeAtividades(novaAtividade);
        });
    }

    // Metodo para adicionar uma atividade
    public void handleAddAtividade() throws AtividadeException {
        // Pegar o evento selecionado no ComboBox
        String selectedEventName = atividadeEventoComboBox.getValue();

        // Pegar valores dos campos de atividade
        String atividadeHorario = atividadeHorarioField.getText();
        String atividadeDescricao = atividadeDescricaoField.getText();

        // Verificar se os campos estão preenchidos
        if (selectedEventName == null || atividadeHorario.isEmpty() || atividadeDescricao.isEmpty()) {
            AlertUtils.showAlert(Alert.AlertType.WARNING, "Campos Obrigatórios", "Por favor, preencha todos os campos.");
            return;
        }

        // Validar o horário da atividade
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date parsedTime;
        try {
            parsedTime = timeFormat.parse(atividadeHorario);
        } catch (ParseException ex) {
            AlertUtils.showAlert(Alert.AlertType.ERROR, "Horário Inválido", "Formato de horário inválido. Use HH:mm.");
            return;
        }

        // Obter o evento relacionado do sistema
        Evento evento = systemModel.getEventos().get(selectedEventName);

        if (evento == null) {
            AlertUtils.showAlert("Evento não encontrado.");
            return;
        }

        // Criar nova atividade
        Atividade novaAtividade = new Atividade(atividadeDescricao, parsedTime.toString());

        // Adicionar atividade ao evento
        evento.adicionarAtividade(novaAtividade);

        // Atualizar o sistema
        systemModel.updateEvento(evento);

        // Atualizar a lista de atividades no ListView
        atividadesListView.getItems().add(novaAtividade.getTitulo());

        // Limpar campos após adicionar
        atividadeHorarioField.clear();
        atividadeDescricaoField.clear();

        AlertUtils.showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Atividade adicionada com sucesso!");
    }

    // Metodo para remover uma atividade
    public void handleRemoveAtividade() throws AtividadeException {
        // Pegar a atividade selecionada
        String selectedAtividade = (String) atividadesListView.getSelectionModel().getSelectedItem();

        if (selectedAtividade == null) {
            AlertUtils.showAlert(Alert.AlertType.WARNING, "Nenhuma Atividade Selecionada", "Selecione uma atividade para remover.");
            return;
        }

        // Pegar o evento selecionado
        String selectedEventName = atividadeEventoComboBox.getValue();

        // Obter o evento relacionado do sistema
        Evento evento = systemModel.getEventos().get(selectedEventName);

        if (evento == null) {
            AlertUtils.showAlert(Alert.AlertType.ERROR, "Erro", "Evento não encontrado.");
            return;
        }

        // Remover a atividade do evento
        evento.removerAtividade(evento.getAtividadeByTitulo(selectedAtividade));

        // Atualizar o sistema
        systemModel.updateEvento(evento);

        // Remover atividade da interface
        atividadesListView.getItems().remove(selectedAtividade);

        AlertUtils.showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Atividade removida com sucesso!");
    }

    private void atualizarListaDeAtividades(String eventoNome) {
        // Limpa a lista de atividades
        atividadesListView.getItems().clear();

        if (eventoNome == null || eventoNome.isEmpty()) {
            return;
        }

        // Obtém o evento selecionado
        Evento evento = systemModel.getEventos().get(eventoNome);

        if (evento == null) {
            AlertUtils.showAlert(Alert.AlertType.ERROR, "Erro", "Evento não encontrado.");
            return;
        }

        // Adiciona as atividades do evento à lista
        for (Atividade atividade : evento.getAtividades()) {
            atividadesListView.getItems().add(atividade.getTitulo());
        }
    }
}
