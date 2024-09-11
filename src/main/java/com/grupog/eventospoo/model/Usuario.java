package com.grupog.eventospoo.model;

import java.util.ArrayList;
import java.util.List;
import com.grupog.eventospoo.exceptions.UsuarioException;

/**
 * Representa um usuário do sistema, com informações pessoais e a lista de eventos nos quais está inscrito.
 */
public class Usuario {
    private String nome;
    private String cpf;
    private String instituicao;
    private String email;
    private String senha;
    private List<Evento> eventosInscritos; // Lista de eventos nos quais o usuário está inscrito
    private TipoUsuario tipoUsuario; // Tipo de usuário (VISITANTE, ORGANIZADOR, AUTOR)

    /**
     * Construtor da classe Usuario.
     *
     * @param nome          Nome do usuário
     * @param cpf           CPF do usuário
     * @param instituicao   Instituição do usuário
     * @param senha         Senha do usuário
     * @param email         Email do usuário
     * @param tipoUsuario   Tipo de usuário
     * @throws UsuarioException Exceções relacionadas à validação dos parâmetros
     */
    public Usuario(String nome, String cpf, String instituicao, String senha, String email, TipoUsuario tipoUsuario) throws UsuarioException {
        setNome(nome);
        setCpf(cpf);
        setInstituicao(instituicao);
        setSenha(senha);
        setEmail(email);
        setTipoUsuario(tipoUsuario);
        this.eventosInscritos = new ArrayList<>();
    }

    public void setEventosInscritos(List<Evento> eventosInscritos) {
        this.eventosInscritos = eventosInscritos;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Define o tipo de usuário.
     *
     * @param tipoUsuario Tipo de usuário
     */
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        try {
            if (tipoUsuario == null) {
                throw new UsuarioException.InvalidTipoUsuarioException("Tipo de usuário inválido. Não pode ser nulo.");
            }
            this.tipoUsuario = tipoUsuario;
        } catch (UsuarioException.InvalidTipoUsuarioException e) {
            System.out.println("Erro ao definir tipo de usuário: " + e.getMessage());
        }
    }

    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     *
     * @param nome Nome do usuário
     */
    public void setNome(String nome) {
        try {
            if (nome == null || nome.isEmpty()) {
                throw new UsuarioException.InvalidNomeException("Nome inválido. Não pode ser nulo ou vazio.");
            }
            this.nome = nome;
        } catch (UsuarioException.InvalidNomeException e) {
            System.out.println("Erro ao definir nome de usuário: " + e.getMessage());
        }
    }

    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do usuário.
     *
     * @param cpf CPF do usuário
     */
    public void setCpf(String cpf) {
        try {
            if (cpf == null || cpf.length() != 11) { // Verifica comprimento do CPF com formatação (XXXXXXXXXXX)
                throw new UsuarioException.InvalidCpfException("CPF inválido.");
            }
            this.cpf = cpf;
        } catch (UsuarioException.InvalidCpfException e) {
            System.out.println("Erro ao definir o CPF: " + e.getMessage());
        }
    }

    public String getInstituicao() {
        return instituicao;
    }

    /**
     * Define a instituição do usuário.
     *
     * @param instituicao Instituição do usuário
     */
    public void setInstituicao(String instituicao) {
        try {
            if (instituicao == null || instituicao.isEmpty()) {
                throw new UsuarioException.InvalidInstituicaoException("Instituição inválida. Não pode ser nula ou vazia.");
            }
            this.instituicao = instituicao;
        } catch (UsuarioException.InvalidInstituicaoException e) {
            System.out.println("Erro ao definir a instituição: " + e.getMessage());
        }
    }

    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     *
     * @param email Email do usuário
     */
    public void setEmail(String email) {
        try {
            if (email == null || !email.contains("@")) {
                throw new UsuarioException.InvalidEmailException("Email inválido.");
            }
            this.email = email;
        } catch (UsuarioException.InvalidEmailException e) {
            System.out.println("Erro ao definir email: " + e.getMessage());
        }
    }

    public List<Evento> getEventosInscritos() {
        return eventosInscritos;
    }

    /**
     * Inscreve o usuário em um evento.
     *
     * @param evento Evento para o qual o usuário deseja se inscrever
     */
    public void inscreverNoEvento(Evento evento) {
        try {
            if (evento == null) {
                throw new UsuarioException.InvalidEventoException("Evento inválido. Não pode ser nulo.");
            }
            this.eventosInscritos.add(evento);
        } catch (UsuarioException.InvalidEventoException e) {
            System.out.println("Erro ao inscrever no evento: " + e.getMessage());
        }
    }

    /**
     * Desinscreve o usuário de um evento.
     *
     * @param evento Evento do qual o usuário deseja se desinscrever
     */
    public void desinscreverDoEvento(Evento evento)  {
        try {
            if (!this.eventosInscritos.contains(evento)) {
                throw new UsuarioException.EventoNaoEncontradoException("Evento não encontrado na lista de inscritos.");
            }
            this.eventosInscritos.remove(evento);
        } catch (UsuarioException.EventoNaoEncontradoException e) {
            System.out.println("Erro ao cancelar inscrição no evento: " + e.getMessage());
        }
    }

    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha Senha do usuário
     */
    public void setSenha(String senha) {
        try {
            if (senha == null || senha.length() < 6) {
                throw new UsuarioException.InvalidSenhaException("Senha inválida. Deve ter pelo menos 6 caracteres.");
            }
            this.senha = senha;
        } catch (UsuarioException.InvalidSenhaException e) {
            System.out.println("Erro ao definir senha: " + e.getMessage());
        }
    }
}
