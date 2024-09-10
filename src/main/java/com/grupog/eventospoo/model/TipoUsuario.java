package com.grupog.eventospoo.model;

public enum TipoUsuario {
    VISITANTE,
    ORGANIZADOR,
    AUTOR;

    public static TipoUsuario fromString(String tipo) { // converte em string e verifica se o enum inserido é valido
        try {
            return TipoUsuario.valueOf(tipo.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: Tipo de usuário inválido - " + tipo);
            throw new TipoUsuarioInvalidoException("Tipo de usuário inválido: " + tipo);
        }
    }

    public static class TipoUsuarioInvalidoException extends RuntimeException {
        public TipoUsuarioInvalidoException(String message) {
            super(message);
        }
    }
}
