package com.grupog.eventospoo.model;

import com.grupog.eventospoo.exceptions.AtividadeException;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/**
 * Representa uma atividade em um sistema de eventos.
 * A atividade possui um identificador, um título, um tipo, um horário, um autor,
 * avaliações, e um status de conclusão e cancelamento.
 */
public class Atividade {
    private int id;
    private String titulo;
    private TipoAtividade tipo;
    private final LocalDate horario = LocalDate.now(); // Data de criação da atividade
    private Autor autor;
    private final List<Avaliacao> avaliacoes = new ArrayList<>();
    private boolean concluido = false;
    private boolean cancelado = false;

    /**
     * Construtor que cria uma atividade com título, tipo e autor.
     *
     * @param titulo O título da atividade
     * @param tipo O tipo da atividade
     * @param autor O autor responsável pela atividade
     */
    public Atividade(String titulo, TipoAtividade tipo, Autor autor) {
        setTitulo(titulo);
        setTipo(tipo);
        setAutor(autor);
    }

    /**
     * Construtor padrão vazio.
     */
    public Atividade() {

    }

    /**
     * Construtor alternativo com título e horário.
     * Este pode ser usado quando o horário da atividade é passado como string (para simplificação).
     *
     * @param titulo O título da atividade
     * @param horarioString A hora no formato String
     */
    public Atividade(String titulo, String horarioString) {
        setTitulo(titulo);
        // Como o horário já está definido como LocalDate.now(), não é necessário setá-lo diretamente aqui.
        // O horário string pode ser usado para outras finalidades, como exibição.
    }

    /**
     * Retorna o identificador da atividade.
     *
     * @return ID da atividade
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da atividade.
     * O ID deve ser maior que zero.
     *
     * @param id Identificador da atividade
     */
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

    /**
     * Retorna o título da atividade.
     *
     * @return Título da atividade
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título da atividade.
     * O título não pode ser nulo ou vazio.
     *
     * @param titulo Título da atividade
     */
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

    /**
     * Retorna o tipo da atividade.
     *
     * @return Tipo da atividade
     */
    public TipoAtividade getTipo() {
        return tipo;
    }

    /**
     * Define o tipo da atividade.
     * O tipo não pode ser nulo.
     *
     * @param tipo Tipo da atividade
     */
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

    /**
     * Retorna o autor da atividade.
     *
     * @return Autor da atividade
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * Define o autor da atividade.
     *
     * @param autor Autor da atividade
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * Adiciona uma avaliação à lista de avaliações da atividade.
     * A avaliação não pode ser nula.
     *
     * @param av Avaliação a ser adicionada
     */
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

    /**
     * Marca a atividade como cancelada.
     * Lança uma exceção se a atividade já estiver cancelada.
     */
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

    /**
     * Marca a atividade como concluída.
     * Lança uma exceção se a atividade já estiver concluída.
     */
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

    /**
     * Retorna o horário de criação da atividade.
     *
     * @return Data de criação da atividade
     */
    public LocalDate getHorario() {
        return horario;
    }

    /**
     * Retorna a lista de avaliações da atividade.
     *
     * @return Lista de avaliações
     */
    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    /**
     * Retorna uma representação textual da atividade.
     *
     * @return Informações sobre a atividade
     */
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
