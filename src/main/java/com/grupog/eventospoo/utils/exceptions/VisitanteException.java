package com.grupog.eventospoo.utils.exceptions;

public class VisitanteException extends Exception {
    public VisitanteException(String message) {
        super(message);
    }

    public VisitanteException(String message, Throwable cause) {
        super(message, cause);
    }

    
    public static class InvalidIdException extends VisitanteException {
        public InvalidIdException(String message) {
            super(message);
        }
    }

    public static class InvalidFeedbackException extends VisitanteException {
        public InvalidFeedbackException(String message) {
            super(message);
        }
    }

    public static class AtividadeNotProvidedException extends VisitanteException {
        public AtividadeNotProvidedException(String message) {
            super(message);
        }
    }
}
