package com.grupog.eventospoo.model;

import java.util.Date;
import com.grupog.eventospoo.exceptions.EventoException;

/**
 * Representa um evento com informações como nome, descrição, data, hora e localização.
 * Inclui métodos para definir e obter essas informações, com validações para garantir dados corretos.
 */
public class Evento {
    private int id;
    private String nome;
    private String descricao;
    private Date data;
    private String hora;
    private Local localizacao;

    /**
     * Construtor para criar um novo evento com informações fornecidas.
     * Inicializa o evento com o nome, descrição, data, hora e localização.
     *
     * @param nome        Nome do evento
     * @param descricao   Descrição do evento
     * @param data        Data do evento
     * @param hora        Hora do evento
     * @param localizacao Localização do evento
     */
    public Evento(String nome, String descricao, Date data, String hora, Local localizacao) {
        setNome(nome);
        setDescricao(descricao);
        setData(data);
        setHora(hora);
        setLocalizacao(localizacao);
    }

    /**
     * Retorna o identificador do evento.
     *
     * @return ID do evento
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do evento.
     * O ID deve ser maior que zero.
     *
     * @param id Identificador do evento
     */
    public void setId(int id) {
        try {
            if (id <= 0) {
                throw new EventoException.InvalidIdException("ID inválido. Deve ser maior que zero.");
            }
            this.id = id;
        } catch (EventoException.InvalidIdException e) {
            System.out.println("Erro ao definir o ID: " + e.getMessage());
        }
    }

    /**
     * Retorna o nome do evento.
     *
     * @return Nome do evento
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do evento.
     * O nome não pode ser nulo ou vazio.
     *
     * @param nome Nome do evento
     */
    public void setNome(String nome) {
        try {
            if (nome == null || nome.trim().isEmpty()) {
                throw new EventoException.InvalidNomeException("Nome não pode ser nulo ou vazio.");
            }
            this.nome = nome;
        } catch (EventoException.InvalidNomeException e) {
            System.out.println("Erro ao definir o nome do evento: " + e.getMessage());
        }
    }

    /**
     * Retorna a descrição do evento.
     *
     * @return Descrição do evento
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do evento.
     * A descrição não pode ser nula ou vazia.
     *
     * @param descricao Descrição do evento
     */
    public void setDescricao(String descricao) {
        try {
            if (descricao == null || descricao.trim().isEmpty()) {
                throw new EventoException.InvalidDescricaoException("Descrição não pode ser nula ou vazia.");
            }
            this.descricao = descricao;
        } catch (EventoException.InvalidDescricaoException e) {
            System.out.println("Erro ao definir a descrição do evento: " + e.getMessage());
        }
    }

    /**
     * Retorna a data do evento.
     *
     * @return Data do evento
     */
    public Date getData() {
        return data;
    }

    /**
     * Define a data do evento.
     * A data não pode ser nula.
     *
     * @param data Data do evento
     */
    public void setData(Date data) {
        try {
            if (data == null) {
                throw new EventoException.InvalidDataException("Data não pode ser nula.");
            }
            this.data = data;
        } catch (EventoException.InvalidDataException e) {
            System.out.println("Erro ao definir a data do evento: " + e.getMessage());
        }
    }

    /**
     * Retorna a hora do evento.
     *
     * @return Hora do evento
     */
    public String getHora() {
        return hora;
    }

    /**
     * Define a hora do evento.
     * A hora não pode ser nula ou vazia.
     *
     * @param hora Hora do evento
     */
    public void setHora(String hora) {
        try {
            if (hora == null || hora.trim().isEmpty()) {
                throw new EventoException.InvalidHoraException("Hora não pode ser nula ou vazia.");
            }
            this.hora = hora;
        } catch (EventoException.InvalidHoraException e) {
            System.out.println("Erro ao definir a hora do evento: " + e.getMessage());
        }
    }

    /**
     * Retorna a localização do evento.
     *
     * @return Localização do evento
     */
    public Local getLocalizacao() {
        return localizacao;
    }

    /**
     * Define a localização do evento.
     * A localização não pode ser nula.
     *
     * @param localizacao Localização do evento
     */
    public void setLocalizacao(Local localizacao) {
        try {
            if (localizacao == null) {
                throw new EventoException.InvalidLocalizacaoException("Localização não pode ser nula.");
            }
            this.localizacao = localizacao;
        } catch (EventoException.InvalidLocalizacaoException e) {
            System.out.println("Erro ao definir a localização do evento: " + e.getMessage());
        }
    }
}
