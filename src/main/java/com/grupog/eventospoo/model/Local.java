package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.LocalException;

public class Local {
    private int id;
    private String nome;
    private String endereco;

    public Local(int id, String nome, String endereco) {
        try {
            if(id < 0) {
                throw new LocalException.InvalidIdException("Email negativo é inválido");
            }
            if (nome == null || nome.isEmpty()) {
                throw new LocalException.InvalidNomeException("Nome não pode ser nulo.");
            }
            if (endereco == null || endereco.isEmpty()) {
                throw new LocalException.InvalidEnderecoException("Endereço não pode ser nulo");
            }
        } catch (LocalException.InvalidIdException | LocalException.InvalidNomeException | LocalException.InvalidEnderecoException e) { // botar um if aki
            System.out.println("Erro ao criar o local: " + e.getMessage());
        }
    }

    public int getId() {
        return id;
    }

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

    public String getNome() {
        return nome;
    }

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

    public String getEndereco() {
        return endereco;
    }

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
