package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.OrganizadorException;

public class Organizador extends Usuario {
    Organizador(String nome, String cpf, String instituicao, String senha, String email) {
        super(nome, cpf, instituicao, senha, email, TipoUsuario.ORGANIZADOR);
    }

    public void concluirAtividade(Atividade atividade) {
        if (atividade == null) {
            throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
        }
        atividade.concluirAtividade();
    }

    public void cancelarAtividade(Atividade atividade) {
        if (atividade == null) {
            throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
        }
        atividade.cancelarAtividade();
    }

    public void checkIn(Atividade atividade) {
        if (atividade == null) {
            throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
        }
        
    }

    public void editarInfo(Atividade atividade) {
        if (atividade == null) {
            throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
        }
        
    }

    public void adicionarAtividade(Evento evento, Atividade atividade) {
        if (evento == null) {
            throw new OrganizadorException.EventoNotFoundException("Evento não pode ser nulo.");
        }
        if (atividade == null) {
            throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
        }
        
    }

    public void removerAtividade(Evento evento, Atividade atividade) {
        if (evento == null) {
            throw new OrganizadorException.EventoNotFoundException("Evento não pode ser nulo.");
        }
        if (atividade == null) {
            throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
        }
        
    }

    public Mensagem receberMensagem(Mensagem mensagem) {
        if (mensagem == null) {
            throw new OrganizadorException.InvalidMensagemException("Mensagem não pode ser nula.");
        }
        
        return mensagem; // retornar para evitar erro de compilação
    }

    public void enviarMensagem(Mensagem mensagem, Organizador destinatario) {
        if (mensagem == null) {
            throw new OrganizadorException.InvalidMensagemException("Mensagem não pode ser nula.");
        }
        if (destinatario == null) {
            throw new OrganizadorException.InvalidMensagemException("Destinatário não pode ser nulo.");
        }
        
    }

    public void alterarMensagemStatus(Mensagem mensagem, Status status) {
        if (mensagem == null) {
            throw new OrganizadorException.InvalidMensagemException("Mensagem não pode ser nula.");
        }
        if (status == null) {
            throw new OrganizadorException.InvalidStatusException("Status não pode ser nulo.");
        }
        
    }
}
