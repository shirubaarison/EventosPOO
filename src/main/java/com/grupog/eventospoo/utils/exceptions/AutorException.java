package com.grupog.eventospoo.utils.exceptions;

public class AutorException extends RuntimeException {
    public AutorException(String message) {
        super(message);
    }

    public AutorException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class InvalidNomeException extends RuntimeException {
        public InvalidNomeException(String message) {
            super(message);
        }
    }

    public static class InvalidCpfException extends RuntimeException {
        public InvalidCpfException(String message) {
            super(message);
        }
    }

    public static class InvalidInstituicaoException extends RuntimeException {
        public InvalidInstituicaoException(String message) {
            super(message);
        }
    }

    public static class InvalidSenhaException extends RuntimeException {
        public InvalidSenhaException(String message) {
            super(message);
        }
    }

    public static class InvalidEmailException extends RuntimeException {
        public InvalidEmailException(String message) {
            super(message);
        }
    }
}