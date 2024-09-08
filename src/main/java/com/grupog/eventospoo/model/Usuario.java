package com.grupog.eventospoo.model;

import java.util.List;

public class Usuario {
    private String nome;
    private String cpf;
    private String instituicao;
    private String email;
    private String senha;
    private List<Evento> eventosInscritos;

    public Usuario(String nome, String cpf, String senha, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null) {
            this.nome = nome;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null) {
            this.cpf = cpf;
        }
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        if (instituicao != null) {
            this.instituicao = instituicao;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    public List<Evento> getEventosInscritos() {
        return eventosInscritos;
    }

    // Por enquanto ta como string, mas logo vai ser uma classe
    public void inscreverNoEvento(Evento evento) {
        this.eventosInscritos.add(evento);
    }

    public void cancelarInscricao(Evento evento) {
        this.eventosInscritos.remove(evento);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}