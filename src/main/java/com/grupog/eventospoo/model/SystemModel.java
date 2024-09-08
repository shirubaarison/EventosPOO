package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.PasswordUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.HashMap;
import java.util.Map;

public class SystemModel {
    private static SystemModel instance;

    private final Map<String, Usuario> usuarios = new HashMap<>();
    private final ObjectProperty<Usuario> usuarioLogado = new SimpleObjectProperty<>();

    public SystemModel() {
        // Inicializar com alguns usuários...
        addUsuario(new Usuario("amostradinho", "123.123.123-43", "UFC", PasswordUtils.hashPassword("123"), "amostradinho@gmail.com", TipoUsuario.VISITANTE));
        addUsuario(new Usuario("caska de bala", "113.123.123-43", "UFBA", PasswordUtils.hashPassword("22"), "caska@gmail.com", TipoUsuario.ORGANIZADOR));
        addUsuario(new Usuario("borabill", "123.123.123-43", "UFRN", PasswordUtils.hashPassword("boraBill"), "borabill@gmail.com", TipoUsuario.AUTOR));
    }

    public static SystemModel getInstance() {
        if (instance == null) {
            instance = new SystemModel();
        }
        return instance;
    }

    public Usuario getUsuario(String nome) {
        return usuarios.get(nome);
    }

    public void addUsuario(Usuario user) {
        if (user != null) {
            this.usuarios.put(user.getNome(), user);
        } else {
            throw new IllegalArgumentException("Tentativa de adicionar usuário nulo");
        }
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado.get();
    }

    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado.set(usuario);
    }

    public void logout() {
        setUsuarioLogado(null);
    }

    public ObjectProperty<Usuario> usuarioLogadoProperty() {
        return usuarioLogado;
    }

    public boolean login(String nome, String senha) {
        Usuario usuario = usuarios.get(nome);

        if (usuario != null) {
            if (PasswordUtils.verificarSenha(senha, usuario.getSenha())) {
                setUsuarioLogado(usuario);
                return true;
            }
        }

        return false;
    }
}
