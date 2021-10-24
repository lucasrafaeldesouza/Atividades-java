public class SistemaPrincipal {

        public static void main(String[] args) {
                Chef chefUm = new Chef(1, "Lucas", "10053074904", "15/05/2001");
                Chef chefDois = new Chef(2, "Rafael", "10053074905", "15/05/2002");
                Chef chefTres = new Chef(3, "Souza", "10053074906", "15/05/2003");

                System.out.println(chefUm.receitas);
                System.out.println(chefDois.receitas);
                System.out.println(chefTres.receitas);

                Padaria padariaUm = new Padaria(1, "PaoDocePao", "20/03/2008", endereco);
                Padaria padariaDois = new Padaria(2, "Srze", "30/05/2008", endereco);
                Padaria padariaTres = new Padaria(3, "padaria", "20/04/2010", endereco);

                System.out.println(padariaUm.nome);
                System.out.println(padariaDois.nome);
                System.out.println(padariaTres.nome);

                Receita receitaUm = new Receita(20,"Pao","Coloque em uma vasilha os ingredientes, misture bem e depois leve ao forno",3);
                Receita receitaDois = new Receita(25,"bolinho de chuva","misture trigo, açúcar e leve para a panela para fritar",2);
                Receita receitaTres = new Receita(30,"coxinha","leve ao microondas e esquente",1);
                Receita receitaQuatro = new Receita(35,"pao de queijo","leve ao forno e esquente",1);
                Receita receitaCinco = new Receita(40,"risoles","coloque recheio na massa e frite",2);
                Receita receitaSeis= new Receita(45,"churros","frite os churros em uma panela com oleo",1);
                Receita receitaSete = new Receita(50,"bolo de pote","coloque recheio dentro de um bolo e depois coloque no pote",2);
                Receita receitaOito = new Receita(55,"bolo caseiro","misture os ingredientes e depois leve ao forno"2);
                Receita receitaNove= new Receita(60,"");


                Endereco endereco = new Endereco(21, 89224403, "Rua santa catarina", 361, "iririu", "curitiba",Padaria);
                Endereco endereco = new Endereco(22, 89204060, "Rua blumenau", 1023, "centro", "sao paulo", Padaria);
                Endereco endereco = new Endereco(23, 89007437, "Rua selma doering bruns", 101, "floresta", "joinville",Padaria);

        }

}
