package com.grupog.eventospoo.model;

import com.grupog.eventospoo.exceptions.PatrocinadorException;

/**
 * Representa um patrocinador que contribui para eventos.
 */
public class Patrocinador {
    private int id;
    private String nome;
    private double contribuicao;

    /**
     * Obtém o ID do patrocinador.
     *
     * @return O ID do patrocinador
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do patrocinador.
     *
     * @param id O ID a ser definido
     */
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

    /**
     * Obtém o nome do patrocinador.
     *
     * @return O nome do patrocinador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do patrocinador.
     *
     * @param nome O nome a ser definido
     */
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

    /**
     * Obtém a contribuição do patrocinador.
     *
     * @return A contribuição do patrocinador
     */
    public double getContribuicao() {
        return contribuicao;
    }

    /**
     * Define a contribuição do patrocinador.
     *
     * @param contribuicao A contribuição a ser definida
     */
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
