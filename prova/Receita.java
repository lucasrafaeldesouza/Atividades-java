import java.util.ArrayList;

public class Receita {

    int id;
    String nome;
    String etapas;
    int numeroEtapas;
    ArrayList<Padaria> padarias = new ArrayList<>();

    // inicio do construtor
    public Receita(int id, String nome, String etapas, int numeroEtapas) {

        this.id = id;
        this.nome = nome;
        this.etapas = etapas;
        this.numeroEtapas = numeroEtapas;

    }
    // fim do construtor

    public void adicionarPadaria(Padaria padaria) {
        this.padarias.add(padaria);
    }
}