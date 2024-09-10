package com.grupog.eventospoo.utils.exceptions;

public class AutorException extends UsuarioException {
    public AutorException(String message) {
        super(message);
    }

    public AutorException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class InvalidNomeException extends UsuarioException.InvalidNomeException {
        public InvalidNomeException(String message) {
            super(message);
        }
    }

    public static class InvalidCpfException extends UsuarioException.InvalidCpfException {
        public InvalidCpfException(String message) {
            super(message);
        }
    }

    public static class InvalidInstituicaoException extends UsuarioException.InvalidInstituicaoException {
        public InvalidInstituicaoException(String message) {
            super(message);
        }
    }

    public static class InvalidSenhaException extends UsuarioException.InvalidSenhaException {
        public InvalidSenhaException(String message) {
            super(message);
        }
    }

    public static class InvalidEmailException extends UsuarioException.InvalidEmailException {
        public InvalidEmailException(String message) {
            super(message);
        }
    }
}
