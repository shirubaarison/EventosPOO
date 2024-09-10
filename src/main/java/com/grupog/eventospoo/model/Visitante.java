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
        try {
            if (id <= 0) {
                throw new VisitanteException.InvalidIdException("ID deve ser maior que zero.");
            }
            this.id = id;
        } catch (VisitanteException.InvalidIdException e) {
            System.out.println("Erro ao definir ID: " + e.getMessage());
        }
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        try {
            if (feedback == null || feedback.trim().isEmpty()) {
                throw new VisitanteException.InvalidFeedbackException("Feedback não pode ser nulo ou vazio.");
            }
            this.feedback = feedback;
        } catch (VisitanteException.InvalidFeedbackException e) {
            System.out.println("Erro ao definir feedback: " + e.getMessage());
        }
    }

    public String obterInfoAtividade(Atividade atividade) {
        try {
            if (atividade == null) {
                throw new VisitanteException.AtividadeNotProvidedException("A atividade deve ser fornecida.");
            }
            return atividade.getInformacoes();
        } catch (VisitanteException.AtividadeNotProvidedException e) {
            System.out.println("Erro ao obter informações da atividade: " + e.getMessage());
            return null;
        }
    }

    public boolean enviarFeedback(Atividade atividade) {
        try {
            if (atividade == null) {
                throw new VisitanteException.AtividadeNotProvidedException("A atividade deve ser fornecida.");
            }
            return this.feedback != null;
        } catch (VisitanteException.AtividadeNotProvidedException e) {
            System.out.println("Erro ao enviar feedback: " + e.getMessage());
            return false;
        }
    }

    public String obterLocalizacao(Atividade atividade) {
        try {
            if (atividade == null) {
                throw new VisitanteException.AtividadeNotProvidedException("Passe a atividade para pesquisar.");
            }
            return atividade.getInformacoes();
        } catch (VisitanteException.AtividadeNotProvidedException e) {
            System.out.println("Erro ao obter a localização da atividade: " + e.getMessage());
            return null;
        }
    }
}
