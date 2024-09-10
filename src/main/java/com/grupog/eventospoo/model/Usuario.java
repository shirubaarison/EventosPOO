package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.UsuarioException;
import java.util.List;

public class Usuario {
    private String nome;
    private String cpf;
    private String instituicao;
    private String email;
    private String senha;
    private List<Evento> eventosInscritos;
    private TipoUsuario tipoUsuario;

    public Usuario(String nome, String cpf, String instituicao, String senha, String email, TipoUsuario tipoUsuario) {
        setNome(nome);
        setCpf(cpf);
        setInstituicao(instituicao);
        setSenha(senha);
        setEmail(email);
        setTipoUsuario(tipoUsuario);
    }

    public void setEventosInscritos(List<Evento> eventosInscritos) {
        this.eventosInscritos = eventosInscritos;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        if (tipoUsuario == null) {
            throw new UsuarioException.InvalidTipoUsuarioException("Tipo de usuário inválido. Não pode ser nulo.");
        }
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new UsuarioException.InvalidNomeException("Nome inválido. Não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 14) { // contando os "." e "-"
            throw new UsuarioException.InvalidCpfException("CPF inválido.");
        }
        this.cpf = cpf;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        if (instituicao == null || instituicao.isEmpty()) {
            throw new UsuarioException.InvalidInstituicaoException("Instituição inválida. Não pode ser nula ou vazia.");
        }
        this.instituicao = instituicao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) { // genial
            throw new UsuarioException.InvalidEmailException("Email inválido.");
        }
        this.email = email;
    }

    public List<Evento> getEventosInscritos() {
        return eventosInscritos;
    }

    public void inscreverNoEvento(Evento evento) {
        if (evento == null) {
            throw new UsuarioException.InvalidEventoException("Evento inválido. Não pode ser nulo.");
        }
        this.eventosInscritos.add(evento);
    }

    public void cancelarInscricao(Evento evento) {
        if (!this.eventosInscritos.contains(evento)) {
            throw new UsuarioException.EventoNaoEncontradoException("Evento não encontrado na lista de inscritos.");
        }
        this.eventosInscritos.remove(evento);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.length() < 6) {
            throw new UsuarioException.InvalidSenhaException("Senha inválida. Deve ter pelo menos 6 caracteres.");
        }
        this.senha = senha;
    }
}
