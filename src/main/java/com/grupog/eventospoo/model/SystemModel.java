package com.grupog.eventospoo.model;

import com.grupog.eventospoo.exceptions.UsuarioException;
import com.grupog.eventospoo.utils.PasswordUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton que gerencia a aplicação, incluindo usuários, eventos e avaliações.
 * Garante que há apenas uma instância de SystemModel na aplicação.
 */
public class SystemModel {
    // Instância única do SystemModel (Singleton)
    private static SystemModel instance;

    // Armazena usuários com o nome como chave
    private final Map<String, Usuario> usuarios = new HashMap<>();

    // Armazena eventos com o nome como chave, utilizando ObservableMap para suporte a mudanças
    private final ObservableMap<String, Evento> eventos = FXCollections.observableHashMap();

    // Propriedade que armazena o usuário atualmente logado
    private final ObjectProperty<Usuario> usuarioLogado = new SimpleObjectProperty<>();

    // Armazena eventos aos quais o usuário logado está inscrito
    private final ObservableMap<String, Evento> eventosInscritos = FXCollections.observableHashMap();

    // Lista observável de avaliações
    private final ObservableList<Avaliacao> avaliacoes = FXCollections.observableArrayList();

    public SystemModel() {

    }

    /**
     * Obtém a instância única do SystemModel (Singleton).
     *
     * @return A instância única do SystemModel
     * @throws UsuarioException Se ocorrer algum erro ao inicializar o SystemModel
     */
    public static SystemModel getInstance() {
        if (instance == null) {
            instance = new SystemModel();
        }
        return instance;
    }

    /**
     * Obtém um usuário pelo nome.
     *
     * @param nome O nome do usuário
     * @return O usuário correspondente ao nome
     */
    public Usuario getUsuario(String nome) {
        return usuarios.get(nome);
    }

    /**
     * Adiciona um novo usuário ao sistema.
     *
     * @param user O usuário a ser adicionado
     * @throws IllegalArgumentException Se o usuário for nulo
     */
    public void addUsuario(Usuario user) {
        if (user != null) {
            this.usuarios.put(user.getNome(), user);
        } else {
            throw new IllegalArgumentException("Tentativa de adicionar usuário nulo");
        }
    }

    /**
     * Adiciona um novo evento ao sistema.
     *
     * @param evento O evento a ser adicionado
     * @throws IllegalArgumentException Se o evento for nulo
     */
    public void addEvento(Evento evento) {
        if (evento != null) {
            this.eventos.put(evento.getNome(), evento);
        } else {
            throw new IllegalArgumentException("Tentativa de adicionar evento nulo");
        }
    }

    /**
     * Obtém todos os usuários do sistema.
     *
     * @return Um mapa de usuários
     */
    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Obtém todos os eventos do sistema.
     *
     * @return Um mapa observável de eventos
     */
    public ObservableMap<String, Evento> getEventos() {
        return eventos;
    }

    /**
     * Obtém todos os eventos aos quais o usuário logado está inscrito.
     *
     * @return Um mapa observável de eventos inscritos
     */
    public ObservableMap<String, Evento> getEventosInscritos() {
        return eventosInscritos;
    }

    /**
     * Obtém o usuário atualmente logado.
     *
     * @return O usuário logado
     */
    public Usuario getUsuarioLogado() {
        return usuarioLogado.get();
    }

    /**
     * Define o usuário logado.
     *
     * @param usuario O usuário a ser definido como logado
     */
    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado.set(usuario);
    }

    /**
     * Realiza o logout do usuário atualmente logado e limpa os eventos inscritos
     */
    public void logout() {
        setUsuarioLogado(null);
        eventosInscritos.clear();
    }

    /**
     * Propriedade do usuário logado.
     *
     * @return A propriedade do usuário logado
     */
    public ObjectProperty<Usuario> usuarioLogadoProperty() {
        return usuarioLogado;
    }

    /**
     * Realiza o login de um usuário.
     *
     * @param nome O nome do usuário
     * @param senha A senha do usuário
     * @return true se o login for bem-sucedido, false caso contrário
     */
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

    /**
     * Inscreve o usuário logado em um evento.
     *
     * @param evento O evento no qual o usuário deseja se inscrever
     */
    public void inscrever(Evento evento) throws UsuarioException {
        if (evento == null) return; // Não faz nada se o evento for nulo

        Usuario usuarioConectado = getUsuarioLogado();
        if (usuarioConectado == null) return; // Não faz nada se nenhum usuário estiver logado

        usuarioConectado.inscreverNoEvento(evento);
        evento.cadastrarUsuario(usuarioConectado);
        eventosInscritos.put(evento.getNome(), evento);
    }

    /**
     * Desinscreve o usuário logado de um evento.
     *
     * @param evento O evento do qual o usuário deseja se desinscrever
     */
    public void desinscrever(Evento evento) throws UsuarioException {
        if (evento == null) return;

        Usuario usuarioConectado = getUsuarioLogado();
        if (usuarioConectado == null) return;

        usuarioConectado.desinscreverDoEvento(evento);
        evento.descadastrarUsuario(usuarioConectado);
        eventosInscritos.remove(evento.getNome());
    }

    /**
     * Remove um evento do sistema.
     *
     * @param evento O evento a ser removido
     * @throws IllegalArgumentException Se o evento for nulo
     */
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
    }

    /**
     * Remove um evento pelo nome.
     *
     * @param nome O nome do evento a ser removido
     * @throws IllegalArgumentException Se o evento não for encontrado
     */
    public void removerEvento(String nome) {
        Evento evento = eventos.get(nome);

        if (evento == null) {
            throw new IllegalArgumentException("Tentativa de remover evento inexistente: " + nome);
        }

        removerEvento(evento);
    }

    /**
     * Adiciona uma avaliação ao sistema.
     *
     * @param avaliacao A avaliação a ser adicionada
     */
    public void addAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    /**
     * Obtém todas as avaliações.
     *
     * @return Uma lista observável de avaliações
     */
    public ObservableList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    /**
     * Obtém todas as avaliações para um evento específico.
     *
     * @param evento O evento para o qual as avaliações devem ser retornadas
     * @return Uma lista observável de avaliações para o evento
     */
    public ObservableList<Avaliacao> getAvaliacoesByEvento(Evento evento) {
        ObservableList<Avaliacao> result = FXCollections.observableArrayList();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getEvento().equals(evento)) {
                result.add(avaliacao);
            }
        }
        return result;
    }

    /**
     * Atualiza um evento existente no sistema.
     *
     * @param evento O evento a ser atualizado
     * @throws IllegalArgumentException Se o evento for nulo ou não existir
     */
    public void updateEvento(Evento evento) {
        if (evento == null) {
            throw new IllegalArgumentException("Tentativa de atualizar evento nulo");
        }

        // Verifica se o evento já existe no sistema
        if (!eventos.containsKey(evento.getNome())) {
            throw new IllegalArgumentException("Evento não encontrado: " + evento.getNome());
        }

        // Atualiza o evento no mapa
        eventos.put(evento.getNome(), evento);

        // Atualiza a lista de eventos inscritos (se necessário)
        for (Map.Entry<String, Evento> entry : eventosInscritos.entrySet()) {
            if (entry.getValue().getNome().equals(evento.getNome())) {
                eventosInscritos.put(evento.getNome(), evento);
            }
        }
    }
}
