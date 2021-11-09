public class SistemaPrincipal {
    public static void main(String[] args) {

        // criando os três chefes
        Chef chefUm = new Chef(1, "Lucas", "10053074904", "15/05/2001");
        Chef chefDois = new Chef(2, "Rafael", "10053074905", "15/05/2002");
        Chef chefTres = new Chef(3, "Souza", "10053074906", "15/05/2003");

        System.out.println(chefUm.receitas);
        System.out.println(chefDois.receitas);
        System.out.println(chefTres.receitas);

        // criando nome da padaria e endereco
        Padaria padariaUm = new Padaria(1, "Padaria Pao Doce Pao", "05/11/2001", 1, 89200105, "Rua olinda", 746,"Guanabara", "Porto Alegre");
        Padaria padariaDois = new Padaria(2, "Padaria Srze", "15/02/2005", 2, 89200105, "Rua paranaue", 456, "Humaita","Rio de janerio");
        Padaria padariaTres = new Padaria(3, "Padaria ferragem", "16/04/2007", 3, 89200105, "Rua do irineu", 101,"Rocinha", "Curitiba");

        System.out.println(padariaUm.nome);
        System.out.println(padariaDois.nome);
        System.out.println(padariaTres.nome);

        // Criando receitas para adicionar em chef e padaria
        Receita receitaUm = new Receita(20, "Pao","Coloque em uma vasilha os ingredientes, misture bem e depois leve ao forno", 3);
        Receita receitaDois = new Receita(25, "bolinho de chuva","misture trigo, açúcar e leve para a panela para fritar", 2);
        Receita receitaTres = new Receita(30, "coxinha", "leve ao microondas e esquente", 1);

        Receita receitaQuatro = new Receita(35, "pao de queijo", "leve ao forno e esquente", 1);
        Receita receitaCinco = new Receita(40, "risoles", "coloque recheio na massa e frite", 2);
        Receita receitaSeis = new Receita(45, "churros", "frite os churros em uma panela com oleo", 1);
        Receita receitaSete = new Receita(50, "bolo de pote","coloque recheio dentro de um bolo e depois coloque no pote", 2);
        Receita receitaOito = new Receita(55, "bolo caseiro", "misture os ingredientes e depois leve ao forno", 2);
        Receita receitaNove = new Receita(60, "mini pizza", "coloque os ingredientes em uma massa e leve ao forno", 2);

        chefUm.adicionarReceita(receitaUm);
        chefUm.adicionarReceita(receitaDois);
        chefUm.adicionarReceita(receitaTres);

        chefDois.adicionarReceita(receitaQuatro);
        chefDois.adicionarReceita(receitaCinco);
        chefDois.adicionarReceita(receitaSeis);

        chefTres.adicionarReceita(receitaSete);
        chefTres.adicionarReceita(receitaOito);
        chefTres.adicionarReceita(receitaNove);

        System.out.println("Receitas do Chef Lucas:");
        for (Receita receita : chefUm.receitas) {
            System.out.println(receita.nome);
        }
        System.out.println("\n");

        System.out.println("Receitas do Chef Rafael:");
        for (Receita receita : chefDois.receitas) {
            System.out.println(receita.nome);
        }
        System.out.println("\n");

        System.out.println("Receitas do Chef Souza:");
        for (Receita receita : chefTres.receitas) {
            System.out.println(receita.nome);
        }
        System.out.println("\n");

        // Adicionando receita em padaria
        padariaUm.adicionarReceita(receitaUm);
        padariaUm.adicionarReceita(receitaDois);
        padariaUm.adicionarReceita(receitaTres);
        padariaUm.adicionarReceita(receitaQuatro);
        padariaUm.adicionarReceita(receitaCinco);

        padariaDois.adicionarReceita(receitaQuatro);
        padariaDois.adicionarReceita(receitaCinco);
        padariaDois.adicionarReceita(receitaSeis);
        padariaDois.adicionarReceita(receitaSete);
        padariaDois.adicionarReceita(receitaOito);

        padariaTres.adicionarReceita(receitaOito);
        padariaTres.adicionarReceita(receitaNove);
        padariaTres.adicionarReceita(receitaUm);
        padariaTres.adicionarReceita(receitaDois);
        padariaTres.adicionarReceita(receitaTres);

        System.out.println("\n Padaria Pao Doce Pao:");
        for (Receita receita : padariaUm.receitas) {
            System.out.println(receita.nome);
        }

        System.out.println("\n Endereço: ");
        System.out.println(" \n CEP: " + padariaUm.endereco.cep + " \n Rua: " + padariaUm.endereco.rua + " \n Número: "
                + padariaUm.endereco.numero + " \n Bairro: " + padariaUm.endereco.bairro + " \n Cidade: "
                + padariaUm.endereco.cidade);
        System.out.println("\n");

        System.out.println("Padaria Sr Ze: ");

        for (Receita receita : padariaDois.receitas) {
            System.out.println(receita.nome);
        }

        System.out.println("\n Endereço: ");
        System.out.println(" \n CEP: " + padariaDois.endereco.cep + " \n Rua: " + padariaDois.endereco.rua
                + " \n Número: " + padariaDois.endereco.numero + " \n Bairro: " + padariaDois.endereco.bairro
                + " \n Cidade: " + padariaDois.endereco.cidade);
        System.out.println("\n");

        System.out.println("Padaria ferragem: ");

        for (Receita receita : padariaTres.receitas) {
            System.out.println(receita.nome);
        }

        System.out.println("\n Endereço:");
        System.out.println(" \n CEP: " + padariaTres.endereco.cep + " \n Rua: " + padariaTres.endereco.rua
                + " \n Número: " + padariaTres.endereco.numero + " \n Bairro: " + padariaTres.endereco.bairro
                + " \n Cidade: " + padariaTres.endereco.cidade);
    }
}