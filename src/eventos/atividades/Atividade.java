package eventos.atividades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Atividade {
    String nome;
    TipoAtividade tipo;

    LocalDate horario = LocalDate.now();
    List<String> feedbacks = new ArrayList<>();

    boolean concluido = false;
    boolean cancelado = false;

    public void cancelarAtividade(){
        this.cancelado = true;
    };

    public void concluirAtividade(){
        this.concluido = true;
    };

    public LocalDate getHorario() {
        return horario;
    }

    public List<String> getFeedbacks() {
        return feedbacks;
    }


    public String getInformacoes() {
        return "Atividade{" +
                "nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", horario=" + horario +
                ", feedbacks=" + feedbacks +
                ", concluido=" + concluido +
                ", cancelado=" + cancelado +
                '}';
    }
}
