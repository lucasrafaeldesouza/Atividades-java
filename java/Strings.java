import java.util.Scanner;

public class Strings {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        {
            System.out.println("---- PROGRAMA DE STRING POR LINHA ---- ");

            System.out.println("Informe um número: ");
            int character = scanner.nextInt();
            int cont = 1;
            while (cont <= 10) {
                System.out.println(character);
                cont++;
            }
        }
        // Scanner.close();
    }
}