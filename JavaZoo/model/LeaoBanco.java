package model;

import java.sql.Connection;
/*import java.sql.Date;*/
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*import java.sql.Statement;*/
import java.util.Scanner;

public class LeaoBanco {
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
                System.out.println(" [5] - SAIR ");
                System.out.printf(" Sua escolha: ");
                escolha = scanner.nextInt();

                /* TODA INSERÇÃO, UPDATE, DELETE E SELECT DO LEAO */
                
                switch (escolha) {
                    case 1:

                        System.out.println("\n\n - CRIAÇÃO DO LEAO:");
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
                        System.out.println("=================\n");
                        System.out.printf("DESCRIÇÃO DA JAULA: ");
                        try {
                            descricao = scanner.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        
                        
                        PreparedStatement statement = con.prepareStatement(
                            "INSERT INTO leao (nome, alimentacao, visitantes, jaula_id) VALUES (?,?,?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS
                        );

                        PreparedStatement pStatement = con.prepareStatement(
                            "INSERT INTO jaula (descricao) VALUES (?);",
                            PreparedStatement.RETURN_GENERATED_KEYS
                        );
                        
                        /*
                        Statement statement = con.createStatement();
                        statement.executeUpdate("INSERT INTO leao (nome, alimentacao, visitantes, descricao) VALUES ('"+nome+"',"+alimentacao+","+visitantes+",'"+descricao+"'");
                        System.out.println("CADASTRADO REALIZADO COM SUCESSSO!");
                        break;
                        */

                        pStatement.setString(1, descricao);
                        if (pStatement.executeUpdate() > 0) {
                            ResultSet rs = pStatement.getGeneratedKeys();
                            rs.next();
                            int idJaula = rs.getInt(1);
                            
                            statement.setString(1, nome);
                            statement.setInt(2, alimentacao);
                            statement.setInt(3, visitantes);
                            statement.setInt(4, idJaula);

                            if (statement.executeUpdate() > 0) {
                                ResultSet rsLeao = statement.getGeneratedKeys();
                                rsLeao.next();
                                int idLeao = rs.getInt(1);

                                ResultSet sqlLeao = con.createStatement().executeQuery("SELECT * FROM leao WHERE id = " + idLeao);
                                sqlLeao.next();
                                System.out.println(
                                    new Leao(
                                        sqlLeao.getInt("id"),
                                        sqlLeao.getString("nome"),
                                        sqlLeao.getInt("alimentacao"),
                                        sqlLeao.getInt("visitantes"), idJaula, descricao));
                            }
                        }                        
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
                        preparedStatement2.setInt(4,id);

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

                        PreparedStatement preparedStatement4 = con.prepareStatement("SELECT * FROM leao WHERE id = ? ",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement4.setInt(1, id);
                        ResultSet result = preparedStatement4.executeQuery();
                        while (result.next()) {
                            Leao leao = new Leao(
                                    result.getInt("id"),
                                    result.getString("nome"),
                                    result.getInt("alimentacao"),
                                    result.getInt("visitantes"),
                                    result.getInt("jaula_id"), descricao);
                                    
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