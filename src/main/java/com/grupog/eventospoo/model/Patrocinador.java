package com.grupog.eventospoo.model;

public class Patrocinador {
    private int id;
    private String nome;
    private double contribuicao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null) {
            this.nome = nome;
        }
    }

    public double getContribuicao() {
        return contribuicao;
    }

    public void setContribuicao(double contribuicao) {
        if (contribuicao > 0) {
            this.contribuicao = contribuicao;
        }
    }
}
