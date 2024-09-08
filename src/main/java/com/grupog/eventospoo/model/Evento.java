package com.grupog.eventospoo.model;

import java.util.Date;

public class Evento {
    private int id;
    private String nome;
    private String descricao;
    private Date data;
    private String hora;
    private Local localizacao;

    public Evento(int id, String nome, String descricao, Date data, String hora, Local localizacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
        this.localizacao = localizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Local getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Local localizacao) {
        if (localizacao != null) {
            this.localizacao = localizacao;
        }
    }
}
