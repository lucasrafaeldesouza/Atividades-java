import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tabuada_03 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Digite o valor para calcular a tabuada: ");
            int valor = in.nextInt();
            in.close();

            if (valor < 0 || valor > 10) {
                throw new Exception("Valor inválido");
            }

            BufferedWriter buffer = new BufferedWriter(new FileWriter("./atividades-03.txt"));
            for (int cont = 0; cont <= 10; cont++) {
                buffer.append(cont + " x " + valor + " = " + (cont * valor) + "\n");
            }
            buffer.close();
        } catch (InputMismatchException e) {
            System.out.println("O valor digitado é inválido: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Os arquivos possuem inconsistência: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
