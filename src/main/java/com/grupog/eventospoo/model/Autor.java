package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.AutorException;
import com.grupog.eventospoo.utils.exceptions.UsuarioException;

public class Autor extends Usuario {

    public Autor(String nome, String cpf, String instituicao, String senha, String email) 
            throws UsuarioException.InvalidNomeException, 
                   UsuarioException.InvalidCpfException, 
                   UsuarioException.InvalidInstituicaoException, 
                   UsuarioException.InvalidSenhaException, 
                   UsuarioException.InvalidEmailException, 
                   UsuarioException.InvalidTipoUsuarioException {
        super(nome, cpf, instituicao, senha, email, TipoUsuario.AUTOR);
    }

    public void setNome(String nome) {
        try {
            if (nome == null || nome.trim().isEmpty()) {
                throw new AutorException.InvalidNomeException("Nome não pode ser nulo ou vazio.");
            }
            super.setNome(nome);
        } catch (AutorException.InvalidNomeException e) {
            System.out.println("Erro ao definir nome do autor: " + e.getMessage());
        }
    }

    public void setCpf(String cpf) {
        try {
            if (cpf == null || cpf.length() != 14) {
                throw new AutorException.InvalidCpfException("CPF deve ter 14 caracteres.");
            }
            super.setCpf(cpf);
        } catch (AutorException.InvalidCpfException e) {
            System.out.println("Erro ao definir CPF do autor: " + e.getMessage());
        }
    }

    public void setInstituicao(String instituicao) {
        try {
            if (instituicao == null || instituicao.trim().isEmpty()) {
                throw new AutorException.InvalidInstituicaoException("Instituição não pode ser nula ou vazia.");
            }
            super.setInstituicao(instituicao);
        } catch (AutorException.InvalidInstituicaoException e) {
            System.out.println("Erro ao definir instituição do autor: " + e.getMessage());
        }
    }

    public void setSenha(String senha) {
        try {
            if (senha == null || senha.length() < 6) {
                throw new AutorException.InvalidSenhaException("Senha deve ter pelo menos 6 caracteres.");
            }
            super.setSenha(senha);
        } catch (AutorException.InvalidSenhaException e) {
            System.out.println("Erro ao definir senha do autor: " + e.getMessage());
        }
    }

    public void setEmail(String email) {
        try {
            if (email == null || !email.contains("@")) {
                throw new AutorException.InvalidEmailException("Email inválido.");
            }
            super.setEmail(email);
        } catch (AutorException.InvalidEmailException e) {
            System.out.println("Erro ao definir email do autor: " + e.getMessage());
        }
    }
}
