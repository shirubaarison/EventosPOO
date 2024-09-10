package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.PasswordUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemModel {
    private static SystemModel instance;

    private final Map<String, Usuario> usuarios = new HashMap<>();
    private final ObservableMap<String, Evento> eventos = FXCollections.observableHashMap();
    private final ObjectProperty<Usuario> usuarioLogado = new SimpleObjectProperty<>();
    private final ObservableMap<String, Evento> eventosInscritos = FXCollections.observableHashMap();
    private final ObservableList<Avaliacao> avaliacoes = FXCollections.observableArrayList();

    public SystemModel() {
        // Inicializa com usuários
        addUsuario(new Usuario("amostradinho", "123.123.123-43", "UFC", PasswordUtils.hashPassword("123"), "amostradinho@gmail.com", TipoUsuario.VISITANTE));
        addUsuario(new Usuario("caska de bala", "113.123.123-43", "UFBA", PasswordUtils.hashPassword("22"), "caska@gmail.com", TipoUsuario.ORGANIZADOR));
        addUsuario(new Usuario("borabill", "123.123.123-43", "UFRN", PasswordUtils.hashPassword("boraBill"), "borabill@gmail.com", TipoUsuario.AUTOR));

        // Inicializar com eventos
        addEvento(new Evento("SESCOMP", "O maior evento de tecnologia do vale do Jaguaribe", new Date(), "00:00", new Local("UFC Campus Russas", "Rua Universitária")));
        addEvento(new Evento("Torneio de Baladeira", "Valendo 2 milhões", new Date(), "01:00", new Local("Figuereido", "Figuereido")));
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

    public void addEvento(Evento evento) {
        if (evento != null) {
            this.eventos.put(evento.getNome(), evento);
        } else {
            throw new IllegalArgumentException("Tentativa de adicionar evento nulo");
        }
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public ObservableMap<String, Evento> getEventos() {
        return eventos;
    }

    public ObservableMap<String, Evento> getEventosInscritos() {
        return eventosInscritos;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado.get();
    }

    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado.set(usuario);
    }

    public void logout() {
        setUsuarioLogado(null);
        eventosInscritos.clear();
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

    public void inscrever(Evento evento) {
        if (evento == null) return; // Optionally throw exception

        Usuario usuarioConectado = getUsuarioLogado();
        if (usuarioConectado == null) return; // Handle case where no user is logged in

        usuarioConectado.inscreverNoEvento(evento);
        eventosInscritos.put(evento.getNome(), evento);
    }

    public void desinscrever(Evento evento) {
        if (evento == null) return;

        Usuario usuarioConectado = getUsuarioLogado();
        if (usuarioConectado == null) return;

        usuarioConectado.desinscreverDoEvento(evento);
        eventosInscritos.remove(evento.getNome());
    }

    public void removerEvento(Evento evento) {
        if (evento == null) {
            throw new IllegalArgumentException("Tentativa de remover evento nulo");
        }

        eventos.remove(evento.getNome());

        eventosInscritos.remove(evento.getNome());

        for (Usuario usuario : usuarios.values()) {
            if (usuario.getEventosInscritos().contains(evento)) {
                usuario.desinscreverDoEvento(evento);
            }
        }

        System.out.println("Evento " + evento.getNome() + " removido com sucesso.");
    }

    public void removerEvento(String nome) {
        // Find the event by its name
        Evento evento = eventos.get(nome);

        // If the event doesn't exist, throw an exception
        if (evento == null) {
            throw new IllegalArgumentException("Tentativa de remover evento inexistente: " + nome);
        }

        // Proceed with the same logic as in removerEvento(Evento evento)
        removerEvento(evento);
    }

    public void addAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public ObservableList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public ObservableList<Avaliacao> getAvaliacoesByEvento(Evento evento) {
        ObservableList<Avaliacao> result = FXCollections.observableArrayList();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getEvento().equals(evento)) {
                result.add(avaliacao);
            }
        }
        return result;
    }
}
