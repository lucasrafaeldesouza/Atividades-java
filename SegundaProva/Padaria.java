import java.util.ArrayList;

public class Padaria {

    int id;
    String nome;
    String dataAbertura;
    Endereco Endereco;
    ArrayList<Receita> receitas = new ArrayList<>();

    public Padaria(int id, String nome, String dataAbertura, Endereco Endereco) {
        this.id = id;
        this.nome = nome;
        this.dataAbertura = dataAbertura;
        this.endereco = new Endereco(idEndereco, cep, rua, numero, bairro, cidade, this);
    }

    public void adicionarReceita(Receita receita) {
        this.receitas.add(receita);
        receita.adicionarReceita(this);
    }

}