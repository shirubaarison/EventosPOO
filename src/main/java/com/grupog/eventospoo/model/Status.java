package com.grupog.eventospoo.model;

public enum Status {
    ATENDIDO, NAO_ATENDIDO, EM_ANDAMENTO;

    public static Status fromString(String status) { // converte em string e verifica se o enum inserido é valido
        try {
            return Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: Status inválido - " + status);
            throw new StatusInvalidoException("Status inválido: " + status);
        }
    }

    public static class StatusInvalidoException extends RuntimeException {
        public StatusInvalidoException(String message) {
            super(message);
        }
    }
}
