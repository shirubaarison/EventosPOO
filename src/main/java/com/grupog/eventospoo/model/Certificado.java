package com.grupog.eventospoo.model;

import java.time.LocalDateTime;

import com.grupog.eventospoo.utils.exceptions.CertificadoException;

public class Certificado {
    private int id;
    private LocalDateTime dateTime;
    private boolean status;
    private String observacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new CertificadoException.InvalidIdException("Id não pode ser negativo.\n");
        }else {
            this.id = id;
        }
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            throw new CertificadoException.InvalidDateTimeException("Data não pode ser nula.\n");
        }else {
            this.dateTime = dateTime;
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        if (observacao == null || observacao.isEmpty()) {
            throw new CertificadoException.InvalidObservacaoException("Observação não pode ser nula.\n");
        }else {
            this.observacao = observacao;
        }
    }
}
