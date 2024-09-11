package com.grupog.eventospoo.model;

/**
 * Enum que representa os diferentes status possíveis para uma atividade ou evento.
 */
public enum Status {
    ATENDIDO, NAO_ATENDIDO, EM_ANDAMENTO;

    /**
     * Converte uma string para o enum correspondente.
     *
     * @param status A string representando o status.
     * @return O status correspondente ao valor da string.
     * @throws StatusInvalidoException Se a string não corresponder a nenhum valor do enum.
     */
    public static Status fromString(String status) {
        try {
            // Converte a string para maiúsculas e tenta encontrar o valor correspondente no enum
            return Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Se o status não for válido, imprime uma mensagem de erro e lança uma exceção personalizada
            System.err.println("Erro: Status inválido - " + status);
            throw new StatusInvalidoException("Status inválido: " + status);
        }
    }

    /**
     * Exceção personalizada lançada quando um status inválido é fornecido.
     */
    public static class StatusInvalidoException extends RuntimeException {
        public StatusInvalidoException(String message) {
            super(message);
        }
    }
}
