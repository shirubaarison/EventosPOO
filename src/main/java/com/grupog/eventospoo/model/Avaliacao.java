package com.grupog.eventospoo.model;

import java.time.LocalDateTime;
import com.grupog.eventospoo.exceptions.AvaliacaoException;

/**
 * Representa uma avaliação de um evento por um usuário.
 * Inclui informações como o evento avaliado, a nota, o comentário, a data e hora da avaliação, e o usuário que fez a avaliação.
 */
public class Avaliacao {
    private int id;
    private Evento evento;
    private int nota;
    private String comentario;
    private LocalDateTime dateTime;
    private Usuario usuario;

    /**
     * Construtor para criar uma nova avaliação.
     * Inicializa a avaliação com o evento, nota, comentário, data e hora, e o usuário.
     *
     * @param evento     Evento avaliado
     * @param nota       Nota dada ao evento
     * @param comentario Comentário sobre o evento
     * @param dateTime   Data e hora da avaliação
     * @param usuario    Usuário que fez a avaliação
     */
    public Avaliacao(Evento evento, int nota, String comentario, LocalDateTime dateTime, Usuario usuario) {
        setEvento(evento);
        setNota(nota);
        setComentario(comentario);
        setDateTime(dateTime);
        setUsuario(usuario);
    }

    /**
     * Retorna o usuário que fez a avaliação.
     *
     * @return Usuário que fez a avaliação
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Define o usuário que fez a avaliação.
     * Se o usuário for nulo, a operação é ignorada.
     *
     * @param usuario Usuário que fez a avaliação
     */
    public void setUsuario(Usuario usuario) {
        if (usuario == null) return;
        this.usuario = usuario;
    }

    /**
     * Retorna o evento que está sendo avaliado.
     *
     * @return Evento avaliado
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * Define o evento que está sendo avaliado.
     * Se o evento for nulo, a operação é ignorada.
     *
     * @param evento Evento avaliado
     */
    public void setEvento(Evento evento) {
        if (evento == null) return;
        this.evento = evento;
    }

    /**
     * Retorna o identificador da avaliação.
     *
     * @return ID da avaliação
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da avaliação.
     * O ID deve ser maior ou igual a zero.
     *
     * @param id Identificador da avaliação
     */
    public void setId(int id) {
        try {
            if (id < 0) {
                throw new AvaliacaoException.InvalidIdException("ID inválido. O valor deve ser maior que zero.");
            }
            this.id = id;
        } catch (AvaliacaoException.InvalidIdException e) {
            System.out.println("Erro ao definir ID: " + e.getMessage());
        }
    }

    /**
     * Retorna a nota dada ao evento.
     *
     * @return Nota da avaliação
     */
    public int getNota() {
        return nota;
    }

    /**
     * Define a nota dada ao evento.
     * A nota deve ser maior ou igual a zero.
     *
     * @param nota Nota da avaliação
     */
    public void setNota(int nota) {
        try {
            if (nota < 0) {
                throw new AvaliacaoException.InvalidNotaException("Nota deve ser maior ou igual a zero.");
            }
            this.nota = nota;
        } catch (AvaliacaoException.InvalidNotaException e) {
            System.out.println("Erro ao definir nota: " + e.getMessage());
        }
    }

    /**
     * Retorna o comentário sobre o evento.
     *
     * @return Comentário da avaliação
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Define o comentário sobre o evento.
     * O comentário não pode ser nulo ou vazio.
     *
     * @param comentario Comentário sobre o evento
     */
    public void setComentario(String comentario) {
        try {
            if (comentario == null || comentario.isEmpty()) {
                throw new AvaliacaoException.InvalidComentarioException("Comentário não deve estar em branco.");
            }
            this.comentario = comentario;
        } catch (AvaliacaoException.InvalidComentarioException e) {
            System.out.println("Erro ao definir comentário: " + e.getMessage());
        }
    }

    /**
     * Retorna a data e hora da avaliação.
     *
     * @return Data e hora da avaliação
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Define a data e hora da avaliação.
     * A data e hora não podem ser nulas.
     *
     * @param dateTime Data e hora da avaliação
     */
    public void setDateTime(LocalDateTime dateTime) {
        try {
            if (dateTime == null) {
                throw new AvaliacaoException.InvalidDateTimeException("Data não pode ser nula.");
            }
            this.dateTime = dateTime;
        } catch (AvaliacaoException.InvalidDateTimeException e) {
            System.out.println("Erro ao definir data e hora: " + e.getMessage());
        }
    }
}
