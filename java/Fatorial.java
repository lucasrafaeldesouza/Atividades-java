import java.util.Scanner;

public class Fatorial {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n, fat = 1;

        System.out.println("---- FATORIAL ---- ");
        System.out.println("Informe um número para calcular o fatorial: ");
        n = input.nextInt();

        if (n >= 0) {
            for (int i = 1; i <= n; i++) {
                fat = fat * i;
            }
            System.out.println("O fatorial é: " + fat);
        } else {
            System.out.println("Informe numeros a partir de zero!");
        }
    }
}