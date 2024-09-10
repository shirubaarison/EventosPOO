package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.LocalException;

public class Local {
    private int id;
    private String nome;
    private String endereco;

    public Local(String nome, String endereco) {
        setNome(nome); 
        setEndereco(endereco); 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new LocalException.InvalidIdException("ID deve ser maior que zero.");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new LocalException.InvalidNomeException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new LocalException.InvalidEnderecoException("Endereço não pode ser nulo ou vazio.");
        }
        this.endereco = endereco;
    }
}
