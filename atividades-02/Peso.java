import java.util.Scanner;

public class Peso {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a sua altura :");
        double altura = scanner.nextDouble();

        System.out.println("Digite o seu peso: ");
        double peso = scanner.nextDouble();
        double imc;
        imc = peso / (altura * altura);

        System.out.println("Seu Imc é: " + imc);
        // System.out.println("Sua classificação no IMC é = " + media);

        if (imc < 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imc >= 18.6 && imc <= 24.9) {
            System.out.println("Peso Ideal");
        } else if (imc >= 25.0 && imc <= 29.9) {
            System.out.println("Levemente acima do peso");
        } else if (imc >= 30.0 && imc <= 34.9) {
            System.out.println("Obesidade Grau I");
        } else if (imc >= 35.0 && imc <= 39.9) {
            System.out.println("Obesidade Grau II");
        } else if (imc > 40.0) {
            System.out.println("Obesidade Grau III");
        }
        scanner.close();
    }
}