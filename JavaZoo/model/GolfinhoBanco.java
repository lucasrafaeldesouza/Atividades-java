package model;

import java.sql.Connection;
/*import java.sql.Date;*/
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*import java.sql.Statement;*/
import java.util.Scanner;

public class GolfinhoBanco {
    /*private static int executeUpdate;*/

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
            int treinamento = 0;
            String descricao = "";

            do {
                System.out.println("\t=================");
                System.out.println("\t    GOLFINHO - JAVA ZOO ");
                System.out.println("\t=================");
                System.out.println(" [1] - INSERT - GOLFINHO (PreparedStatement)");
                System.out.println(" [2] - UPDATE - GOLFINHO (PreparedStatement)");
                System.out.println(" [3] - DELETE - GOLFINHO (PreparedStatement)");
                System.out.println(" [4] - SELECT - GOLFINHO (PreparedStatement)");
                System.out.println(" [5] - SAIR ");
                System.out.printf(" Sua escolha: ");
                escolha = scanner.nextInt();

                /* TODA INSERÇÃO, UPDATE, DELETE E SELECT DO GOLFINHO */
                
                switch (escolha) {
                    case 1:

                        System.out.println("\n\n - CRIAÇÃO DO GOLFINHO:");
                        System.out.println("=================\n");
                        System.out.printf("NOME: ");
                        try {
                            nome = scanner.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("=================\n");
                        System.out.printf("TREINAMENTO: ");
                        try {
                            treinamento = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("=================\n");
                        System.out.printf("DESCRIÇÃO DA JAULA: ");
                        try {
                            descricao = scanner.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        
                        
                        PreparedStatement statement = con.prepareStatement(
                            "INSERT INTO golfinho (nome, treinamento, jaula_id) VALUES (?,?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS
                        );

                        PreparedStatement pStatement = con.prepareStatement(
                            "INSERT INTO jaula (descricao) VALUES (?);",
                            PreparedStatement.RETURN_GENERATED_KEYS
                        );
                        
                        /*
                        Statement statement = con.createStatement();
                        statement.executeUpdate("INSERT INTO golfinho (nome, alimentacao, visitantes, descricao) VALUES ('"+nome+"',"+treinamento+","+visitantes+",'"+descricao+"'");
                        System.out.println("CADASTRADO REALIZADO COM SUCESSSO!");
                        break;
                        */

                        pStatement.setString(1, descricao);
                        if (pStatement.executeUpdate() > 0) {
                            ResultSet rs = pStatement.getGeneratedKeys();
                            rs.next();
                            int idJaula = rs.getInt(1);
                            
                            statement.setString(1, nome);
                            statement.setInt(2, treinamento);
                            statement.setInt(3, idJaula);

                            if (statement.executeUpdate() > 0) {
                                ResultSet rsGolfinho = statement.getGeneratedKeys();
                                rsGolfinho.next();
                                int idGolfinho = rs.getInt(1);

                                ResultSet sqlGolfinho = con.createStatement().executeQuery("SELECT * FROM golfinho WHERE id = " + idGolfinho);
                                sqlGolfinho.next();
                                System.out.println(
                                    new Golfinho(
                                        sqlGolfinho.getInt("id"),
                                        sqlGolfinho.getString("nome"),
                                        sqlGolfinho.getInt("treinamento"),idJaula, descricao));
                            }
                        }                        
                        System.out.println("CADASTRADO REALIZADO COM SUCESSSO!");
                        break;
                        

                    case 2:

                        System.out.println("\n\n - UPDATE DO GOLFINHO");
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
                        System.out.printf("TREINAMENTO: ");
                        try {
                            treinamento = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
        
                        PreparedStatement preparedStatement2 = con.prepareStatement(
                        "UPDATE golfinho SET nome = ?, treinamento = ? WHERE id = ?",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement2.setString(1, nome);
                        preparedStatement2.setInt(2, treinamento);
                        preparedStatement2.setInt(3,id);

                        if (preparedStatement2.executeUpdate() <= 0) {
                            System.out.println("Falha ao alterar o golfinho");
                        }
                        break;

                    case 3:

                        System.out.println("\n\n - DELETAR O GOLFINHO");
                        System.out.println("");
                        System.out.printf("ID: ");
                        try {
                            id = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        PreparedStatement preparedStatement3 = con.prepareStatement(
                                "DELETE FROM golfinho WHERE id = ? ",
                                PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement3.setInt(1, id);

                        if (preparedStatement3.executeUpdate() <= 0) {
                            System.out.println("Falha ao deletar o leao");
                        }
                        break;

                    case 4:

                        System.out.println("\n\n - SELECIONAR GOLFINHO:");
                        System.out.printf("ID: ");
                        try {
                            id = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        PreparedStatement preparedStatement4 = con.prepareStatement("SELECT * FROM golfinho WHERE id = ? ",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement4.setInt(1, id);
                        ResultSet result = preparedStatement4.executeQuery();
                        while (result.next()) {
                            Golfinho golfinho = new Golfinho(
                                    result.getInt("id"),
                                    result.getString("nome"),
                                    result.getInt("treinamento"),
                                    result.getInt("jaula_id"), descricao);
                                    
                            System.out.println(golfinho);
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