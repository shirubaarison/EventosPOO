package eventos.pessoas;

import java.util.List;

public abstract class Usuario {
    private String nome;
    private String cpf;
    private String instituicao;
    private String email;
    private List<String> eventosInscritos;

    Usuario(String nome, String cpf, String instituicao, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.instituicao = instituicao;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getEventosInscritos() {
        return eventosInscritos;
    }

    public void inscreverNoEvento(String evento) {
        this.eventosInscritos.add(evento);
    }

    public void cancelarInscricao(String evento) {
        this.eventosInscritos.remove(evento);
    }
}
