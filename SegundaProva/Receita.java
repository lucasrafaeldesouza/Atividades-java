import java.util.ArrayList;

public class Receita {

    int id;
    String nome;
    String etapas;
    int numeroEtapas;
    ArrayList<Padaria> padarias = new ArrayList<>();

    public Receita(int id, String nome, String etapas, int numeroEtapas) {

        this.id = id;
        this.nome = nome;
        this.etapas = etapas;
        this.numeroEtapas = numeroEtapas;

    }

    public void adicionarPadaria(Padaria padaria) {
        this.padarias.add(padaria);

    }
}
