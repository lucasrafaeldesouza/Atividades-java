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
        Receita receitaUm = new Receita(20, "Pao","Coloque em uma vasilha os ingredientes, misture bem e depois leve ao forno", 3,"R$0,50");
        Receita receitaDois = new Receita(25, "bolinho de chuva","misture trigo, açúcar e leve para a panela para fritar", 2,"R$1,50");
        Receita receitaTres = new Receita(30, "coxinha", "leve ao microondas e esquente", 1,"R$3,50");
        Receita receitaQuatro = new Receita(35, "pao de queijo", "leve ao forno e esquente", 1,"R$2,50");
        Receita receitaCinco = new Receita(40, "risoles", "coloque recheio na massa e frite", 2,"R$3,00");
        Receita receitaSeis = new Receita(45, "churros", "frite os churros em uma panela com oleo", 1,"R$2,00");
        Receita receitaSete = new Receita(50, "bolo de pote","coloque recheio dentro de um bolo e depois coloque no pote", 2,"R$6,50");
        Receita receitaOito = new Receita(55, "bolo caseiro", "misture os ingredientes e depois leve ao forno", 2,"R$10,00");
        Receita receitaNove = new Receita(60, "mini pizza", "coloque os ingredientes em uma massa e leve ao forno", 2,"R$5,50");
        Receita receitaDez = new Receita(70,"pudim","colocar em uma panela com acucar",1,"R$4,75");
        Receita receitaOnze = new Receita(80,"orelha de gato","misturar os ingredientes e colocar no forno",2,"R$1,50");
        Receita receitaDoze = new Receita(90,"chineque","misturar farofa em um pão",1,"R$2,75");


        Receita receitaTreze = new Receita(100,"Vitamina","Bater tudo no liquidificador e acrescentar gelo picado.",3,"R$6,00");
        Receita receitaQuatorze = new Receita(110,"Suco de Laranja","Misture tudo em 1 jarra de água gelada.",2,"R$4,50");
        Receita receitaQuinze = new Receita(120,"Bolo de Fubá","Em um liquidificador, adicione os ovos, o açúcar, o fubá, a farinha de trigo, o óleo, o leite e o fermento",3,"R$8,00");
        Receita receitaDezesseis = new Receita(130,"Café c/leite"," Bata todos os ingredientes na batedeira por 15 a 20 minutos até virar uma pasta cremosa",3,"R$2,50");
        Receita receitaDezessete = new Receita(140,"Pão de Hambúrguer","Em uma vasilha, misture 250g da farinha de trigo, o fermento e o sal.",8,"R$3,20");
        Receita receitaDezoito = new Receita(150,"Café","Em um suporte para filtro, coloque o filtro de papel e o pó.",3,"R$1,50");



        //criando os três clientes
        Cliente clienteUm = new Cliente("Caleb Samuel Leonardo Freitas","101.977.364-24","17/11/1989","2014-8854");
        Cliente clienteDois = new Cliente("Natália Giovana Ana da Mota","33.476.923-1","27/10/1958","2719-0917");
        Cliente clienteTres = new Cliente("Sérgio Ryan Lucca da Cunha","987.859.115-85","06/06/1963","1707-9665");

        //criando os três 
        Mercados mercadoUm = new Mercados(400,"Angeloni","01/01/1998","Carnes em promoção","1935","89204-080","Rua João Colin",2800,"Saguaçu","Joinville-SC");
        Mercados mercadoDois = new Mercados(500,"Giassi","06/08/1978","Refrigerantes em promoção","4002","89211-321","Rua Orestes Guimarães",315,"Centro","Joinville-SC");
        Mercados mercadoTres = new Mercados(600,"Condor","11/08/2000","Frutas em promoção","8922","89278-020","Rua Blumenau",715,"Atiradores","Joinville-SC");

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