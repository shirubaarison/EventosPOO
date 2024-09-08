package com.grupog.eventospoo.model;

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
        if (id > 0) {
            this.id = id;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null) {
            this.titulo = titulo;
        }
    }

    public TipoAtividade getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtividade tipo) {
        if (tipo != null) {
            this.tipo = tipo;
        }
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void adicionarAvaliacao(Avaliacao av) {
        if (av != null) {
            this.avaliacoes.add(av);
        }
    }

    public void cancelarAtividade(){
        this.cancelado = true;
    };

    public void concluirAtividade(){
        this.concluido = true;
    };

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
