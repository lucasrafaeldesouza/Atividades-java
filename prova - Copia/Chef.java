import java.util.ArrayList;
import java.util.Objects;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getDataNasc() {
        return this.dataNasc;
    }

    public void setReceita(Receita receitas) {
        this.receitas.add(receitas);
    }

    public ArrayList<Receita> getReceita() {
        return this.receitas;
    }

}