package JAVA;

public class Consulta extends Pessoa {
    private String Registro;

    public Consulta(Double crm, String estado, String carteira) {
        super(crm, estado, carteira);
        this.registro = registro;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getCrm() {
        return this.Registro;
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