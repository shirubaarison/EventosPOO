package com.grupog.eventospoo.utils.exceptions;

public class UsuarioException extends RuntimeException {
    public UsuarioException(String message) {
        super(message);
    }

    public UsuarioException(String message, Throwable cause) {
        super(message, cause);
    }

    // Exceção para nome inválido
    public static class InvalidNomeException extends UsuarioException {
        public InvalidNomeException(String message) {
            super(message);
        }
    }

    // Exceção para CPF inválido
    public static class InvalidCpfException extends UsuarioException {
        public InvalidCpfException(String message) {
            super(message);
        }
    }

    
    public static class InvalidInstituicaoException extends UsuarioException {
        public InvalidInstituicaoException(String message) {
            super(message);
        }
    }

    public static class InvalidEmailException extends UsuarioException {
        public InvalidEmailException(String message) {
            super(message);
        }
    }

    
    public static class InvalidSenhaException extends UsuarioException {
        public InvalidSenhaException(String message) {
            super(message);
        }
    }

    
    public static class InvalidTipoUsuarioException extends UsuarioException {
        public InvalidTipoUsuarioException(String message) {
            super(message);
        }
    }

    // Exceção para evento inválido ao tentar se inscrever
    public static class InvalidEventoException extends UsuarioException {
        public InvalidEventoException(String message) {
            super(message);
        }
    }

    // Exceção para falha ao cancelar inscrição
    public static class EventoNaoEncontradoException extends UsuarioException {
        public EventoNaoEncontradoException(String message) {
            super(message);
        }
    }
}
