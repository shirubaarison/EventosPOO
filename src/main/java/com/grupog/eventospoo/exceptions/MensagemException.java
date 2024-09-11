package com.grupog.eventospoo.exceptions;

public class MensagemException extends Exception {
    public MensagemException(String message) {
        super(message);
    }

    public MensagemException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class MensagemInvalidaException extends MensagemException {
        public MensagemInvalidaException(String message) {
            super(message);
        }
    }

    public static class MensagemNulaException extends MensagemException {
        public MensagemNulaException(String message) {
            super(message);
        }
    }
    public static class StatusInvalido extends MensagemException {
        public StatusInvalido(String message) {
            super(message);
        }
    }
    public static class InvalidRemetente extends MensagemException {
        public InvalidRemetente(String message) {
            super(message);
        }
    }
    public static class InvalidHorario extends MensagemException {
        public InvalidHorario(String message) {
            super(message);
        }
    }

    public static class InvalidTexto extends MensagemException {
        public InvalidTexto(String message) { super(message); }
    }

}


