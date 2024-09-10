package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.MensagemException;

public class Mensagem {
    private String texto;
    private final Organizador remetente;
    private final String horario;
    private Status status;

    public Mensagem(String texto, Organizador remetente, String horario, Status status) throws MensagemException.MensagemInvalidaException, MensagemException.InvalidRemetente, MensagemException.InvalidHorario, MensagemException.StatusInvalido {
        if (texto == null) {
            throw new MensagemException.MensagemInvalidaException("Mensagem não pode ser nula.");
        }
        if (remetente == null) {
            throw new MensagemException.InvalidRemetente("Remetente não pode ser nulo.");
        }
        if (horario == null || horario.isEmpty()) {
            throw new MensagemException.InvalidHorario("Horário não pode ser nulo ou vazio.");
        }
        if (status == null) {
            throw new MensagemException.StatusInvalido("Status não pode ser nulo.");
        }

        this.texto = texto;
        this.remetente = remetente;
        this.horario = horario;
        this.status = status;
    }

    public void alterarStatus(Status status) {
        try {
            if (status != null) {
            throw new MensagemException.StatusInvalido("Status inválido.");   
        }
        this.status = status;
    }   catch (MensagemException.StatusInvalido e) {
        System.out.println("Erro ao definir status" + e.getMessage());
    }
    }

    public void alterarMensagem(String novaMensagem) {
        try {
            if (novaMensagem == null || novaMensagem.isEmpty()) {
            throw new MensagemException.MensagemNulaException("Mensagem não pode ser nula ou vazia.");
        }
        this.texto = novaMensagem; }
        catch (MensagemException.MensagemNulaException e ) {
            System.out.println("Erro" + e.getMessage());
        }
    }


    @Override
    public String toString() {
        return "Mensagem{" +
                "texto='" + texto + '\'' +
                ", remetente=" + remetente +
                ", horario='" + horario + '\'' +
                ", status=" + status +
                '}';
    }
}
