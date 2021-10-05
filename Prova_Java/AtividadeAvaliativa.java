import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
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
            // Estrutura de repetição que contara do numero menor numero até o maior
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

            /*
             * for (int i : array) { System.out.println(i); }
             */

            // numeros que estão desordenados e precisam ser ordenados na pasta ordenada.txt
            // int desordenada[] = { 2, 4, 3, 8, 10, 6, 9, 11, 13, 1 };//
            // int ordenada[] = { 1, 2, 3, 4, 6, 8, 9, 10, 11, 13};//
            System.out.println("Numeros ordenados");

            for (int i = 0; i < array.length; i++) {
                int menor = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] < array[menor]) {
                        menor = j;
                    }
                }
                int contador = array[menor];
                array[menor] = array[i];
                array[i] = contador;
            }

            // Leitura dos numeros desordenados na collection
            leitura = new BufferedReader(new FileReader("./desordenada.txt"));
            SortedSet<Integer> valores = new TreeSet<>();
            String temp = "";
            while ((temp = leitura.readLine()) != null) {
                int numero = Integer.parseInt(temp);
                valores.add(numero);
            }
            leitura.close();
            System.out.println(valores);

            // todos os numeros dentro da collection agora estão ordenados no arquivo
            BufferedWriter escrita = new BufferedWriter(new FileWriter("./ordenada.txt"));

            for (int i = 0; i < array.length; i++) {
                escrita.append(array[i] + "\n");
            }
            escrita.close();
        } catch (IOException exception) {
            System.out.println("Não foi localizado o arquivo.");
        }
    }
}