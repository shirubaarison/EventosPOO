package com.grupog.eventospoo.model;

import com.grupog.eventospoo.exceptions.UsuarioException;
import com.grupog.eventospoo.exceptions.OrganizadorException;

/**
 * Representa um organizador de eventos que pode gerenciar atividades e eventos.
 */
public class Organizador extends Usuario {

    /**
     * Construtor para criar um novo organizador.
     *
     * @param nome        Nome do organizador
     * @param cpf         CPF do organizador
     * @param instituicao Instituição ao qual o organizador está vinculado
     * @param senha       Senha do organizador
     * @param email       Email do organizador
     * @throws UsuarioException Se houver um erro ao criar o usuário
     */
    public Organizador(String nome, String cpf, String instituicao, String senha, String email) throws UsuarioException {
        super(nome, cpf, instituicao, senha, email, TipoUsuario.ORGANIZADOR);
    }

    /**
     * Conclui uma atividade.
     *
     * @param atividade A atividade a ser concluída
     */
    public void concluirAtividade(Atividade atividade) {
        try {
            if (atividade == null) {
                throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
            }
            atividade.concluirAtividade();
        } catch (OrganizadorException.AtividadeNotFoundException e) {
            System.out.println("Erro ao concluir atividade: " + e.getMessage());
        }
    }

    /**
     * Cancela uma atividade.
     *
     * @param atividade A atividade a ser cancelada
     */
    public void cancelarAtividade(Atividade atividade) {
        try {
            if (atividade == null) {
                throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
            }
            atividade.cancelarAtividade();
        } catch (OrganizadorException.AtividadeNotFoundException e) {
            System.out.println("Erro ao cancelar atividade: " + e.getMessage());
        }
    }

    /**
     * Realiza o check-in para uma atividade.
     *
     * @param atividade A atividade para a qual o check-in será realizado
     */
    public void checkIn(Atividade atividade) {
        try {
            if (atividade == null) {
                throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
            }
            // Implementar lógica de check-in
        } catch (OrganizadorException.AtividadeNotFoundException e) {
            System.out.println("Erro ao realizar check-in: " + e.getMessage());
        }
    }

    /**
     * Edita as informações de uma atividade.
     *
     * @param atividade A atividade cujas informações serão editadas
     */
    public void editarInfo(Atividade atividade) {
        try {
            if (atividade == null) {
                throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
            }
            // Implementar lógica de edição de informações
        } catch (OrganizadorException.AtividadeNotFoundException e) {
            System.out.println("Erro ao editar informações da atividade: " + e.getMessage());
        }
    }

    /**
     * Adiciona uma nova atividade a um evento.
     *
     * @param evento    O evento ao qual a atividade será adicionada
     * @param atividade A nova atividade a ser adicionada
     */
    public void adicionarAtividade(Evento evento, Atividade atividade) {
        try {
            if (evento == null) {
                throw new OrganizadorException.EventoNotFoundException("Evento não pode ser nulo.");
            }
            if (atividade == null) {
                throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
            }
            // Implementar lógica de adição de atividade
        } catch (OrganizadorException.EventoNotFoundException | OrganizadorException.AtividadeNotFoundException e) {
            System.out.println("Erro ao adicionar atividade: " + e.getMessage());
        }
    }
}
