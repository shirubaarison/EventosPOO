package com.grupog.eventospoo.model;

import java.time.LocalDateTime;
import com.grupog.eventospoo.utils.exceptions.AtividadeException;
import com.grupog.eventospoo.utils.exceptions.AvaliacaoException;

public class Avaliacao {
    private int id;
    private int nota;
    private String comentario;
    private LocalDateTime dateTime;

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
