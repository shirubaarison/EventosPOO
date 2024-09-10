package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.UsuarioException;
import com.grupog.eventospoo.utils.exceptions.OrganizadorException;

public class Organizador extends Usuario {
    public Organizador(String nome, String cpf, String instituicao, String senha, String email) 
            throws UsuarioException.InvalidNomeException, 
                   UsuarioException.InvalidCpfException, 
                   UsuarioException.InvalidInstituicaoException, 
                   UsuarioException.InvalidSenhaException, 
                   UsuarioException.InvalidEmailException, 
                   UsuarioException.InvalidTipoUsuarioException {
        super(nome, cpf, instituicao, senha, email, TipoUsuario.ORGANIZADOR);
    }

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

    public void checkIn(Atividade atividade) {
        try {
            if (atividade == null) {
                throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
            }
            
        } catch (OrganizadorException.AtividadeNotFoundException e) {
            System.out.println("Erro ao realizar check-in: " + e.getMessage());
        }
    }

    public void editarInfo(Atividade atividade) {
        try {
            if (atividade == null) {
                throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
            }

        } catch (OrganizadorException.AtividadeNotFoundException e) {
            System.out.println("Erro ao editar informações da atividade: " + e.getMessage());
        }
    }

    public void adicionarAtividade(Evento evento, Atividade atividade) {
        try {
            if (evento == null) {
                throw new OrganizadorException.EventoNotFoundException("Evento não pode ser nulo.");
            }
            if (atividade == null) {
                throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
            }
            
        } catch (OrganizadorException.EventoNotFoundException | OrganizadorException.AtividadeNotFoundException e) {
            System.out.println("Erro ao adicionar atividade: " + e.getMessage());
        }
    }

}