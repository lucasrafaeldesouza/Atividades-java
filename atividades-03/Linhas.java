import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Linhas {
    public static void main(String[] args) {

        try {
            BufferedReader leitura = new BufferedReader(new FileReader("./texto.txt"));
            String value = "";
            while (true) {
                if (value != null)
                    System.out.println(value);
                else
                    break;

                value = leitura.readLine();
            }
            leitura.close();
        } catch (IOException exception) {
            System.out.println("Erro de exceção I/O: " + exception.getMessage());
        }
    }
}