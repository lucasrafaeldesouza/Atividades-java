import java.util.ArrayList;

public class Chef {

    int id;
    String nome;
    String cpf;
    String dataNasc;
    ArrayList<Receita> receitas = new ArrayList<>();

    // início do construtor
    public Chef(int id, String nome, String cpf, String dataNasc) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }
    // fim do construtor

    public void adicionarReceita(Receita Receita) {
        this.receitas.add(Receita);
    }

    public void adicionarReceita(int idReceita, String nomeReceita, String etapas, int numeroEtapas) {
        // Adicionar receita(receita)
        Receita receita = new Receita(idReceita, nomeReceita, etapas, numeroEtapas);
        this.receitas.add(receita);
    }
}
