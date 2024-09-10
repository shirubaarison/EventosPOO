package com.grupog.eventospoo.model;

import java.time.LocalDateTime;
import com.grupog.eventospoo.utils.exceptions.AvaliacaoException;

public class Avaliacao {
    private int id;
    private Evento evento;
    private int nota;
    private String comentario;
    private LocalDateTime dateTime;
    private Usuario usuario;

    public Avaliacao(Evento evento, int nota, String comentario, LocalDateTime dateTime, Usuario usuario) {
        setEvento(evento);
        setNota(nota);
        setComentario(comentario);
        setDateTime(dateTime);
        setUsuario(usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        if (usuario == null) return;
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        if (evento == null) return;
        this.evento = evento;
    }

    public int getId() {
        return id;
    }

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

    public int getNota() {
        return nota;
    }

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

    public String getComentario() {
        return comentario;
    }

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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

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
