package com.grupog.eventospoo.exceptions;

public class PatrocinadorException extends Exception {
    public PatrocinadorException(String message) {
        super(message);
    }

    public PatrocinadorException(String message, Throwable cause) {
        super(message, cause);
    }

    // Exceções específicas para Patrocinador
    public static class InvalidIdException extends PatrocinadorException {
        public InvalidIdException(String message) {
            super(message);
        }
    }

    public static class InvalidNomeException extends PatrocinadorException {
        public InvalidNomeException(String message) {
            super(message);
        }
    }

    public static class InvalidContribuicaoException extends PatrocinadorException {
        public InvalidContribuicaoException(String message) {
            super(message);
        }
    }
}
