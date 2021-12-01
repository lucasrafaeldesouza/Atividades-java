import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SistemaPrincipal {
    public static void main(String[] args) {
        try {
            final String url = "jdbc:mysql://localhost:3306/BancoJava?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";
            Connection con = DriverManager.getConnection(url, user, password);

            Scanner scanner = new Scanner(System.in);

            int escolhaPadaria = 0;
            int escolhaCliente = 0;
            int escolhaChef = 0;
            int IdChef = 0;
            int IdCliente = 0;
            String nome = "";
            String cpf = "";
            String dataNasc = "";
            Date dataDeNascimento = new Date(1990, 1, 1);
            String especialidade = "";
            String salario = "";
            String telefone = "";

            do {
                System.out.println("\t=================");
                System.out.println("\t    MENU PADARIA  ");
                System.out.println("\t=================");
                System.out.println(" [1] - CHEF (Statement or PreparedStatement)");
                System.out.println(" [2] - CLIENTE (Statement or PreparedStatement)");
                System.out.println(" [3] - MENU SISTEMA");
                System.out.println(" [4] - SAIR ");
                System.out.printf(" Sua escolha: ");
                escolhaPadaria = scanner.nextInt();

                switch (escolhaPadaria) {

                    case 1:

                        do {
                            System.out.println("\t=================");
                            System.out.println("\t    MENU PADARIA CHEF ");
                            System.out.println("\t=================");
                            System.out.println(" [1] - INSERT - CHEF (Statement)");
                            System.out.println(" [2] - UPDATE - CHEF (PreparedStatement)");
                            System.out.println(" [3] - DELETE - CHEF (PreparedStatement)");
                            System.out.println(" [4] - SELECT - CHEF (PreparedStatement)");
                            System.out.println(" [5] - SAIR ");
                            System.out.printf(" Sua escolha: ");
                            escolhaChef = scanner.nextInt();

                            /* TODA INSERÇÃO, UPDATE, DELETE E SELECT DO CHEF */
                            switch (escolhaChef) {
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
                                    // INSERT INTO chef (id, nome, cpf, dataNasc, especialidade, salario) VALUES (1,
                                    // 'Lucas')
                                    statement.executeUpdate(
                                            "INSERT INTO chef (IdChef, nome, cpf, dataNasc, especialidade,salario) VALUES ("
                                                    + IdChef + ",'" + nome + "','" + cpf + "','" + dataNasc + "','"
                                                    + especialidade + "'," + salario + ")");
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
                                    PreparedStatement preparedStatement2 = con.prepareStatement(
                                            "UPDATE chef SET nome = ?, cpf = ?, dataNasc = ?, especialidade = ?, salario = ? WHERE IdChef = ?",
                                            PreparedStatement.RETURN_GENERATED_KEYS);
                                    preparedStatement2.setString(1, nome);
                                    preparedStatement2.setString(2, cpf);
                                    preparedStatement2.setDate(3, Date.valueOf(dataNasc));
                                    preparedStatement2.setString(4, especialidade);
                                    preparedStatement2.setString(5, salario);
                                    preparedStatement2.setInt(6, IdChef);

                                    if (preparedStatement2.executeUpdate() <= 0) {
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
                                    PreparedStatement preparedStatement3 = con.prepareStatement(
                                            "DELETE FROM chef WHERE IdChef = ? ",
                                            PreparedStatement.RETURN_GENERATED_KEYS);
                                    preparedStatement3.setInt(1, IdChef);

                                    if (preparedStatement3.executeUpdate() <= 0) {
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

                                    PreparedStatement preparedStatement4 = con.prepareStatement(
                                            "SELECT * FROM chef WHERE IdChef = ? ",
                                            PreparedStatement.RETURN_GENERATED_KEYS);
                                    preparedStatement4.setInt(1, IdChef);
                                    ResultSet result = preparedStatement4.executeQuery();
                                    while (result.next()) {
                                        Chef chef = new Chef(
                                                result.getInt("IdChef"),
                                                result.getString("nome"),
                                                result.getString("cpf"),
                                                result.getDate("dataNasc"),
                                                result.getString("especialidade"),
                                                result.getString("salario"));
                                        System.out.println(chef);
                                    }
                                    break;

                                case 5:
                                    System.out.println("\n\n BYE BYE ");
                                    break;
                            }
                        } while (escolhaChef != 5);

                        con.close();

                        break;

                    case 2:

                        do {
                            System.out.println("\t=================");
                            System.out.println("\t    MENU PADARIA CLIENTE ");
                            System.out.println("\t=================");
                            System.out.println(" [1] - INSERT - CLIENTE (Statement)");
                            System.out.println(" [2] - UPDATE - CLIENTE (PreparedStatement)");
                            System.out.println(" [3] - DELETE - CLIENTE (PreparedStatement)");
                            System.out.println(" [4] - SELECT - CLIENTE (PreparedStatement)");
                            System.out.println(" [5] - SAIR ");
                            System.out.printf(" Sua escolha: ");
                            escolhaCliente = scanner.nextInt();

                            /* TODA INSERÇÃO, UPDATE, DELETE E SELECT DO CLIENTE */
                            switch (escolhaCliente) {
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
                                    statement.executeUpdate(
                                            "INSERT INTO cliente (IdCliente, nome, telefone, cpf, dataDeNascimento) VALUES ("
                                                    + IdCliente + ",'" + nome + "','" + telefone + "','" + cpf + "','"
                                                    + dataDeNascimento + "')");
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
                                    PreparedStatement preparedStatement2 = con.prepareStatement(
                                            "UPDATE cliente SET nome = ?, telefone = ?, cpf = ?, dataDeNascimento = ? WHERE IdCliente = ?",
                                            PreparedStatement.RETURN_GENERATED_KEYS);
                                    preparedStatement2.setString(1, nome);
                                    preparedStatement2.setString(2, telefone);
                                    preparedStatement2.setString(3, cpf);
                                    preparedStatement2.setDate(4, dataDeNascimento);
                                    preparedStatement2.setInt(5, IdCliente);

                                    if (preparedStatement2.executeUpdate() <= 0) {
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
                                    PreparedStatement preparedStatement3 = con.prepareStatement(
                                            "DELETE FROM cliente WHERE IdCliente = ? ",
                                            PreparedStatement.RETURN_GENERATED_KEYS);
                                    preparedStatement3.setInt(1, IdCliente);

                                    if (preparedStatement3.executeUpdate() <= 0) {
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

                                    PreparedStatement preparedStatement4 = con.prepareStatement(
                                            "SELECT * FROM cliente WHERE IdCliente = ? ",
                                            PreparedStatement.RETURN_GENERATED_KEYS);
                                    preparedStatement4.setInt(1, IdCliente);
                                    ResultSet result = preparedStatement4.executeQuery();
                                    while (result.next()) {
                                        Cliente cliente = new Cliente(
                                                result.getInt("IdCliente"),
                                                result.getString("nome"),
                                                result.getString("telefone"),
                                                result.getString("cpf"),
                                                result.getDate("dataDeNascimento"));
                                        System.out.println(cliente);
                                    }
                                    break;

                                case 5:
                                    System.out.println("\n\n fim do programa ");
                                    break;
                            }
                        } while (escolhaCliente != 5);

                        con.close();

                        break;

                    case 3:

                        Connection conct = DriverManager.getConnection(url, user, password);

                        PreparedStatement preparedStatement4 = conct.prepareStatement("SELECT * FROM cliente");
                        ResultSet result = preparedStatement4.executeQuery();
                        while (result.next()) {
                            System.out.printf(" - Cliente ");
                            Cliente cliente = new Cliente(
                                    result.getInt("IdCliente"),
                                    result.getString("nome"),
                                    result.getString("telefone"),
                                    result.getString("cpf"),
                                    result.getDate("dataDeNascimento"));
                            System.out.println(cliente);
                        }
                        System.out.printf(" \n");

                        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM chef");
                        ResultSet re = preparedStatement.executeQuery();
                        while (re.next()) {
                            System.out.printf(" - Chef ");
                            Chef chef = new Chef(
                                    re.getInt("IdChef"),
                                    re.getString("nome"),
                                    re.getString("cpf"),
                                    re.getDate("dataNasc"),
                                    re.getString("especialidade"),
                                    re.getString("salario"));
                            System.out.println(chef);
                        }

                        System.out.printf(" \n");

                        // criando nome da padaria e endereco
                        Padaria padariaUm = new Padaria(1, "Padaria Pao Doce Pao", "05/11/2001", 1, 89200105,
                                "Rua olinda", 746, "Guanabara", "Porto Alegre", "06:00 | 20:00");
                        Padaria padariaDois = new Padaria(2, "Padaria Srze", "15/02/2005", 2, 89200105, "Rua paranaue",
                                456, "Humaita", "Rio de janerio", "07:30 | 21:00");
                        Padaria padariaTres = new Padaria(3, "Padaria ferragem", "16/04/2007", 3, 89200105,
                                "Rua do irineu", 101, "Rocinha", "Curitiba", "08:00 | 22:00");

                        // Criando receitas para adicionar em chef e padaria
                        Receita receitaUm = new Receita(20, "Pao",
                                "Coloque em uma vasilha os ingredientes, misture bem e depois leve ao forno", 3,
                                "R$0,50");
                        Receita receitaDois = new Receita(25, "bolinho de chuva",
                                "misture trigo, açúcar e leve para a panela para fritar", 2, "R$1,50");
                        Receita receitaTres = new Receita(30, "coxinha", "leve ao microondas e esquente", 1, "R$3,50");
                        Receita receitaQuatro = new Receita(35, "pao de queijo", "leve ao forno e esquente", 1,
                                "R$2,50");
                        Receita receitaCinco = new Receita(40, "risoles", "coloque recheio na massa e frite", 2,
                                "R$3,00");
                        Receita receitaSeis = new Receita(45, "churros", "frite os churros em uma panela com oleo", 1,
                                "R$2,00");
                        Receita receitaSete = new Receita(50, "bolo de pote",
                                "coloque recheio dentro de um bolo e depois coloque no pote", 2, "R$6,50");
                        Receita receitaOito = new Receita(55, "bolo caseiro",
                                "misture os ingredientes e depois leve ao forno", 2, "R$10,00");
                        Receita receitaNove = new Receita(60, "mini pizza",
                                "coloque os ingredientes em uma massa e leve ao forno", 2, "R$5,50");
                        Receita receitaDez = new Receita(70, "pudim", "colocar em uma panela com acucar", 1, "R$4,75");
                        Receita receitaOnze = new Receita(80, "orelha de gato",
                                "misturar os ingredientes e colocar no forno", 2, "R$1,50");
                        Receita receitaDoze = new Receita(90, "chineque", "misturar farofa em um pão", 1, "R$2,75");
                        Receita receitaTreze = new Receita(100, "pao de mel", "colocar mel em cima de um pao", 3,
                                "R$6,00");
                        Receita receitaQuatorze = new Receita(110, "Suco de Laranja",
                                "coloque o tang na agua e misture", 2, "R$4,50");
                        Receita receitaQuinze = new Receita(120, "nega maluca",
                                "coloque brigadeira em cima de um bolo caseiro de chocolate", 3, "R$8,00");

                        // criando os três Mercado
                        Mercado mercadoUm = new Mercado(400, "Economia", "11/04/2001", "Promocao pague 2 leve 3", 2011,
                                899114564, "Rua piratuba", 3600, "jardim iririu", "Garuva");
                        Mercado mercadoDois = new Mercado(500, "Rodrigues", "07/02/1951",
                                "Na compra de um abacaxi o segundo voce leva de graca", 1003, 85546555,
                                "Rua Pedro sampaio", 315, "cruzeiro", "Santo andre");
                        Mercado mercadoTres = new Mercado(600, "Benvenutti", "15/05/2001",
                                "Churrasco em promocao no corredor quatro", 9841, 55512346, "Rua uruguaiana", 715,
                                "santo amaro", "Minas gerais");

                        padariaUm.adicionarReceita(receitaUm);
                        padariaUm.adicionarReceita(receitaDois);
                        padariaUm.adicionarReceita(receitaTres);
                        padariaUm.adicionarReceita(receitaQuatro);
                        padariaUm.adicionarReceita(receitaCinco);

                        padariaDois.adicionarReceita(receitaSeis);
                        padariaDois.adicionarReceita(receitaSete);
                        padariaDois.adicionarReceita(receitaOito);
                        padariaDois.adicionarReceita(receitaNove);
                        padariaDois.adicionarReceita(receitaDez);

                        padariaTres.adicionarReceita(receitaOnze);
                        padariaTres.adicionarReceita(receitaDoze);
                        padariaTres.adicionarReceita(receitaTreze);
                        padariaTres.adicionarReceita(receitaQuatorze);
                        padariaTres.adicionarReceita(receitaQuinze);

                        System.out.println("\n\t padaria: ");
                        System.out.println();
                        System.out.println(padariaUm.carteira());
                        System.out.println("\n- Receitas da 1°padaria:");
                        for (Receita receita : padariaUm.receitas) {
                            System.out.println(receita.nome + " - " + receita.valor);
                        }

                        System.out.println("\n\n");
                        System.out.println(padariaDois.carteira());
                        System.out.println("\n- Receitas da 2°padaria:");
                        for (Receita receita : padariaDois.receitas) {
                            System.out.println(receita.nome + " - " + receita.valor);
                        }

                        System.out.println("\n\n");
                        System.out.println(padariaTres.carteira());
                        System.out.println("\n- Receitas da 3°padaria:");
                        for (Receita receita : padariaTres.receitas) {
                            System.out.println(receita.nome + " - " + receita.valor);
                        }

                        mercadoUm.adicionarReceita(receitaUm);
                        mercadoUm.adicionarReceita(receitaDois);
                        mercadoUm.adicionarReceita(receitaTres);
                        mercadoUm.adicionarReceita(receitaQuatro);
                        mercadoUm.adicionarReceita(receitaCinco);

                        mercadoDois.adicionarReceita(receitaSeis);
                        mercadoDois.adicionarReceita(receitaSete);
                        mercadoDois.adicionarReceita(receitaOito);
                        mercadoDois.adicionarReceita(receitaNove);
                        mercadoDois.adicionarReceita(receitaDez);

                        mercadoTres.adicionarReceita(receitaOnze);
                        mercadoTres.adicionarReceita(receitaDoze);
                        mercadoTres.adicionarReceita(receitaTreze);
                        mercadoTres.adicionarReceita(receitaQuatorze);
                        mercadoTres.adicionarReceita(receitaQuinze);

                        System.out.println("\n\t Mercado: ");
                        System.out.println();
                        System.out.println(mercadoUm.carteira());
                        System.out.println("\n- Receitas do 1°mercado:");
                        for (Receita receita : mercadoUm.receitas) {
                            System.out.println(receita.nome + " - " + receita.valor);
                        }

                        System.out.println("\n\n Mercado: ");
                        System.out.println(mercadoDois.carteira());
                        System.out.println("\n- Receitas do 2°mercado:");
                        for (Receita receita : mercadoDois.receitas) {
                            System.out.println(receita.nome + " - " + receita.valor);
                        }

                        System.out.println("\n\n Mercado: ");
                        System.out.println(mercadoTres.carteira());
                        System.out.println("\n- Receitas do 3°mercado:");
                        for (Receita receita : mercadoTres.receitas) {
                            System.out.println(receita.nome + " - " + receita.valor);
                        }
                        System.out.println("\n");

                    case 4:
                        System.out.println("\n\n FIM DO PROGRAMA ");
                        break;
                }

            } while (escolhaPadaria != 4);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
