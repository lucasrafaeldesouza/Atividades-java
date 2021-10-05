import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AtividadeAvaliativa {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Atividade Avaliativa Java");

        try {
            // Criar um buffer que irá ler a qualidade que está no arquivo TXT que está na
            // pasta Prova_Java
            BufferedReader leitura = new BufferedReader(new FileReader("./desordenada.txt"));
            String value = "";
            int cont = 0;
            // Estrutura de repetição que contara no numero mais baixo até o numero mais
            // alto
            while ((value = leitura.readLine()) != null) {
                cont++;
            }
            leitura.close();

            int[] array = new int[cont];
            cont = 0;

            // ler o que está no buffer
            leitura = new BufferedReader(new FileReader("./desordenada.txt"));
            value = "";

            while ((value = leitura.readLine()) != null) {
                // Guarda os valores no posição (indice)
                int num = Integer.parseInt(value);
                array[cont] = num;
                cont++;
            }
            leitura.close();

            // Colocar o que está no arquivo em Txt na pasta Prova_Java no arquivo
            // PrimeiraAvaliacao.java
            /*
             * for (int i : array) { System.out.println(i); }
             */

            // numeros que estão desordenados e precisam ser ordenados na pasta ordenada.txt
            // int desordenada[] = { 2, 4, 3, 8, 10, 6, 9, 11, 13, 1 };//
            // int ordenada[] = { 1, 2, 3, 4, 6, 8, 9, 10, 11, 13};//

        } catch (IOException exception) {
            System.out.println("Erro de exceção I/O: " + exception.getMessage());
        }
        scanner.close();
    }
}
