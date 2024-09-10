package com.grupog.eventospoo.utils.exceptions;

public class UsuarioException extends Exception {
    public UsuarioException(String message) {
        super(message);
    }

    public UsuarioException(String message, Throwable cause) {
        super(message, cause);
    }

    
    public static class InvalidNomeException extends UsuarioException {
        public InvalidNomeException(String message) {
            super(message);
        }
    }

    
    public static class InvalidCpfException extends UsuarioException {
        public InvalidCpfException(String message) {
            super(message);
        }
    }

    public static class InvalidInstituicaoException extends UsuarioException {
        public InvalidInstituicaoException(String message) {
            super(message);
        }
    }

    public static class InvalidEmailException extends UsuarioException {
        public InvalidEmailException(String message) {
            super(message);
        }
    }

    public static class InvalidSenhaException extends UsuarioException {
        public InvalidSenhaException(String message) {
            super(message);
        }
    }

    public static class InvalidTipoUsuarioException extends UsuarioException {
        public InvalidTipoUsuarioException(String message) {
            super(message);
        }
    }

    public static class InvalidEventoException extends UsuarioException {
        public InvalidEventoException(String message) {
            super(message);
        }
    }

    public static class EventoNaoEncontradoException extends UsuarioException {
        public EventoNaoEncontradoException(String message) {
            super(message);
        }
    }
}
