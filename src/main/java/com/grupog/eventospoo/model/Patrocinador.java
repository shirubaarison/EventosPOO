package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.PatrocinadorException;

public class Patrocinador {
    private int id;
    private String nome;
    private double contribuicao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new PatrocinadorException.InvalidIdException("ID deve ser maior que zero.");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new PatrocinadorException.InvalidNomeException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public double getContribuicao() {
        return contribuicao;
    }

    public void setContribuicao(double contribuicao) {
        if (contribuicao < 0) {
            throw new PatrocinadorException.InvalidContribuicaoException("Contribuição deve ser maior que zero.");
        }
        this.contribuicao = contribuicao;
    }
}
