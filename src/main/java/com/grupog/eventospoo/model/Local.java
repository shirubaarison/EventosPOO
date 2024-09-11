package com.grupog.eventospoo.model;

import com.grupog.eventospoo.exceptions.LocalException;

/**
 * Representa um local onde eventos podem ser realizados.
 * Inclui informações como identificador, nome e endereço do local.
 */
public class Local {
    private int id;
    private String nome;
    private String endereco;

    /**
     * Construtor para criar um novo local com nome e endereço fornecidos.
     * Inicializa o local com as informações fornecidas.
     *
     * @param nome     Nome do local
     * @param endereco Endereço do local
     */
    public Local(String nome, String endereco) {
        setNome(nome);
        setEndereco(endereco);
    }

    /**
     * Retorna o identificador do local.
     *
     * @return ID do local
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do local.
     * O ID deve ser maior que zero.
     *
     * @param id Identificador do local
     */
    public void setId(int id) {
        try {
            if (id <= 0) {
                throw new LocalException.InvalidIdException("ID deve ser maior que zero.");
            }
            this.id = id;
        } catch (LocalException.InvalidIdException e) {
            System.out.println("Erro ao definir ID do local: " + e.getMessage());
        }
    }

    /**
     * Retorna o nome do local.
     *
     * @return Nome do local
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do local.
     * O nome não pode ser nulo ou vazio.
     *
     * @param nome Nome do local
     */
    public void setNome(String nome) {
        try {
            if (nome == null || nome.trim().isEmpty()) {
                throw new LocalException.InvalidNomeException("Nome não pode ser nulo ou vazio.");
            }
            this.nome = nome;
        } catch (LocalException.InvalidNomeException e) {
            System.out.println("Erro ao definir nome do local: " + e.getMessage());
        }
    }

    /**
     * Retorna o endereço do local.
     *
     * @return Endereço do local
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do local.
     * O endereço não pode ser nulo ou vazio.
     *
     * @param endereco Endereço do local
     */
    public void setEndereco(String endereco) {
        try {
            if (endereco == null || endereco.trim().isEmpty()) {
                throw new LocalException.InvalidEnderecoException("Endereço não pode ser nulo ou vazio.");
            }
            this.endereco = endereco;
        } catch (LocalException.InvalidEnderecoException e) {
            System.out.println("Erro ao definir endereço do local: " + e.getMessage());
        }
    }
}
