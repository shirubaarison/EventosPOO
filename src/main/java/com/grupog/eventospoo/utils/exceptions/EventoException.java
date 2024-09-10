package com.grupog.eventospoo.utils.exceptions;

public class EventoException extends Exception {
    public EventoException(String message) {
        super(message);
    }

    public EventoException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class InvalidIdException extends EventoException {
        public InvalidIdException(String message) {
            super(message);
        }
    }

    public static class InvalidNomeException extends EventoException {
        public InvalidNomeException(String message) {
            super(message);
        }
    }

    public static class InvalidDataException extends EventoException {
        public InvalidDataException(String message) {
            super(message);
        }
    }

    public static class InvalidHoraException extends EventoException {
        public InvalidHoraException(String message) {
            super(message);
        }
    }

    public static class InvalidLocalizacaoException extends EventoException {
        public InvalidLocalizacaoException(String message) {
            super(message);
        }
    }

    public static class InvalidNotaException extends EventoException {
        public InvalidNotaException(String message) {
            super(message);
        }
    }

    public static class EventoNotFoundException extends Exception {
        public EventoNotFoundException(String message) {
            super(message);
        }

        public EventoNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class InvalidEventoException extends Exception {
        public InvalidEventoException(String message) {
            super(message);
        }

        public InvalidEventoException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    public static class InvalidDescricaoException extends EventoException {
        public InvalidDescricaoException(String message) {
            super(message);
        }
    }
}
