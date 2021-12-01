import java.util.ArrayList;
import java.util.Objects;
import java.sql.Date;

public class Cliente extends Pessoa {

    private int IdCliente;
    private String telefone;
    ArrayList<Receita> receitas = new ArrayList<>();

    public Cliente(int IdCliente,String nome, String telefone,String cpf, Date dataDeNascimento) {
        super(nome, cpf, dataDeNascimento);
        this.telefone = telefone;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdCliente() {
        return this.IdCliente;
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

    @Override
    public String toString() {
        return "{" +
            " Nome = '" + getNome() + "'" +
            " CPF = '" + getCpf() + "'" +
            " Data de Nascimento = '" + getDataDeNascimento() + "'" +
            "}";
        }
        /*
            public String carteira() {
                return super.carteira()
                    + "\nTelefone: " + this.getTelefone();
            }
        */

        public String carteira() {
            return "\nTelefone: " + this.getTelefone();
        }

}