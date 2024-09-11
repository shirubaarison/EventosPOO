package com.grupog.eventospoo.model;

import com.grupog.eventospoo.exceptions.VisitanteException;
import com.grupog.eventospoo.exceptions.UsuarioException;

/**
 * Representa um visitante no sistema, que é um tipo especializado de usuário.
 * Visitantes podem fornecer feedback e obter informações sobre atividades.
 */
public class Visitante extends Usuario {
    private int id; // Identificador único para o visitante
    private String feedback; // Feedback fornecido pelo visitante

    /**
     * Construtor da classe Visitante.
     *
     * @param nome          Nome do visitante
     * @param cpf           CPF do visitante
     * @param instituicao   Instituição do visitante
     * @param senha         Senha do visitante
     * @param email         Email do visitante
     * @throws UsuarioException Exceções relacionadas à validação dos parâmetros
     */
    public Visitante(String nome, String cpf, String instituicao, String senha, String email) throws UsuarioException {
        super(nome, cpf, instituicao, senha, email, TipoUsuario.VISITANTE);
    }

    /**
     * Obtém o identificador do visitante.
     *
     * @return ID do visitante
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do visitante.
     *
     * @param id ID do visitante
     */
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

    /**
     * Obtém o feedback fornecido pelo visitante.
     *
     * @return Feedback do visitante
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * Define o feedback fornecido pelo visitante.
     *
     * @param feedback Feedback fornecido pelo visitante
     */
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

    /**
     * Obtém informações sobre uma atividade específica.
     *
     * @param atividade Atividade sobre a qual obter informações
     * @return Informações da atividade
     */
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

    /**
     * Envia feedback sobre uma atividade específica.
     *
     * @param atividade Atividade sobre a qual o feedback está sendo enviado
     * @return true se o feedback for enviado com sucesso, false caso contrário
     */
    public boolean enviarFeedback(Atividade atividade) {
        try {
            if (atividade == null) {
                throw new VisitanteException.AtividadeNotProvidedException("A atividade deve ser fornecida.");
            }
            if (this.feedback == null || this.feedback.trim().isEmpty()) {
                throw new VisitanteException.InvalidFeedbackException("Feedback não pode ser nulo ou vazio.");
            }
            // Lógica para enviar feedback, se houver
            return true; // Supondo que o envio de feedback é sempre bem-sucedido
        } catch (VisitanteException.AtividadeNotProvidedException | VisitanteException.InvalidFeedbackException e) {
            System.out.println("Erro ao enviar feedback: " + e.getMessage());
            return false;
        }
    }
}
