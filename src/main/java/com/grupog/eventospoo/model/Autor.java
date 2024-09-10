package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.AutorException;

public class Autor extends Usuario {
    public Autor(String nome, String cpf, String instituicao, String senha, String email) {
        super(nome, cpf, instituicao, senha, email, TipoUsuario.AUTOR);
        validarInfos(nome, cpf, instituicao, senha, email);
    }

    private void validarInfos(String nome, String cpf, String instituicao, String senha, String email) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new AutorException.InvalidNomeException("Nome não pode ser nulo ou vazio.");
        }
        if (cpf == null || cpf.length() != 14) {
            throw new AutorException.InvalidCpfException("CPF não pode ser nulo ou vazio.");
        }
        if (instituicao == null || instituicao.trim().isEmpty()) {
            throw new AutorException.InvalidInstituicaoException("Instituição não pode ser nula ou vazia.");
        }
        if (senha == null || senha.length() < 6) {
            throw new AutorException.InvalidSenhaException("Senha inválida. Deve ter pelo menos 6 caracteres.");
        }
        if (email == null || !email.contains("@")) {
            throw new AutorException.InvalidEmailException("Email inválido.");
        }
    }
}