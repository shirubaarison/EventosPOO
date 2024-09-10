package com.grupog.eventospoo.model;

public enum TipoAtividade {
    PALESTRA, VIDEOCONFERENCIA, MINICURSO, RODA, CULTURAL, EXPOSICAO;

    public static TipoAtividade fromString(String tipo) { // converte em string e verifica se o enum inserido é valido
        try {
            return TipoAtividade.valueOf(tipo.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: Tipo de atividade inválido - " + tipo);
            throw new TipoAtividadeInvalidoException("Tipo de atividade inválido: " + tipo);
        }
    }

    public static class TipoAtividadeInvalidoException extends RuntimeException {
        public TipoAtividadeInvalidoException(String message) {
            super(message);
        }
    }
}
