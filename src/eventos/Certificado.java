package eventos;

import java.time.LocalDateTime;

public class Certificado {
    private int id;
    private LocalDateTime dateTime;
    private boolean status;
    private String observacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        if (observacao != null) {
            this.observacao = observacao;
        }
    }
}
