package com.grupog.eventospoo.model;

/**
 * Enum que representa os diferentes tipos de usuários no sistema.
 */
public enum TipoUsuario {
    VISITANTE,   // Usuário que apenas participa dos eventos
    ORGANIZADOR, // Usuário que organiza eventos
    AUTOR;       // Usuário que cria e publica conteúdo para os eventos

    /**
     * Converte uma string para o tipo de usuário correspondente no enum.
     *
     * @param tipo A string representando o tipo de usuário
     * @return O TipoUsuario correspondente à string fornecida
     * @throws TipoUsuarioInvalidoException Se a string não corresponder a nenhum tipo de usuário válido
     */
    public static TipoUsuario fromString(String tipo) {
        try {
            return TipoUsuario.valueOf(tipo.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: Tipo de usuário inválido - " + tipo);
            throw new TipoUsuarioInvalidoException("Tipo de usuário inválido: " + tipo);
        }
    }

    /**
     * Exceção lançada quando um tipo de usuário inválido é fornecido.
     */
    public static class TipoUsuarioInvalidoException extends RuntimeException {
        public TipoUsuarioInvalidoException(String message) {
            super(message);
        }
    }
}
