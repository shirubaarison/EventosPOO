package com.grupog.eventospoo.model;

/**
 * Enum que representa os diferentes tipos de atividades que podem ocorrer em um evento.
 */
public enum TipoAtividade {
    PALESTRA, VIDEOCONFERENCIA, MINICURSO, RODA, CULTURAL, EXPOSICAO;

    /**
     * Converte uma string para o tipo de atividade correspondente no enum.
     *
     * @param tipo A string representando o tipo de atividade
     * @return O TipoAtividade correspondente à string fornecida
     * @throws TipoAtividadeInvalidoException Se a string não corresponder a nenhum tipo de atividade válido
     */
    public static TipoAtividade fromString(String tipo) {
        try {
            return TipoAtividade.valueOf(tipo.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: Tipo de atividade inválido - " + tipo);
            throw new TipoAtividadeInvalidoException("Tipo de atividade inválido: " + tipo);
        }
    }

    /**
     * Exceção lançada quando um tipo de atividade inválido é fornecido.
     */
    public static class TipoAtividadeInvalidoException extends RuntimeException {
        public TipoAtividadeInvalidoException(String message) {
            super(message);
        }
    }
}
