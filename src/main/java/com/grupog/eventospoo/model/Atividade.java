package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.AtividadeException;

import java.time.LocalDate;
import java.util.List;

public class Atividade {
    private int id;
    private String titulo;
    private TipoAtividade tipo;

    private final LocalDate horario = LocalDate.now();
    private Autor autor;
    private List<Avaliacao> avaliacoes;

    private boolean concluido = false;
    private boolean cancelado = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new AtividadeException.InvalidIdException("ID inválido. O valor deve ser maior que zero.");
        }
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            throw new AtividadeException.InvalidTituloException("Título inválido. Não pode ser nulo ou vazio.");
        }
        this.titulo = titulo;
    }

    public TipoAtividade getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtividade tipo) {
        if (tipo == null) {
            throw new AtividadeException.InvalidTipoAtividadeException("Tipo de atividade inválido. Não pode ser nulo.");
        }
        this.tipo = tipo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void adicionarAvaliacao(Avaliacao av) {
        if (av == null) {
            throw new AtividadeException.AvaliacaoInvalidaException("Avaliação inválida. Não pode ser nula.");
        }
        this.avaliacoes.add(av);
    }

    public void cancelarAtividade() {
        if (cancelado) {
            throw new AtividadeException.AtividadeJaCanceladaException("A atividade já foi cancelada.");
        }
        this.cancelado = true;
    }

    public void concluirAtividade() {
        if (concluido) {
            throw new AtividadeException.AtividadeJaConcluidaException("A atividade já foi concluída.");
        }
        this.concluido = true;
    }

    public LocalDate getHorario() {
        return horario;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public String getInformacoes() {
        return "Atividade{" +
                "titulo='" + titulo + '\'' +
                ", tipo=" + tipo +
                ", horario=" + horario +
                ", avaliacoes=" + avaliacoes +
                ", concluido=" + concluido +
                ", cancelado=" + cancelado +
                '}';
    }
}
