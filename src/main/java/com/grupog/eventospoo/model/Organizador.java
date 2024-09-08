package com.grupog.eventospoo.model;

public class Organizador extends Usuario {
    Organizador(String nome, String cpf, String instituicao, String email) {
        super(nome, cpf, instituicao, email);
    }

    public void concluirAtividade(Atividade atividade) {
        atividade.concluirAtividade();
    }

    public void cancelarAtividade(Atividade atividade) {
        atividade.cancelarAtividade();
    }

    public void checkIn(Atividade atividade) {
        // implementar checkin
    }

    public void editarInfo(Atividade atividade) {
        // implementar as funcionalidades de editar info de alguma atividade
    }

    public void adicionarAtividade(Evento evento, Atividade atividade) {
        // adicionar logica para adicionar atividade num evento
    }

    public void removerAtividade(Evento evento, Atividade atividade) {
        // adicionar logica para a remocao
    }

    public Mensagem receberMensagem(Mensagem mensagem) {
        // receba
        return mensagem; // return so pra IDE nao reclamar
    }

    public void enviarMensagem(Mensagem mensagem, Organizador destinatario) {
        // implementar a lógica
    }

    public void alterarMensagemStatus(Mensagem mensagem, Status status) {
        // alterar o status
    }
}