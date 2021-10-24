import java.util.ArrayList;

public class Padaria {

    int id;
    String nome;
    String dataAbertura;
    Endereco endereco;
    ArrayList<Receita> receitas = new ArrayList<>();

    // inicio do construtor
    public Padaria(int id, String nome, String dataAbertura, int IdEndereco, String cep, String rua, int numero,
            String bairro, String cidade)

    {
        this.id = id;
        this.nome = nome;
        this.dataAbertura = dataAbertura;
        this.endereco = new Endereco(IdEndereco, cep, rua, numero, bairro, cidade, this);

    }
    // fim do construtor

    public void adicionarReceita(Receita receita) {
        this.receitas.add(receita);
        receita.adicionarPadaria(this);
    }

}