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
        try {
            if (id < 0) {
            throw new CertificadoException.InvalidIdException("Id não pode ser negativo.");
        }this.id = id; }
        catch (CertificadoException.InvalidIdException e) {
            System.out.println("Erro ao definir id" + e.getMessage());
        }
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        try {
            if (dateTime == null) {
            throw new CertificadoException.InvalidDateTimeException("Data não pode ser nula.\n");
        }
            this.dateTime = dateTime; }
            catch (CertificadoException.InvalidDateTimeException e) {
                System.out.println("Erro ao definir data" + e.getMessage());
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
        try {
        if (observacao == null || observacao.isEmpty()) {
            throw new CertificadoException.InvalidObservacaoException("Observação não pode ser nula.\n");
        } this.observacao = observacao; }
        catch(CertificadoException.InvalidObservacaoException e) {
            System.out.println("Erro ao definir a observação." + e.getMessage());
        }
    }
}
