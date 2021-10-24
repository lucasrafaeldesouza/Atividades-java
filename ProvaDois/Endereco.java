public class Endereco {

    int id;
    int cep;
    String rua;
    int numero;
    String bairro;
    String cidade;
    Padaria Padaria;

    // inicio do construtor
    public Endereco(int id, int cep, String rua, int numero, String bairro, String cidade, Padaria Padaria) {

        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.Padaria = Padaria;
    }
    // fim do construtor

}
