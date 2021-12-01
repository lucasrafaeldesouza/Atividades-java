import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ClienteBanco {
    public static void main(String[] args) {
    try{
        final String url = "jdbc:mysql://localhost:3306/BancoJava?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";
        Connection con = DriverManager.getConnection(url, user, password);

        Scanner scanner = new Scanner(System.in);
        int escolha= 0;
        int IdCliente = 0;
        String nome = "";
        String telefone = "";
        String cpf = "";
        Date dataDeNascimento = new Date(1990,1,1);
      
    do{
        System.out.println("\t=================");
        System.out.println("\t    MENU PADARIA CLIENTE ");
        System.out.println("\t=================");
        System.out.println(" [1] - INSERT - CLIENTE (Statement)");
        System.out.println(" [2] - UPDATE - CLIENTE (PreparedStatement)");
        System.out.println(" [3] - DELETE - CLIENTE (PreparedStatement)");
        System.out.println(" [4] - SELECT - CLIENTE (PreparedStatement)");
        System.out.println(" [5] - SAIR ");
        System.out.printf(" Sua escolha: ");
        escolha = scanner.nextInt();

            /* TODA INSERÇÃO, UPDATE, DELETE E SELECT DO CHEF */
            switch(escolha){
        case 1:

            System.out.println("\n\n - CRIAÇÃO DO CLIENTE:");
            System.out.printf("ID: ");
            try {
                IdCliente = scanner.nextInt();
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
            System.out.printf("TELEFONE: ");
            try {
                telefone = scanner.next();
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
                dataDeNascimento = Date.valueOf(scanner.next());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
         
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO cliente (IdCliente, nome, telefone, cpf, dataDeNascimento) VALUES ("+IdCliente+",'"+nome+"','"+telefone+"','"+cpf+"','"+dataDeNascimento+"')");
            System.out.println("CADASTRADO REALIZADO COM SUCESSSO!");
            break;

        case 2:

            System.out.println("\n\n - UPDATE DO CLIENTE");
            System.out.printf("ID: ");
            try {
                IdCliente = scanner.nextInt();
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
            System.out.printf("TELEFONE: ");
            try {
                telefone = scanner.next();
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
                dataDeNascimento = Date.valueOf(scanner.next());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            PreparedStatement preparedStatement2 = con.prepareStatement("UPDATE cliente SET nome = ?, telefone = ?, cpf = ?, dataDeNascimento = ? WHERE IdCliente = ?", 
            PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement2.setString(1,nome);
            preparedStatement2.setString(2,telefone);
            preparedStatement2.setString(3,cpf);
            preparedStatement2.setDate(4,dataDeNascimento);
            preparedStatement2.setInt(5,IdCliente);
            
            if(preparedStatement2.executeUpdate()<=0){
                System.out.println("Falha ao alterar o cliente");
            }
            break;

        case 3:

            System.out.println("\n\n - DELETAR O CLIENTE");
            System.out.println("");
            System.out.printf("ID: ");
            try {
                IdCliente = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            PreparedStatement preparedStatement3 = con.prepareStatement("DELETE FROM cliente WHERE IdCliente = ? ",
            PreparedStatement.RETURN_GENERATED_KEYS );
            preparedStatement3.setInt(1, IdCliente);

            if(preparedStatement3.executeUpdate()<=0){
                System.out.println("Falha ao deletar o Chef");
            }
            break;

                    
        case 4:

            System.out.println("\n\n - SELECIONAR CLIENTE:");
            System.out.printf("ID: ");
            try {
                IdCliente = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            PreparedStatement preparedStatement4 = con.prepareStatement("SELECT * FROM cliente WHERE IdCliente = ? ",
            PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement4.setInt(1,IdCliente);
            ResultSet result = preparedStatement4.executeQuery();
            while(result.next()){
                Cliente cliente = new Cliente(
                    result.getInt("IdCliente"),
                    result.getString("nome"),
                    result.getString("telefone"),
                    result.getString("cpf"),
                    result.getDate("dataDeNascimento")
                    );
            System.out.println(cliente);
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