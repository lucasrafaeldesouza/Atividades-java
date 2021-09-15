import java.util.Scanner;

public class Media_2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a 1° nota:");
        int nota1 = scanner.nextInt();

        System.out.println("Digite a 2° nota:");
        int nota2 = scanner.nextInt();

        System.out.println("Digite a 3° nota:");
        int nota3 = scanner.nextInt();

        int media = (nota1 + nota2 + nota3) / 3;

        System.out.println("A média das notas é =  " + media);

        if (media >= 7) {
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado");
        }
        scanner.close();
    }
}