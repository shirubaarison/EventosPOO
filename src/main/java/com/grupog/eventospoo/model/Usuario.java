package com.grupog.eventospoo.model;

import java.util.ArrayList;
import java.util.List;
import com.grupog.eventospoo.utils.exceptions.UsuarioException;

public class Usuario {
    private String nome;
    private String cpf;
    private String instituicao;
    private String email;
    private String senha;
    private List<Evento> eventosInscritos;
    private TipoUsuario tipoUsuario;

    public Usuario(String nome, String cpf, String instituicao, String senha, String email, TipoUsuario tipoUsuario) 
            throws UsuarioException.InvalidNomeException, 
                   UsuarioException.InvalidCpfException, 
                   UsuarioException.InvalidInstituicaoException, 
                   UsuarioException.InvalidSenhaException, 
                   UsuarioException.InvalidEmailException, 
                   UsuarioException.InvalidTipoUsuarioException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new UsuarioException.InvalidNomeException("Nome não pode ser nulo ou vazio.");
        }
        if (cpf == null || cpf.length() != 14) { 
            throw new UsuarioException.InvalidCpfException("CPF inválido. Deve ter 14 caracteres.");
        }
        if (instituicao == null || instituicao.trim().isEmpty()) {
            throw new UsuarioException.InvalidInstituicaoException("Instituição não pode ser nula ou vazia.");
        }
        if (senha == null || senha.length() < 6) {
            throw new UsuarioException.InvalidSenhaException("Senha inválida. Deve ter pelo menos 6 caracteres.");
        }
        if (email == null || !email.contains("@")) {
            throw new UsuarioException.InvalidEmailException("Email inválido.");
        }
        if (tipoUsuario == null) {
            throw new UsuarioException.InvalidTipoUsuarioException("Tipo de usuário não pode ser nulo.");
        }

        this.nome = nome;
        this.cpf = cpf;
        this.instituicao = instituicao;
        this.senha = senha;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.eventosInscritos = new ArrayList<>();
    }

    public void setEventosInscritos(List<Evento> eventosInscritos) {
        this.eventosInscritos = eventosInscritos;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

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

    public void setCpf(String cpf) {
        try {
            if (cpf == null || cpf.length() != 14) { // contando os "." e "-"
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

    public void desinscreverDoEvento(Evento evento) {
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
