package com.grupog.eventospoo.utils.exceptions;

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
}
