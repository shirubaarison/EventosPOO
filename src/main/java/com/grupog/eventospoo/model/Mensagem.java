package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.MensagemException;

public class Mensagem {
    private String texto;
    private final Organizador remetente;
    private final String horario;
    private Status status;

    Mensagem(String texto, Organizador remetente, String horario, Status status) {
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
