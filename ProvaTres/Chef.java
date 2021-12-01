import java.util.ArrayList;
import java.util.Objects;
import java.sql.Date;

public class Chef extends Pessoa {

    private int IdChef;
    private String nome;
    private String cpf;
    private Date dataNasc;
    private String especialidade;
    private String salario;
    ArrayList<Receita> receitas = new ArrayList<>();
    

    public Chef(int IdChef, String nome, String cpf, Date dataNasc, String especialidade, String salario) {
        super(nome, cpf, dataNasc);
        this.IdChef = IdChef;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.especialidade = especialidade;
        this.salario = salario;
    }

    public void setId(int IdChef) {
        this.IdChef = IdChef;
    }

    public int getId() {
        return this.IdChef;
    }

    public void setSalario(String salario ) {
        this.salario = salario;
    }

    public String getSalario() {
        return this.salario;
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

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Date getDataNasc() {
        return this.dataNasc;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setReceita(Receita receitas) {
        this.receitas.add(receitas);
    }

    public void adicionarReceita(int idreceita, String nome, String etapas, int numeroEtapas, String valor) {
        Receita receita = new Receita(idreceita, nome, etapas, numeroEtapas, valor);
        this.receitas.add(receita);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Chef)) {
            return false;
        }
        Chef chef = (Chef) o;
        return Objects.equals(IdChef, chef.IdChef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdChef);
    }

    @Override
    public String toString() {
        return "{" + " Nome = '" + getNome() + "'" + " CPF = '" + getCpf() + "'" + " Data de Nascimento = '"
                + getDataDeNascimento() + "'" + "}";
    }
/*
    public String carteira() {
        return super.carteira() + "\nEspecialidade: " + this.getEspecialidade();
    }
*/
    public void adicionarReceita(Receita receitaUm) {
    }


    public String carteira() {
        
        return "\n Nome: " + this.getNome()
        + "\n cpf: " + this.getCpf()
        + "\n dataNasc: " + this.getDataNasc()
        + "\n salario: " + this.getSalario();
    } 

}