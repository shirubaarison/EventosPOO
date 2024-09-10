package com.grupog.eventospoo.utils.exceptions;

public class OrganizadorException extends Exception {
    public OrganizadorException(String message) {
        super(message);
    }

    public OrganizadorException(String message, Throwable cause) {
        super(message, cause);
    }

    
    public static class InvalidNameException extends OrganizadorException {
        public InvalidNameException(String message) {
            super(message);
        }
    }
    
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
    public static class OrganizadorInvalidCpfException extends OrganizadorException {
        public OrganizadorInvalidCpfException(String message) {
            super(message);
        }
    }

    public static class InvalidMensagemException extends OrganizadorException {
        public InvalidMensagemException(String message) {
            super(message);
        }
    }
    public static class InvalidInstituicaoException extends OrganizadorException {
        public InvalidInstituicaoException (String message) {
            super(message);
        }
    }

    public static class InvalidStatusException extends OrganizadorException {
        public InvalidStatusException(String message) {
            super(message);
        }
    }
    public class InvalidSenhaException extends OrganizadorException {
        public InvalidSenhaException(String message) {
            super(message);
        }
    }
    public class InvalidEmailException extends OrganizadorException {
        public InvalidEmailException(String message) {
            super(message);
        }
    }
    public class InvalidCpfException extends OrganizadorException {
        public InvalidCpfException(String message) {
            super(message);
        }
    }
}
