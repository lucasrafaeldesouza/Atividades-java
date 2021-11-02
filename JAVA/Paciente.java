package JAVA;

public class Paciente extends Pessoa {
    private String carteira;

    public Paciente(String registro) {
        super(nome, cpf, dataNascimento, carteira);
        this.carteira = carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getCarteira() {
        return this.carteira;
    }

    @Override
    public String toString() {
        return "\n\t Médico " + "\n\n Crm = " + this.getCrm() + "\n Estado = " + "\n Carteira = ";
    }
}