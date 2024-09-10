package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.VisitanteException;

public class Visitante extends Usuario {
    private int id;
    private String feedback;

    public Visitante(String nome, String cpf, String instituicao, String senha, String email) {
        super(nome, cpf, instituicao, senha, email, TipoUsuario.VISITANTE);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new VisitanteException.InvalidIdException("ID deve ser maior que zero.");
        }
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            throw new VisitanteException.InvalidFeedbackException("Feedback não pode ser nulo ou vazio.");
        }
        this.feedback = feedback;
    }

    public String obterInfoAtividade(Atividade atividade) {
        if (atividade == null) {
            throw new VisitanteException.AtividadeNotProvidedException("A atividade deve ser fornecida.");
        }
        return atividade.getInformacoes();
    }

    public boolean enviarFeedback(Atividade atividade) {
        if (atividade == null) {
            throw new VisitanteException.AtividadeNotProvidedException("A atividade deve ser fornecida.");
        }
        return this.feedback != null;
    }

    public String obterLocalizacao(Atividade atividade) {
        if (atividade == null) {
            throw new VisitanteException.AtividadeNotProvidedException("Passe a atividade para pesquisar.");
        }
        return atividade.getInformacoes();
    }
}
