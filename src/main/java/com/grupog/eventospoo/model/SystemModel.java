package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.PasswordUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemModel {
    private static SystemModel instance;

    private final Map<String, Usuario> usuarios = new HashMap<>();
    private final Map<String, Evento> eventos = new HashMap<>();
    private final ObjectProperty<Usuario> usuarioLogado = new SimpleObjectProperty<>();

    public SystemModel() {
        // Inicializar com alguns usuários...
        addUsuario(new Usuario("amostradinho", "123.123.123-43", "UFC", PasswordUtils.hashPassword("123"), "amostradinho@gmail.com", TipoUsuario.VISITANTE));
        addUsuario(new Usuario("caska de bala", "113.123.123-43", "UFBA", PasswordUtils.hashPassword("22"), "caska@gmail.com", TipoUsuario.ORGANIZADOR));
        addUsuario(new Usuario("borabill", "123.123.123-43", "UFRN", PasswordUtils.hashPassword("boraBill"), "borabill@gmail.com", TipoUsuario.AUTOR));

        // Inicializar com alguns eventos...
        addEvento(new Evento(1, "SESCOMP", "O maior evento de tecnologia do vale do Jaguaribe", new Date(), "00:00", new Local(1, "UFC Campus Russas", "Rua Universitária")));
        addEvento(new Evento(1, "Torneio de Baladeira", "Valendo 2 milhões", new Date(), "01:00", new Local(2, "Figuereido", "Figuereido")));
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

    public Evento getEvento(String nome) {
        return eventos.get(nome);
    }

    public void addUsuario(Usuario user) {
        if (user != null) {
            this.usuarios.put(user.getNome(), user);
        } else {
            throw new IllegalArgumentException("Tentativa de adicionar usuário nulo");
        }
    }
    
    public void addEvento(Evento evento) {
        if (evento != null) {
            this.eventos.put(evento.getNome(), evento);
        } else {
            throw new IllegalArgumentException("Tentativa de adicionar usuário nulo");
        }
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public Map<String, Evento> getEventos() {
        return eventos;
    }

    public Map<String, Evento> getEventosIncritos() {
        Map<String, Evento> eventosIncristos = new HashMap<>();

        Usuario usuario = getUsuarioLogado();

        if (usuario != null) {
            List<Evento> eventosIncristosList = usuario.getEventosInscritos();

            for (Evento evento : eventosIncristosList) {
                if (eventos.containsKey(evento.getNome())) {
                    eventosIncristos.put(evento.getNome(), eventos.get(evento.getNome()));
                }
            }
        }

        return eventosIncristos;
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
