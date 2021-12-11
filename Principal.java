import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import model.GolfinhoBanco;
import model.LeaoBanco;

public class Principal {
    public static void main(String[] args) {
        try {
            final String url = "jdbc:mysql://localhost:3306/javazoo?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";
            Connection con = DriverManager.getConnection(url, user, password);

            Scanner scanner = new Scanner(System.in);
            int escolha = 0;
            int id = 0;
            String nome = "";
            int alimentacao = 0;
            int visitantes = 0;
            String descricao = "";

            do {
                System.out.println("\t=================");
                System.out.println("\t    LEAO - JAVA ZOO ");
                System.out.println("\t=================");
                System.out.println(" [1] - INSERT - LEAO (PreparedStatement)");
                System.out.println(" [2] - UPDATE - LEAO (PreparedStatement)");
                System.out.println(" [3] - DELETE - LEAO (PreparedStatement)");
                System.out.println(" [4] - SELECT - LEAO (PreparedStatement)");
                System.out.println(" [5] - INSERT - LEAO (PreparedStatement)");
                System.out.println(" [6] - UPDATE - LEAO (PreparedStatement)");
                System.out.println(" [7] - DELETE - LEAO (PreparedStatement)");
                System.out.println(" [8] - SELECT - LEAO (PreparedStatement)");
                System.out.println(" [9] - SAIR ");
                System.out.printf(" Sua escolha: ");
                escolha = scanner.nextInt();

                /* TODA INSERÇÃO, UPDATE, DELETE E SELECT DO LEAO */
                
                switch (escolha) {
                    case 1:

                        LeaoBanco.inserirLeao(scanner, con);
                        break;

                    case 2:

                        LeaoBanco.alterarLeao(scanner, con);

                    case 3:
                        LeaoBanco.deletetarLeao(scanner, con);
                        
                        break;

                    case 4:
                        LeaoBanco.listarLeao(scanner, con);
                        
                        break;
                    case 5:

                        GolfinhoBanco.inserirGolfinho(scanner, con);
                        break;

                    case 6:

                        GolfinhoBanco.alterarGolfinho(scanner, con);

                    case 7:
                        GolfinhoBanco.deletetarGolfinho(scanner, con);
                        
                        break;

                    case 8:
                        GolfinhoBanco.listarGolfinho(scanner, con);
                        
                        break;

                    case 9:
                        System.out.println("\n\n OBRIGADO POR USAR O PROGRAMA :) ");
                        break;
                }
            } while (escolha != 9);

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
