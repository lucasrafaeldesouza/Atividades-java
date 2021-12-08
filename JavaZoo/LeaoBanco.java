
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LeaoBanco {
    private static int executeUpdate;

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

            do {
                System.out.println("\t=================");
                System.out.println("\t    JAVA - Zoológico ");
                System.out.println("\t=================");
                System.out.println(" [1] - INSERT - LEAO (Statement)");
                System.out.println(" [2] - UPDATE - LEAO (PreparedStatement)");
                System.out.println(" [3] - DELETE - LEAO (PreparedStatement)");
                System.out.println(" [4] - SELECT - LEAO (PreparedStatement)");
                System.out.println(" [5] - SAIR ");
                System.out.printf(" Sua escolha: ");
                escolha = scanner.nextInt();

                /* TODA INSERÇÃO, UPDATE, DELETE E SELECT DO LEAO */
                switch (escolha) {
                    case 1:

                        System.out.println("\n\n - CRIAÇÃO DO LEAO:");
                        System.out.printf("ID: ");
                        try {
                            id = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("=================\n");
                        System.out.printf("NOME: ");
                        try {
                            nome = scanner.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("=================\n");
                        System.out.printf("ALIMENTACAO: ");
                        try {
                            alimentacao = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("=================\n");
                        System.out.printf("VISITANTES: ");
                        try {
                            visitantes = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        Statement statement = con.createStatement();
                        executeUpdate = statement
                                .executeUpdate("INSERT INTO leao (id, nome, alimentacao, visitantes) VALUES ("
                                        + id + ",'" + nome + "','" + alimentacao + "','" + visitantes + "')");
                        System.out.println("CADASTRADO REALIZADO COM SUCESSSO!");
                        break;

                    case 2:

                        System.out.println("\n\n - UPDATE DO LEAO");
                        System.out.printf("ID: ");
                        try {
                            id = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("=================\n");
                        System.out.printf("NOME: ");
                        try {
                            nome = scanner.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("=================\n");
                        System.out.printf("ALIMENTACAO: ");
                        try {
                            alimentacao = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("=================\n");
                        System.out.printf("VISITANTES: ");
                        try {
                            visitantes = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        PreparedStatement preparedStatement2 = con.prepareStatement(
                                "UPDATE leao SET nome = ?, alimentacao = ?, visitantes = ? WHERE id = ?",
                                PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement2.setString(1, nome);
                        preparedStatement2.setInt(2, alimentacao);
                        preparedStatement2.setInt(3, visitantes);

                        if (preparedStatement2.executeUpdate() <= 0) {
                            System.out.println("Falha ao alterar o leao");
                        }
                        break;

                    case 3:

                        System.out.println("\n\n - DELETAR O LEAO");
                        System.out.println("");
                        System.out.printf("ID: ");
                        try {
                            id = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        PreparedStatement preparedStatement3 = con.prepareStatement(
                                "DELETE FROM leao WHERE id = ? ",
                                PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement3.setInt(1, id);

                        if (preparedStatement3.executeUpdate() <= 0) {
                            System.out.println("Falha ao deletar o leao");
                        }
                        break;

                    case 4:

                        System.out.println("\n\n - SELECIONAR LEAO:");
                        System.out.printf("ID: ");
                        try {
                            id = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        PreparedStatement preparedStatement4 = con.prepareStatement(
                                "SELECT * FROM leao WHERE id = ? ",
                                PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement4.setInt(1, id);
                        ResultSet result = preparedStatement4.executeQuery();
                        while (result.next()) {
                            Leao leao = new Leao(
                                    result.getInt("id"),
                                    result.getString("nome"),
                                    result.getInt("alimentacao"),
                                    result.getInt("visitantes"));
                            System.out.println(leao);
                        }
                        break;

                    case 5:
                        System.out.println("\n\n OBRIGADO POR USAR O PROGRAMA :) ");
                        break;
                }
            } while (escolha != 5);

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}