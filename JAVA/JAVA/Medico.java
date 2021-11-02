package JAVA;

public class Medico extends Pessoa {
    private String carteira;

    public Medico(Double crm, String estado, String carteira) {
        super(crm, estado, carteira);
        this.carteira = carteira;
    }

    public void setCrm(String carteira) {
        this.carteira = carteira;
    }

    public String getCrm() {
        return this.carteira;
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