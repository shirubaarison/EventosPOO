package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.exceptions.UsuarioException;
import com.grupog.eventospoo.model.SystemModel;
import com.grupog.eventospoo.model.TipoUsuario;
import com.grupog.eventospoo.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static com.grupog.eventospoo.utils.AlertUtils.showAlert;
import static com.grupog.eventospoo.utils.PasswordUtils.hashPassword;

public class RegisterController {
    private SystemModel systemModel;

    @FXML
    private TextField email;

    @FXML
    private TextField nomeUsuario;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField cpf;

    @FXML
    private TextField instituicao;

    @FXML
    private ComboBox<TipoUsuario> tipoUsuario;

    @FXML
    private void initialize() throws UsuarioException {
        // Inicializar tipos de usuário (menu dropdown)
        tipoUsuario.getItems().addAll(TipoUsuario.VISITANTE, TipoUsuario.ORGANIZADOR, TipoUsuario.AUTOR);

        // Instancia do SystemModel para fazer as devidas operações de registro
        systemModel = SystemModel.getInstance();
    }

    @FXML
    private void handleRegistration() throws UsuarioException {
        String emailValue = email.getText().trim();
        String nome = nomeUsuario.getText().trim();
        String senhaValue = senha.getText().trim();
        String cpfValue = cpf.getText().trim();
        String instituicaoValue = instituicao.getText().trim();
        TipoUsuario tipo = tipoUsuario.getValue();

        if (emailValue.isEmpty() || nome.isEmpty() || instituicaoValue.isEmpty() || senhaValue.isEmpty() || cpfValue.isEmpty() || tipo == null) {
            showAlert("Há campos sem dados");
            return;
        }

        if (!isValidCPF(cpfValue)) {
            showAlert("CPF inválido");
            return;
        }

        if (!isValidEmail(emailValue)) {
            showAlert("Email inválido");
            return;
        }

        // Dar hash na senha, não vamos salvar ela plana né...
        String hashedPassword = hashPassword(senhaValue);

        // Criar e adicionar o novo usuário ao sistema
        Usuario novoUsuario = new Usuario(nome, cpfValue, instituicaoValue, hashedPassword , emailValue, tipo);
        systemModel.addUsuario(novoUsuario);

        // Fechar essa janela e limpar
        Stage stage = (Stage) nomeUsuario.getScene().getWindow();
        stage.close();

        email.clear();
        nomeUsuario.clear();
        senha.clear();
        cpf.clear();
        tipoUsuario.setValue(null);
    }

    private boolean isValidCPF(String cpf) {
        // validador de cpf básico
        return cpf != null && cpf.length() == 11 && cpf.matches("\\d+");
    }

    private boolean isValidEmail(String email) {
        // validador de email com regex
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
    }
}
