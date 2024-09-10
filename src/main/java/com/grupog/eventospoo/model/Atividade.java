package com.grupog.eventospoo.model;

import com.grupog.eventospoo.utils.exceptions.AtividadeException;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Atividade {
    private int id;
    private String titulo;
    private TipoAtividade tipo;
    private final LocalDate horario = LocalDate.now();
    private Autor autor;
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    private boolean concluido = false;
    private boolean cancelado = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        try {
            if (id <= 0) {
                throw new AtividadeException.InvalidIdException("ID inválido. O valor deve ser maior que zero.");
            }
            this.id = id;
        } catch (AtividadeException.InvalidIdException e) {
            System.out.println("Erro ao definir o ID da atividade: " + e.getMessage());
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new AtividadeException.InvalidTituloException("Título inválido. Não pode ser nulo ou vazio.");
            }
            this.titulo = titulo;
        } catch (AtividadeException.InvalidTituloException e) {
            System.out.println("Erro ao definir o título da atividade: " + e.getMessage());
        }
    }

    public TipoAtividade getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtividade tipo) {
        try {
            if (tipo == null) {
                throw new AtividadeException.InvalidTipoAtividadeException("Tipo de atividade inválido. Não pode ser nulo.");
            }
            this.tipo = tipo;
        } catch (AtividadeException.InvalidTipoAtividadeException e) {
            System.out.println("Erro ao definir o tipo da atividade: " + e.getMessage());
        }
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void adicionarAvaliacao(Avaliacao av) {
        try {
            if (av == null) {
                throw new AtividadeException.AvaliacaoInvalidaException("Avaliação inválida. Não pode ser nula.");
            }
            this.avaliacoes.add(av);
        } catch (AtividadeException.AvaliacaoInvalidaException e) {
            System.out.println("Erro ao adicionar a avaliação: " + e.getMessage());
        }
    }

    public void cancelarAtividade() {
        try {
            if (cancelado) {
                throw new AtividadeException.AtividadeJaCanceladaException("A atividade já foi cancelada.");
            }
            this.cancelado = true;
        } catch (AtividadeException.AtividadeJaCanceladaException e) {
            System.out.println("Erro ao cancelar a atividade: " + e.getMessage());
        }
    }

    public void concluirAtividade() {
        try {
            if (concluido) {
                throw new AtividadeException.AtividadeJaConcluidaException("A atividade já foi concluída.");
            }
            this.concluido = true;
        } catch (AtividadeException.AtividadeJaConcluidaException e) {
            System.out.println("Erro ao concluir a atividade: " + e.getMessage());
        }
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
