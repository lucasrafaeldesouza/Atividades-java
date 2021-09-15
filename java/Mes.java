import java.util.Scanner;

public class Mes {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero:");
        int num = scanner.nextInt();

        // System.out.println("A média das notas é = " + media);

        if (num == 1) {
            System.out.println("janeiro");
        }
        if (num == 2) {
            System.out.println("feveiro");
        }
        if (num == 3) {
            System.out.println("marco");
        }
        if (num == 4) {
            System.out.println("abril");
        }
        if (num == 5) {
            System.out.println("maio");
        }
        if (num == 6) {
            System.out.println("junho");
        }
        if (num == 7) {
            System.out.println("julho");
        }
        if (num == 8) {
            System.out.println("agosto");
        }
        if (num == 9) {
            System.out.println("setembro");
        }
        if (num == 10) {
            System.out.println("outubro");
        }
        if (num == 11) {
            System.out.println("novembro");
        }
        if (num == 12) {
            System.out.println("dezembro");
        }
        scanner.close();
    }
}
