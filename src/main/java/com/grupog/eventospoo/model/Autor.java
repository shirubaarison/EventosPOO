package com.grupog.eventospoo.model;

import com.grupog.eventospoo.exceptions.AutorException;

/**
 * Representa um autor no sistema de eventos.
 */
public class Autor {

    private String nome;

    /**
     * Construtor para criar um novo autor.
     * Inicializa um autor com nome, CPF, instituição, senha e email.
     * O tipo de usuário é definido como AUTOR.
     *
     * @param nome        Nome do autor
     */
    public Autor(String nome) {
        setNome(nome);
    }

    /**
     * Define o nome do autor.
     * Lança uma exceção se o nome for nulo ou vazio.
     *
     * @param nome Nome do autor
     */
    public void setNome(String nome) {
        try {
            if (nome == null || nome.trim().isEmpty()) {
                throw new AutorException.InvalidNomeException("Nome não pode ser nulo ou vazio.");
            }
            this.nome = nome;
        } catch (AutorException.InvalidNomeException e) {
            System.out.println("Erro ao definir nome do autor: " + e.getMessage());
        }
    }

    public String getNome() {
        return nome;
    }
}
