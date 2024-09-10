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

    public Evento(int id, String nome, String descricao, Date data, String hora, Local localizacao) {
        try {
            if (id <= 0) {
                throw new EventoException.InvalidIdException("ID inválido. Deve ser maior que zero.");
            }
            if (nome == null || nome.trim().isEmpty()) {
                throw new EventoException.InvalidNomeException("Nome não pode ser nulo ou vazio.");
            }
            if (data == null) {
                throw new EventoException.InvalidDataException("Data não pode ser nula.");
            }
            if (hora == null || hora.trim().isEmpty()) {
                throw new EventoException.InvalidHoraException("Hora não pode ser nula ou vazia.");
            }
            if (localizacao == null) {
                throw new EventoException.InvalidLocalizacaoException("Localização não pode ser nula.");
            }
    
            this.id = id;
            this.nome = nome;
            this.descricao = descricao;
            this.data = data;
            this.hora = hora;
            this.localizacao = localizacao;
        } catch (EventoException.InvalidIdException | EventoException.InvalidNomeException | EventoException.InvalidDataException | EventoException.InvalidHoraException | EventoException.InvalidLocalizacaoException e) {
            System.out.println("Erro ao criar o evento: " + e.getMessage());
        }
    }
    

    public int getId() {
        return id;
    }

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

    public String getNome() {
        return nome;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

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

    public String getHora() {
        return hora;
    }

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

    public Local getLocalizacao() {
        return localizacao;
    }

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
