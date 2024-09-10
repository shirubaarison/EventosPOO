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
        try {
            if (id < 0) {
                throw new PatrocinadorException.InvalidIdException("ID deve ser maior que zero.");
            }
            this.id = id;
        } catch (PatrocinadorException.InvalidIdException e) {
            System.out.println("Erro ao definir ID do patrocinador: " + e.getMessage());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try {
            if (nome == null || nome.trim().isEmpty()) {
                throw new PatrocinadorException.InvalidNomeException("Nome não pode ser nulo ou vazio.");
            }
            this.nome = nome;
        } catch (PatrocinadorException.InvalidNomeException e) {
            System.out.println("Erro ao definir nome do patrocinador: " + e.getMessage());
        }
    }

    public double getContribuicao() {
        return contribuicao;
    }

    public void setContribuicao(double contribuicao) {
        try {
            if (contribuicao < 0) {
                throw new PatrocinadorException.InvalidContribuicaoException("Contribuição deve ser maior que zero.");
            }
            this.contribuicao = contribuicao;
        } catch (PatrocinadorException.InvalidContribuicaoException e) {
            System.out.println("Erro ao definir contribuição do patrocinador: " + e.getMessage());
        }
    }
}
