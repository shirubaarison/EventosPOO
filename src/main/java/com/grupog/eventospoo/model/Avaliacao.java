package com.grupog.eventospoo.model;

import java.time.LocalDateTime;
import com.grupog.eventospoo.utils.exceptions.AtividadeException;
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
        if (id < 0) {
            throw new AvaliacaoException.InvalidIdException("ID inválido. O valor deve ser maior que zero.");
        }else {
            this.id = id;
        }
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        if (nota < 0) {
            throw new AvaliacaoException.InvalidNotaException("Nota deve ser maior ou igual a zero.\n");
        }else {
            this.nota = nota;
        }
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        if (comentario == null || comentario.isEmpty()) {
            throw new AvaliacaoException.InvalidComentarioException("Comentário não deve estar em branco.\n");
        }else {
            this.comentario = comentario;
        }
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            throw new AvaliacaoException.InvalidDateTimeException("Data não pode ser nula.\n");
        }else {
            this.dateTime = dateTime;
        }
    }
}
