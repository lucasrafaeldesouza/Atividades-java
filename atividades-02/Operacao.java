import java.util.Scanner;

public class operacao {
    public static void main(String args[]) {
        int valorUm = 0, valorDois = 0;
        double resultado = 0.0;
        String operacao = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o primeiro valor: ");
        valorUm = scanner.nextInt();

        System.out.println("Informe o segundo valor: ");
        valorDois = scanner.nextInt();

        System.out.println("Informe a operação a ser realizada (+ - * /): ");
        operacao = scanner.next();

        if (operacao.equals("+")) {
            resultado = valorUm + valorDois;
        } else if (operacao.equals("-")) {
            resultado = valorUm - valorDois;
        } else if (operacao.equals("*")) {
            resultado = valorUm * valorDois;
        } else {
            resultado = valorUm / valorDois;
        }
        System.out.println("O resultado é: " + resultado);
        scanner.close();
    }
}
