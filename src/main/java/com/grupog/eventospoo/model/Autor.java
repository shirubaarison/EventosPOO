package com.grupog.eventospoo.model;

import com.grupog.eventospoo.exceptions.AutorException;
import com.grupog.eventospoo.exceptions.UsuarioException;

/**
 * Representa um autor no sistema de eventos.
 * Um autor é um tipo específico de usuário com informações como nome, CPF, instituição,
 * senha e email. A classe valida esses dados e gerencia as informações do autor.
 */
public class Autor extends Usuario {

    /**
     * Construtor para criar um novo autor.
     * Inicializa um autor com nome, CPF, instituição, senha e email.
     * O tipo de usuário é definido como AUTOR.
     *
     * @param nome        Nome do autor
     * @param cpf         CPF do autor
     * @param instituicao Instituição do autor
     * @param senha       Senha do autor
     * @param email       Email do autor
     * @throws UsuarioException Se algum dos dados do usuário for inválido
     */
    public Autor(String nome, String cpf, String instituicao, String senha, String email) throws UsuarioException {
        super(nome, cpf, instituicao, senha, email, TipoUsuario.AUTOR);
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
            super.setNome(nome);
        } catch (AutorException.InvalidNomeException e) {
            System.out.println("Erro ao definir nome do autor: " + e.getMessage());
        }
    }

    /**
     * Define o CPF do autor.
     * Lança uma exceção se o CPF for nulo ou não tiver exatamente 14 caracteres.
     *
     * @param cpf CPF do autor
     */
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

    /**
     * Define a instituição do autor.
     * Lança uma exceção se a instituição for nula ou vazia.
     *
     * @param instituicao Instituição do autor
     */
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

    /**
     * Define a senha do autor.
     * Lança uma exceção se a senha for nula ou tiver menos de 6 caracteres.
     *
     * @param senha Senha do autor
     */
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

    /**
     * Define o email do autor.
     * Lança uma exceção se o email for nulo ou não contiver um '@'.
     *
     * @param email Email do autor
     */
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
