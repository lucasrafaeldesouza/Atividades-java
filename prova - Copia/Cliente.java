import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Pessoa {

    private String telefone;
    ArrayList<Receita> receitas = new ArrayList<>();

    public Cliente(String nome, String cpf, String dataDeNascimento, String telefone) {
        super(nome, cpf, dataDeNascimento);
        this.telefone = telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void adicionarReceita(Receita receita) {
        this.receitas.add(receita);    
    }

    public void adicionarReceita(int idreceita, String nome, String etapas, int numeroEtapas, String valor) {
        Receita receita = new Receita(idreceita, nome, etapas, numeroEtapas,valor);
        this.receitas.add(receita);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(telefone, cliente.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefone);
    }

/*
 public Receita(int id, String nome, String etapas, int numeroEtapas) {

        this.id = id;
        this.nome = nome;
        this.etapas = etapas;
        this.numeroEtapas = numeroEtapas;

    }

*/

@Override
public String toString() {
    return "{" +
        " Nome = '" + getNome() + "'" +
        " CPF = '" + getCpf() + "'" +
        " Data de Nascimento = '" + getDataDeNascimento() + "'" +
        "}";
    }

}