import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ChefBanco {
    public static void main(String[] args) {
    try{
        final String url = "jdbc:mysql://localhost:3306/BancoJava?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";
        Connection con = DriverManager.getConnection(url, user, password);

        Scanner scanner = new Scanner(System.in);
        int escolha= 0;
        int IdChef = 0;
        String nome = "";
        String cpf = "";
        String dataNasc = "";
        String especialidade = "";
        String salario = "";

    do{
        System.out.println("\t=================");
        System.out.println("\t    MENU PADARIA CHEF ");
        System.out.println("\t=================");
        System.out.println(" [1] - INSERT - CHEF (Statement)");
        System.out.println(" [2] - UPDATE - CHEF (PreparedStatement)");
        System.out.println(" [3] - DELETE - CHEF (PreparedStatement)");
        System.out.println(" [4] - SELECT - CHEF (PreparedStatement)");
        System.out.println(" [5] - SAIR ");
        System.out.printf(" Sua escolha: ");
        escolha = scanner.nextInt();

            /* TODA INSERÇÃO, UPDATE, DELETE E SELECT DO CHEF */
            switch(escolha){
        case 1:

            System.out.println("\n\n - CRIAÇÃO DO CHEF:");
            System.out.printf("ID: ");
            try {
                IdChef = scanner.nextInt();
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
            System.out.printf("CPF: ");
            try {
                cpf = scanner.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("=================\n");
            System.out.printf("DATA DE NASCIMENTO: ");
            try {
                dataNasc = scanner.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            System.out.println("=================\n");
            System.out.printf("ESPECIALIDADE: ");
            try {
                especialidade = scanner.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("=================\n");
            System.out.printf("SALARIO: ");
            try {
                salario = scanner.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            Statement statement = con.createStatement();
            // INSERT INTO chef (id, nome, cpf, dataNasc, especialidade, salario) VALUES (1, 'Lucas')
            statement.executeUpdate("INSERT INTO chef (IdChef, nome, cpf, dataNasc, especialidade,salario) VALUES ("+IdChef+",'"+nome+"','"+cpf+"','"+dataNasc+"','"+especialidade+"',"+salario+")");
            System.out.println("CADASTRADO REALIZADO COM SUCESSSO!");
            break;

        case 2:

            System.out.println("\n\n - UPDATE DO CHEF");
            System.out.printf("ID: ");
            try {
                IdChef = scanner.nextInt();
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
            System.out.printf("CPF: ");
            try {
                cpf = scanner.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("=================\n");
            System.out.printf("DATA DE NASCIMENTO: ");
            try {
                dataNasc = scanner.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("=================\n");
            System.out.printf("ESPECIALIDADE: ");
            try {
                especialidade = scanner.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("=================\n");
            System.out.printf("SALARIO: ");
            try {
                salario = scanner.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            PreparedStatement preparedStatement2 = con.prepareStatement("UPDATE chef SET nome = ?, cpf = ?, dataNasc = ?, especialidade = ?, salario = ? WHERE IdChef = ?", 
            PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement2.setString(1,nome);
            preparedStatement2.setString(2,cpf);
            preparedStatement2.setDate(3,Date.valueOf(dataNasc));
            preparedStatement2.setString(4,especialidade);
            preparedStatement2.setString(5,salario);
            preparedStatement2.setInt(6,IdChef);
            
            if(preparedStatement2.executeUpdate()<=0){
                System.out.println("Falha ao alterar o chef");
            }
            break;

        case 3:

            System.out.println("\n\n - DELETAR O CHEF");
            System.out.println("");
            System.out.printf("ID: ");
            try {
                IdChef = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            PreparedStatement preparedStatement3 = con.prepareStatement("DELETE FROM chef WHERE IdChef = ? ",
            PreparedStatement.RETURN_GENERATED_KEYS );
            preparedStatement3.setInt(1, IdChef);

            if(preparedStatement3.executeUpdate()<=0){
                System.out.println("Falha ao deletar o Chef");
            }
            break;

                    
        case 4:

            System.out.println("\n\n - SELECIONAR CHEF");
            System.out.printf("ID: ");
            try {
                IdChef = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            PreparedStatement preparedStatement4 = con.prepareStatement("SELECT * FROM chef WHERE IdChef = ? ",
            PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement4.setInt(1,IdChef);
            ResultSet result = preparedStatement4.executeQuery();
            while(result.next()){
                Chef chef = new Chef(
                    result.getInt("IdChef"),
                    result.getString("nome"),
                    result.getString("cpf"),
                    result.getDate("dataNasc"),
                    result.getString("especialidade"),
                    result.getString("salario")
                    );
            System.out.println(chef);
            }
            break;
        
            case 5:
                System.out.println("\n\n OBRIGADO POR USAR O PROGRAMA :) ");
                break;
            }
        } while(escolha != 5);
                
        con.close();
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}