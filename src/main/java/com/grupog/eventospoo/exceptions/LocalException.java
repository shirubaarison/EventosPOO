package com.grupog.eventospoo.exceptions;

public class LocalException extends Exception {
    public LocalException(String message) {
        super(message);
    }

    public LocalException(String message, Throwable cause) {
        super(message, cause);
    }

    // Exceções específicas para Local
    public static class InvalidIdException extends LocalException {
        public InvalidIdException(String message) {
            super(message);
        }
    }

    public static class InvalidNomeException extends LocalException {
        public InvalidNomeException(String message) {
            super(message);
        }
    }

    public static class InvalidEnderecoException extends LocalException {
        public InvalidEnderecoException(String message) {
            super(message);
        }
    }
}
