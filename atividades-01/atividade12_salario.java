public class Exercicios 
{
    public static void main(String args[]) 
    {
    System.out.println("Ex. 1 ");
        {
        int nota1 = 10;
        int nota2 = 10;
        int nota3 = 7;
        int nota4 = 5;
        
        int media = (nota1 + nota2 + nota3 + nota4) / 4;
        
        System.out.println(media);
        }
    System.out.println("\n");
        
    System.out.println("Ex. 2 ");
        {
        double lado1 = 3.50;
        float lado2 = 6;
        
        double area = lado1 * lado2;
        
        System.out.println(area);
        }
    System.out.println("\n");
        
    System.out.println("Ex. 3 ");
        {    
        double largura = 7;
        double altura = 6;
        double profundidade = 2;
        
        double volume = altura * largura * profundidade;
        
        System.out.println(volume);
        }
    System.out.println("\n");
        
    System.out.println("Ex. 4 "); 
        {
        int valor1 = 10;
        int valor2 = 10;
        
        String message = valor2 >= valor1 * 2 ? "É maior ou igual ao valor 1" : "Não é maior igual ao valor 1";
        
        System.out.println(message);
        }
    System.out.println("\n");
    
    System.out.println("Ex. 5");
        {
        int a = 1;
        int b = 0;
        int c = -4;
        
        int delta = (b * b) - (4 * a * c);
        double x = (-b + Math.sqrt(delta)) / (2 * a);
        double xL = (-b - Math.sqrt(delta)) / (2 * a);
        
        System.out.println(x);
        System.out.println(xL);
        }
    System.out.println("\n");
    
    System.out.println("Ex. 6");
        {
        int km = 350;
        int h = 3;
        
        double vel_media = km / h;
        
        System.out.println(vel_media + "km/h");
        }
    System.out.println("\n");
    
    System.out.println("Ex. 7");
        {
        double faturamento = 3750.60;
        double imposto = 1050.00;
        
        double imposto_pago = (faturamento/imposto);
        
        System.out.println(imposto_pago);
        }
    System.out.println("\n");
     
    System.out.println("Ex. 8");
        {
        int valor = 5;
        
        String msg = (valor%2)==0? "É par" : "É impar";
        
        System.out.println(msg);
        }
    System.out.println("\n");
        
    System.out.println("Ex. 9");
        {    
        int valor3 = 10;
        int valor4 = 38;
        
        String men= valor4 >= valor3 * 2 ? "É maior ou igual ao valor 3" : "Não é maior igual ao valor 3";
        
        System.out.println(men);
        }
    System.out.println("\n");
    
    System.out.println("Ex. 10");
        {
        String abc = " 10";
        String abcd = "10";
        
        boolean comparar = abc.equals(abcd);
        
        System.out.println(comparar);
        }
    System.out.println("\n");
    
    System.out.println("Ex. 11");
        {
        String bem = "3.2";
        int mal = (int) Double.parseDouble(bem);
        
        System.out.println(mal);
        }
    System.out.println("\n");
    
    System.out.println("Ex. 12");
        {
        double salario = 4500;
        
        String aliquota = salario <= 1903.98 ? "Isento" : salario <= 2826.65 ? "7.5%" : salario <= 3751.05 ? "15%" : salario <= 4664.68 ? "22.5%" : "27.5%";
        
        System.out.println(aliquota);
        }
    }
}