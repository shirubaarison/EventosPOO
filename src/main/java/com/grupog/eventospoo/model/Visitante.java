package com.grupog.eventospoo.model;

public class Visitante extends Usuario {
    int id;
    String feedback;

    public Visitante(String nome, String cpf, String instituicao, String senha, String email) {
        super(nome, cpf, instituicao, senha, email, TipoUsuario.VISITANTE);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String obterInfoAtividade(Atividade atividade) {
        return atividade.getInformacoes();
    }

    public boolean enviarFeedback(Atividade atividade) {
        return this.feedback != null;
    }

    public String obterLocalizacao(Atividade atividade) {
        if (atividade == null) {
            throw new ExceptionInInitializerError("Passe a ativiade pra pesquisar pae");
        }
        return atividade.getInformacoes();
    }
}
