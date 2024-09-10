package com.grupog.eventospoo.model;

import java.time.LocalDateTime;
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
