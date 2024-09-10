package com.grupog.eventospoo.utils.exceptions;

public class CertificadoException extends Exception {
    public CertificadoException(String message) {
        super(message);
    }

    public CertificadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class InvalidIdException extends CertificadoException {
        public InvalidIdException(String message) {
            super(message);
        }
    }

    public static class InvalidDateTimeException extends CertificadoException {
        public InvalidDateTimeException(String message) {
            super(message);
        }
    }

    public static class InvalidStatusException extends CertificadoException {
        public InvalidStatusException(String message) {
            super(message);
        }
    }

    public static class InvalidObservacaoException extends CertificadoException {
        public InvalidObservacaoException(String message) {
            super(message);
        }
    }
}
