package com.grupog.eventospoo.model;

import java.time.LocalDateTime;
import com.grupog.eventospoo.exceptions.CertificadoException;

/**
 * Representa um certificado emitido para um evento ou atividade.
 * Inclui informações como o identificador, a data e hora da emissão, o status,
 * e uma observação adicional.
 */
public class Certificado {
    private int id;
    private LocalDateTime dateTime;
    private boolean status;
    private String observacao;

    /**
     * Retorna o identificador do certificado.
     *
     * @return ID do certificado
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do certificado.
     * O ID não pode ser negativo.
     *
     * @param id Identificador do certificado
     */
    public void setId(int id) {
        try {
            if (id < 0) {
                throw new CertificadoException.InvalidIdException("Id não pode ser negativo.");
            }
            this.id = id;
        } catch (CertificadoException.InvalidIdException e) {
            System.out.println("Erro ao definir id: " + e.getMessage());
        }
    }

    /**
     * Retorna a data e hora da emissão do certificado.
     *
     * @return Data e hora da emissão
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Define a data e hora da emissão do certificado.
     * A data e hora não podem ser nulas.
     *
     * @param dateTime Data e hora da emissão
     */
    public void setDateTime(LocalDateTime dateTime) {
        try {
            if (dateTime == null) {
                throw new CertificadoException.InvalidDateTimeException("Data não pode ser nula.");
            }
            this.dateTime = dateTime;
        } catch (CertificadoException.InvalidDateTimeException e) {
            System.out.println("Erro ao definir data: " + e.getMessage());
        }
    }

    /**
     * Retorna o status do certificado.
     *
     * @return Status do certificado
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Define o status do certificado.
     *
     * @param status Status do certificado
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Retorna a observação adicional sobre o certificado.
     *
     * @return Observação do certificado
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Define a observação adicional sobre o certificado.
     * A observação não pode ser nula ou vazia.
     *
     * @param observacao Observação adicional
     */
    public void setObservacao(String observacao) {
        try {
            if (observacao == null || observacao.isEmpty()) {
                throw new CertificadoException.InvalidObservacaoException("Observação não pode ser nula ou vazia.");
            }
            this.observacao = observacao;
        } catch (CertificadoException.InvalidObservacaoException e) {
            System.out.println("Erro ao definir a observação: " + e.getMessage());
        }
    }
}
