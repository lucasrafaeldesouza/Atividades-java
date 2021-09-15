import java.util.Scanner;

public class Tabuada {
    public static void main(String args[]) {
        int valor;
        Scanner tabuada = new Scanner(System.in);

        System.out.println("Digite o valor da tabuada:");
        valor = tabuada.nextInt();

        for (int i = 0; i < 11; i++) {
            System.out.println(valor + " X " + i + " = " + (valor * i));
        }
    }
}