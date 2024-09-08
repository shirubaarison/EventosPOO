package com.grupog.eventospoo.model;

import java.time.LocalDateTime;

public class Avaliacao {
    private int id;
    private int nota;
    private String comentario;
    private LocalDateTime dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        if (nota > 0) {
            this.nota = nota;
        }
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        if (comentario != null) {
            this.comentario = comentario;
        }
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        if (dateTime != null) {
            this.dateTime = dateTime;
        }
    }
}
