import java.util.Objects;

public class Endereco {

    private int idEndereco;
    private int cep;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private Padaria Padaria;
    protected Estabelecimento estabelecimento;

    public Endereco(int idEndereco, int cep, String rua, int numero, String bairro, String cidade, Estabelecimento estabelecimento) {

        this.idEndereco = idEndereco;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.Padaria = Padaria;
    }


    public int getIdEndereco() {
        return this.idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getCep() {
        return this.cep;
    }

    public void setCpf(int cep) {
        this.cep = cep;
    }   

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }  

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    } 
    
    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }  

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }  

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Endereco)) {
            return false;
        }
        Endereco endereco = (Endereco) o;
        return Objects.equals(idEndereco, endereco.idEndereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEndereco);
    }

    @Override
    public String toString() {
        return "\n" +
            "ID Endereço = '" + getIdEndereco() + "'" +
            "\nCEP = '" + getCep() + "'" +
            "\nRua = '" + getRua() + "'" +
            "\nNúmero = '" + getNumero() + "'" +
            "\nBairro = '" + getBairro() + "'" +
            "\nCidade = '" + getCidade() + "'" +
            "";
    }
}