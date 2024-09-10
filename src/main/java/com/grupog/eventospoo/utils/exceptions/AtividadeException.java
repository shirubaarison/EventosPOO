package com.grupog.eventospoo.utils.exceptions;

public class AtividadeException extends Exception {
    public AtividadeException(String message) {
        super(message);
    }

    public AtividadeException(String message, Throwable cause) {
        super(message, cause);
    }

    // Exceção para ID inválido
    public static class InvalidIdException extends AtividadeException {
        public InvalidIdException(String message) {
            super(message);
        }
    }

    // Exceção para título inválido
    public static class InvalidTituloException extends AtividadeException {
        public InvalidTituloException(String message) {
            super(message);
        }
    }

    // Exceção para tipo de atividade inválido
    public static class InvalidTipoAtividadeException extends AtividadeException {
        public InvalidTipoAtividadeException(String message) {
            super(message);
        }
    }

    // Exceção para avaliação inválida
    public static class AvaliacaoInvalidaException extends AtividadeException {
        public AvaliacaoInvalidaException(String message) {
            super(message);
        }
    }

    
    public static class AtividadeJaConcluidaException extends AtividadeException {
        public AtividadeJaConcluidaException(String message) {
            super(message);
        }
    }

    // Exceção para atividade já cancelada
    public static class AtividadeJaCanceladaException extends AtividadeException {
        public AtividadeJaCanceladaException(String message) {
            super(message);
        }
    }
}
