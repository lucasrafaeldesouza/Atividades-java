public class SistemaPrincipal {
    public static void main(String[] args) {

        // criando os três chefes
        Chef chefUm = new Chef(1, "Lucas", "10053074904", "15/05/2001", "doces e salgados","R$1200");
        Chef chefDois = new Chef(2, "Rafael", "10053074905", "15/05/2002", "massas e carnes","R$2000");
        Chef chefTres = new Chef(3, "Souza", "10053074906", "15/05/2003", "comidas asiaticas","R$3750");

        // criando nome da padaria e endereco
        Padaria padariaUm = new Padaria(1, "Padaria Pao Doce Pao", "05/11/2001",1, 89200105, "Rua olinda", 746,"Guanabara", "Porto Alegre","06:00 | 20:00");
        Padaria padariaDois = new Padaria(2, "Padaria Srze", "15/02/2005", 2, 89200105, "Rua paranaue", 456, "Humaita","Rio de janerio","07:30 | 21:00");
        Padaria padariaTres = new Padaria(3, "Padaria ferragem", "16/04/2007", 3, 89200105, "Rua do irineu", 101,"Rocinha", "Curitiba","08:00 | 22:00");

        // Criando receitas para adicionar em chef e padaria
        Receita receitaUm = new Receita(20, "Pao","Coloque em uma vasilha os ingredientes, misture bem e depois leve ao forno", 3, "R$0,50");
        Receita receitaDois = new Receita(25, "bolinho de chuva","misture trigo, açúcar e leve para a panela para fritar", 2, "R$1,50");
        Receita receitaTres = new Receita(30, "coxinha", "leve ao microondas e esquente", 1, "R$3,50");
        Receita receitaQuatro = new Receita(35, "pao de queijo", "leve ao forno e esquente", 1, "R$2,50");
        Receita receitaCinco = new Receita(40, "risoles", "coloque recheio na massa e frite", 2, "R$3,00");
        Receita receitaSeis = new Receita(45, "churros", "frite os churros em uma panela com oleo", 1, "R$2,00");
        Receita receitaSete = new Receita(50, "bolo de pote", "coloque recheio dentro de um bolo e depois coloque no pote", 2, "R$6,50");
        Receita receitaOito = new Receita(55, "bolo caseiro", "misture os ingredientes e depois leve ao forno", 2,"R$10,00");
        Receita receitaNove = new Receita(60, "mini pizza", "coloque os ingredientes em uma massa e leve ao forno", 2,"R$5,50");
        Receita receitaDez = new Receita(70, "pudim", "colocar em uma panela com acucar", 1, "R$4,75");
        Receita receitaOnze = new Receita(80, "orelha de gato", "misturar os ingredientes e colocar no forno", 2,"R$1,50");
        Receita receitaDoze = new Receita(90, "chineque", "misturar farofa em um pão", 1, "R$2,75");
        Receita receitaTreze = new Receita(100, "pao de mel", "colocar mel em cima de um pao", 3, "R$6,00");
        Receita receitaQuatorze = new Receita(110, "Suco de Laranja", "coloque o tang na agua e misture", 2, "R$4,50");
        Receita receitaQuinze = new Receita(120, "nega maluca","coloque brigadeira em cima de um bolo caseiro de chocolate", 3, "R$8,00");

        // criando os três clientes
        Cliente clienteUm = new Cliente("Caleb Samuel Leonardo Freitas", "101.977.364-24", "17/11/1989", "2014-8854");
        Cliente clienteDois = new Cliente("Natália Giovana Ana da Mota", "33.476.923-1", "27/10/1958", "2719-0917");
        Cliente clienteTres = new Cliente("Sérgio Ryan Lucca da Cunha", "987.859.115-85", "06/06/1963", "1707-9665");

        // criando os três Mercado
        Mercado mercadoUm = new Mercado(400, "Economia", "11/04/2001", "Promocao pague 2 leve 3", 2011, 899114564,"Rua piratuba", 3600, "jardim iririu", "Garuva");
        Mercado mercadoDois = new Mercado(500, "Rodrigues", "07/02/1951","Na compra de um abacaxi o segundo voce leva de graca", 1003, 85546555, "Rua Pedro sampaio", 315,"cruzeiro", "Santo andre");
        Mercado mercadoTres = new Mercado(600, "Benvenutti", "15/05/2001", "Churrasco em promocao no corredor quatro",9841, 55512346, "Rua uruguaiana", 715, "santo amaro", "Minas gerais");

        chefUm.adicionarReceita(receitaUm);
        chefUm.adicionarReceita(receitaDois);
        chefUm.adicionarReceita(receitaTres);
        chefUm.adicionarReceita(receitaQuatro);
        chefUm.adicionarReceita(receitaCinco);

        chefDois.adicionarReceita(receitaSeis);
        chefDois.adicionarReceita(receitaSete);
        chefDois.adicionarReceita(receitaOito);
        chefDois.adicionarReceita(receitaNove);
        chefDois.adicionarReceita(receitaDez);

        chefTres.adicionarReceita(receitaOnze);
        chefTres.adicionarReceita(receitaDoze);
        chefTres.adicionarReceita(receitaTreze);
        chefTres.adicionarReceita(receitaQuatorze);
        chefTres.adicionarReceita(receitaQuinze);

        System.out.println("\n\t chefs:");
        System.out.println();
        System.out.println(chefUm.carteira());
        System.out.println("\n- Receitas do 1°chef:");
        for (Receita receita : chefUm.receitas) {
            System.out.println(receita.nome + " - " + receita.valor);
        }

        System.out.println("\n\n");
        System.out.println(chefDois.carteira());
        System.out.println("\n- Receitas do 2°chef:");
        for (Receita receita : chefDois.receitas) {
            System.out.println(receita.nome + " - " + receita.valor);
        }

        System.out.println("\n\n");
        System.out.println(chefTres.carteira());
        System.out.println("\n- Receitas do 3°chef:");
        for (Receita receita : chefTres.receitas) {
            System.out.println(receita.nome + " - " + receita.valor);
        }

        clienteUm.adicionarReceita(receitaUm);
        clienteUm.adicionarReceita(receitaDois);
        clienteUm.adicionarReceita(receitaTres);
        clienteUm.adicionarReceita(receitaQuatro);
        clienteUm.adicionarReceita(receitaCinco);

        clienteDois.adicionarReceita(receitaSeis);
        clienteDois.adicionarReceita(receitaSete);
        clienteDois.adicionarReceita(receitaOito);
        clienteDois.adicionarReceita(receitaNove);
        clienteDois.adicionarReceita(receitaDez);

        clienteTres.adicionarReceita(receitaOnze);
        clienteTres.adicionarReceita(receitaDoze);
        clienteTres.adicionarReceita(receitaTreze);
        clienteTres.adicionarReceita(receitaQuatorze);
        clienteTres.adicionarReceita(receitaQuinze);

        System.out.println("\n\t clientes: ");
        System.out.println();
        System.out.println(clienteUm.carteira());
        System.out.println("\n- Receitas do 1°cliente:");
        for (Receita receita : clienteUm.receitas) {
            System.out.println(receita.nome + " - " + receita.valor);
        }

        System.out.println("\n\n");
        System.out.println(clienteDois.carteira());
        System.out.println("\n- Receitas do 2°cliente:");
        for (Receita receita : clienteDois.receitas) {
            System.out.println(receita.nome + " - " + receita.valor);
        }

        System.out.println("\n\n");
        System.out.println(clienteTres.carteira());
        System.out.println("\n- Receitas do 3°cliente:");
        for (Receita receita : clienteTres.receitas) {
            System.out.println(receita.nome + " - " + receita.valor);
        }

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

        System.out.println("\n\t mercado: ");
        System.out.println();
        System.out.println(mercadoUm.carteira());
        System.out.println("\n- Receitas do 1°mercado:");
        for (Receita receita : mercadoUm.receitas) {
            System.out.println(receita.nome + " - " + receita.valor);
        }

        System.out.println("\n\n");
        System.out.println(mercadoDois.carteira());
        System.out.println("\n- Receitas do 2°mercado:");
        for (Receita receita : mercadoDois.receitas) {
            System.out.println(receita.nome + " - " + receita.valor);
        }

        System.out.println("\n\n");
        System.out.println(mercadoTres.carteira());
        System.out.println("\n- Receitas do 3°mercado:");
        for (Receita receita : mercadoTres.receitas) {
            System.out.println(receita.nome + " - " + receita.valor);
        }
        System.out.println("\n");
    }
}