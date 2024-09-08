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
        // Inicializar com usuários talvez...
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
            System.out.println("Usuario adicionado: " + user.getNome());
            System.out.println("Usuarios no sistema: " + usuarios);
        } else {
            System.out.println("Tentativa de adicionar usuario nulo.");
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
