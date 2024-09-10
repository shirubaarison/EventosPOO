package com.grupog.eventospoo.utils.exceptions;

public class OrganizadorException extends Exception {
    public OrganizadorException(String message) {
        super(message);
    }

    public OrganizadorException(String message, Throwable cause) {
        super(message, cause);
    }

    // Exceções específicas para Organizador
    public static class AtividadeNotFoundException extends OrganizadorException {
        public AtividadeNotFoundException(String message) {
            super(message);
        }
    }

    public static class MensagemNotFoundException extends OrganizadorException {
        public MensagemNotFoundException(String message) {
            super(message);
        }
    }

    public static class EventoNotFoundException extends OrganizadorException {
        public EventoNotFoundException(String message) {
            super(message);
        }
    }

    public static class InvalidMensagemException extends OrganizadorException {
        public InvalidMensagemException(String message) {
            super(message);
        }
    }

    public static class InvalidStatusException extends OrganizadorException {
        public InvalidStatusException(String message) {
            super(message);
        }
    }
}
