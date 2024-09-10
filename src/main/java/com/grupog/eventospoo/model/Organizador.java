package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.OrganizadorException;

public class Organizador extends Usuario {
    public Organizador(String nome, String cpf, String instituicao, String senha, String email) {
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

    public void removerAtividade(Evento evento, Atividade atividade) {
        try {
            if (evento == null) {
                throw new OrganizadorException.EventoNotFoundException("Evento não pode ser nulo.");
            }
            if (atividade == null) {
                throw new OrganizadorException.AtividadeNotFoundException("Atividade não pode ser nula.");
            }
        } catch (OrganizadorException.EventoNotFoundException | OrganizadorException.AtividadeNotFoundException e) {
            System.out.println("Erro ao remover atividade: " + e.getMessage());
        }
    }

    public Mensagem receberMensagem(Mensagem mensagem) {
        try {
            if (mensagem == null) {
                throw new OrganizadorException.InvalidMensagemException("Mensagem não pode ser nula.");
            }
            return mensagem; // retornar para evitar erro de compilação
        } catch (OrganizadorException.InvalidMensagemException e) {
            System.out.println("Erro ao receber mensagem: " + e.getMessage());
            return null;
        }
    }

    public void enviarMensagem(Mensagem mensagem, Organizador destinatario) {
        try {
            if (mensagem == null) {
                throw new OrganizadorException.InvalidMensagemException("Mensagem não pode ser nula.");
            }
            if (destinatario == null) {
                throw new OrganizadorException.InvalidMensagemException("Destinatário não pode ser nulo.");
            }
        } catch (OrganizadorException.InvalidMensagemException e) {
            System.out.println("Erro ao enviar mensagem: " + e.getMessage());
        }
    }

    public void alterarMensagemStatus(Mensagem mensagem, Status status) {
        try {
            if (mensagem == null) {
                throw new OrganizadorException.InvalidMensagemException("Mensagem não pode ser nula.");
            }
            if (status == null) {
                throw new OrganizadorException.InvalidStatusException("Status não pode ser nulo.");
            }
        } catch (OrganizadorException.InvalidMensagemException | OrganizadorException.InvalidStatusException e) {
            System.out.println("Erro ao alterar status da mensagem: " + e.getMessage());
        }
    }
}
