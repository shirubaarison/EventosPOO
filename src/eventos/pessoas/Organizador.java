package eventos.pessoas;

import eventos.atividades.Atividade;

public class Organizador extends Usuario {
    Organizador(String nome, String cpf, String instituicao, String email) {
        super(nome, cpf, instituicao, email);
    }

    public void concluirAtividade(Atividade atividade) {
        atividade.concluirAtividade();
    }

    public void cancelarAtividade(Atividade atividade) {
        atividade.cancelarAtividade();
    }
}
