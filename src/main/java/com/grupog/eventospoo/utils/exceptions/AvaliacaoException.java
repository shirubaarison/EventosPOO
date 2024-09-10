package com.grupog.eventospoo.utils.exceptions;

public class AvaliacaoException extends Exception {
    public AvaliacaoException(String message) {
        super(message);
    }

    public AvaliacaoException(String message, Throwable cause) {
        super(message, cause);
    }

    
    public static class InvalidIdException extends AvaliacaoException {
        public InvalidIdException(String message) {
            super(message);
        }
    }

    
    public static class InvalidNotaException extends AvaliacaoException {
        public InvalidNotaException(String message) {
            super(message);
        }
    }

    
    public static class InvalidComentarioException extends AvaliacaoException {
        public InvalidComentarioException(String message) {
            super(message);
        }
    }

    // Exceção para data/hora inválida
    public static class InvalidDateTimeException extends AvaliacaoException {
        public InvalidDateTimeException(String message) {
            super(message);
        }
    }
}
