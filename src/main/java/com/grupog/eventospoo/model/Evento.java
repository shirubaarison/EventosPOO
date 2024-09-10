package com.grupog.eventospoo.model;

import java.util.Date;
import com.grupog.eventospoo.utils.exceptions.EventoException;

public class Evento {
    private int id;
    private String nome;
    private String descricao;
    private Date data;
    private String hora;
    private Local localizacao;

    public Evento(int id, String nome, String descricao, Date data, String hora, Local localizacao) throws EventoException.InvalidIdException, EventoException.InvalidNomeException, EventoException.InvalidDataException, EventoException.InvalidHoraException, EventoException.InvalidLocalizacaoException {
        setId(id);
        setNome(nome);
        setDescricao(descricao);
        setData(data);
        setHora(hora);
        setLocalizacao(localizacao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws EventoException.InvalidIdException {
        if (id <= 0) {
            throw new EventoException.InvalidIdException("ID inválido. Deve ser maior que zero.");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws EventoException.InvalidNomeException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new EventoException.InvalidNomeException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) throws EventoException.InvalidDataException {
        if (data == null) {
            throw new EventoException.InvalidDataException("Data não pode ser nula.");
        }
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) throws EventoException.InvalidHoraException {
        if (hora == null || hora.trim().isEmpty()) {
            throw new EventoException.InvalidHoraException("Hora não pode ser nula ou vazia.");
        }
        this.hora = hora;
    }

    public Local getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Local localizacao) throws EventoException.InvalidLocalizacaoException {
        if (localizacao == null) {
            throw new EventoException.InvalidLocalizacaoException("Localização não pode ser nula.");
        }
        this.localizacao = localizacao;
    }
}
