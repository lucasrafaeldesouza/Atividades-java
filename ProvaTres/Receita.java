import java.util.ArrayList;
import java.util.Objects;

public class Receita {

    int idreceita;
    String nome;
    String etapas;
    int numeroEtapas;
    String valor;
    ArrayList<Padaria> padarias = new ArrayList<>();
    ArrayList<Mercado> mercado = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();

    public Receita(int idreceita, String nome, String etapas, int numeroEtapas, String valor) {

        this.idreceita = idreceita;
        this.nome = nome;
        this.etapas = etapas;
        this.numeroEtapas = numeroEtapas;
        this.valor = valor;

    }

    public int getidReceita() {
        return this.idreceita;
    }

    public void setHorario(int idreceita) {
        this.idreceita = idreceita;
    }

    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEtapas() {
        return this.etapas;
    }

    public void setEtapas(String etapas) {
        this.etapas = etapas;
    }

    public int getNumeroEtapas() {
        return this.idreceita;
    }

    public void setNumeroEtapas(int numeroEtapas) {
        this.numeroEtapas = numeroEtapas;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setPadaria(Padaria padaria) {
        this.padarias.add(padaria);    
    }

    public ArrayList<Padaria> getPadaria() {
        return this.padarias;
    }

    public void setMercado(Mercado mercado) {
        this.mercado.add(mercado);    
    }

    public ArrayList<Mercado> getMercado() {
        return this.mercado;
    }

    public void setCliente(Cliente cliente) {
        this.clientes.add(cliente);    
    }
    public ArrayList<Cliente> getCliente() {
        return this.clientes;
    }


    /*
    public void adicionarPadaria(Padaria padaria) {
        this.padarias.add(padaria);
    }
    */

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Receita)) {
            return false;
        }
        Receita receita = (Receita) o;
        return Objects.equals(idreceita, receita.idreceita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idreceita);
    }

    @Override
    public String toString() {
        return "{" +
            " Receita ='" + getNome() + "'" +
            " Valor ='" + getValor() + "'" +
            "}";
    }
}