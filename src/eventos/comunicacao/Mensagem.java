package eventos.comunicacao;

import eventos.pessoas.Organizador;

public class Mensagem {
    private String texto;
    private final Organizador remetente;
    private final String horario;
    private Status status;

    Mensagem(String texto, Organizador remetente, String horario, Status status) {
        this.texto = texto;
        this.remetente = remetente;
        this.horario = horario;
        this.status = status;
    }

    public void alterarStatus(Status status) {
        if (status != null) this.status = status;
    }

    public void alterarMensagem(String novaMensagem) {
        if (!novaMensagem.isEmpty()) {
            this.texto = novaMensagem;
        } else {
            throw new ExceptionInInitializerError("Mensagem não existe");
        }
    }

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