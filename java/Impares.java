public class Impares {

    public static void main(String[] args) {
        int soma = 0;

        for (int cont = 1; cont <= 500; cont += 2) {
            if (cont % 2 == 1 && cont % 7 == 0) {
                soma += cont;
            }
        }

        System.out.println("A soma dos números ímpares múltiplos de 7 é: " + soma);
    }
}