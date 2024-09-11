package com.grupog.eventospoo.model;

import com.grupog.eventospoo.exceptions.MensagemException;
import com.grupog.eventospoo.exceptions.UsuarioException;

/**
 * Representa uma mensagem enviada por um usuário.
 * Inclui informações como o texto da mensagem, remetente, horário e status.
 */
public class Mensagem {
    private String texto;
    private Usuario remetente;
    private String horario;
    private Status status;

    /**
     * Construtor para criar uma nova mensagem com os detalhes fornecidos.
     *
     * @param texto     Conteúdo da mensagem
     * @param remetente Usuário que enviou a mensagem
     * @param horario   Horário em que a mensagem foi enviada
     * @param status    Status da mensagem
     * @throws MensagemException Se o texto ou horário for inválido
     * @throws UsuarioException  Se o remetente for nulo
     */
    public Mensagem(String texto, Usuario remetente, String horario, Status status) throws MensagemException, UsuarioException {
        this.setTexto(texto);
        this.setRemetente(remetente);
        this.setHorario(horario);
        this.setStatus(status);
    }

    /**
     * Retorna o conteúdo da mensagem.
     *
     * @return Texto da mensagem
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Define o conteúdo da mensagem.
     * O texto não pode ser nulo ou vazio.
     *
     * @param texto Conteúdo da mensagem
     * @throws MensagemException.InvalidTexto Se o texto for inválido
     */
    public void setTexto(String texto) throws MensagemException.InvalidTexto {
        if (texto == null || texto.isEmpty()) {
            throw new MensagemException.InvalidTexto("Texto inválido ou nulo: " + texto);
        }
        this.texto = texto;
    }

    /**
     * Retorna o usuário que enviou a mensagem.
     *
     * @return Usuário remetente
     */
    public Usuario getRemetente() {
        return remetente;
    }

    /**
     * Define o usuário que enviou a mensagem.
     * O remetente não pode ser nulo.
     *
     * @param remetente Usuário que enviou a mensagem
     * @throws UsuarioException Se o remetente for nulo
     */
    public void setRemetente(Usuario remetente) throws UsuarioException {
        if (remetente == null) {
            throw new UsuarioException("Usuário nulo");
        }
        this.remetente = remetente;
    }

    /**
     * Retorna o horário em que a mensagem foi enviada.
     *
     * @return Horário da mensagem
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Define o horário em que a mensagem foi enviada.
     * O horário não pode ser nulo.
     *
     * @param horario Horário da mensagem
     * @throws MensagemException.InvalidHorario Se o horário for inválido
     */
    public void setHorario(String horario) throws MensagemException.InvalidHorario {
        if (horario == null) {
            throw new MensagemException.InvalidHorario("Horário inválido");
        }
        this.horario = horario;
    }

    /**
     * Retorna o status da mensagem.
     *
     * @return Status da mensagem
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Define o status da mensagem.
     * O status não pode ser nulo.
     *
     * @param status Status da mensagem
     * @throws MensagemException.StatusInvalido Se o status for inválido
     */
    public void setStatus(Status status) throws MensagemException.StatusInvalido {
        if (status == null) {
            throw new MensagemException.StatusInvalido("Status inválido");
        }
        this.status = status;
    }

    /**
     * Altera o status da mensagem.
     * Se o novo status for inválido, exibe uma mensagem de erro.
     *
     * @param status Novo status da mensagem
     */
    public void alterarStatus(Status status) {
        try {
            if (status == null) {
                throw new MensagemException.StatusInvalido("Status inválido.");
            }
            this.status = status;
        } catch (MensagemException.StatusInvalido e) {
            System.out.println("Erro ao definir status: " + e.getMessage());
        }
    }

    /**
     * Altera o conteúdo da mensagem.
     * Se o novo texto for inválido, exibe uma mensagem de erro.
     *
     * @param novaMensagem Novo texto da mensagem
     */
    public void alterarMensagem(String novaMensagem) {
        try {
            if (novaMensagem == null || novaMensagem.isEmpty()) {
                throw new MensagemException.MensagemNulaException("Mensagem não pode ser nula ou vazia.");
            }
            this.texto = novaMensagem;
        } catch (MensagemException.MensagemNulaException e) {
            System.out.println("Erro ao alterar a mensagem: " + e.getMessage());
        }
    }

    /**
     * Retorna uma representação em string da mensagem.
     *
     * @return String com detalhes da mensagem
     */
    @Override
    public String toString() {
        return "Mensagem{" +
                "texto='" + texto + '\'' +
                ", remetente=" + remetente +
                ", horario='" + horario + '\'' +
                ", status=" + status +
                '}';
    }
}
