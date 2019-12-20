import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Month;


/**
 * Escreva a descrição da classe Ficha1Test aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ficha1Test
{
    public static void main(String[] args){
    ex_7();
    }
    
   
    public static void ex_1(){
        Scanner sc = new Scanner (System.in);
        Ficha1 f = new Ficha1();
        System.out.println("Introduza a temperatura em ºC");
        double tc = sc.nextDouble();
        double tf = f.celsiusParaFarenheit(tc);
        System.out.println("A conversao de "+ tc + " ºC para ºF e " + tf);
    }
    
    public static void ex_2(){
        Scanner sc = new Scanner(System.in);
        Ficha1 f = new Ficha1();
        System.out.println("Introduza o primeiro numero:");
        int n1 = sc.nextInt();
        System.out.println("Introduza o segundo numero:");
        int n2 = sc.nextInt();
        int res = f.maximoNumeros(n1,n2);
        System.out.println("maior:"+res);
    }
    
    public static void ex_3(){
        Scanner sc = new Scanner(System.in);
        Ficha1 f = new Ficha1();
        System.out.println("Insira o seu nome:");
        String nome = sc.nextLine();
        System.out.println("Insira o seu saldo:");
        double saldo = sc.nextDouble();
        String info = f.criaDescricaoConta(nome, saldo);
        System.out.println(info);
    }
    
    public static void ex_4(){
        Scanner sc = new Scanner(System.in);
        Ficha1 f = new Ficha1();
        System.out.println("Insira um valor em euros: ");
        double valor = sc.nextDouble();
        double taxaConversao = 0.98;
        double res = f.eurosParaLibras(valor, taxaConversao);
        System.out.println(valor+" euros "+" = "+res+" libras"); 
    }
    
    public static void ex_5(){
        Scanner sc = new Scanner(System.in);
        Ficha1 f = new Ficha1();
        System.out.println("Insira o primeiro valor");
        int n1 = sc.nextInt();
        System.out.println("Insira o segundo valor");
        int n2 = sc.nextInt();
        f.sortMedian(n1,n2);
    }
    
    public static void ex_6(){
        Scanner sc = new Scanner(System.in);
        Ficha1 f = new Ficha1();
        System.out.println("Insira um valor:");
        int n1 = sc.nextInt();
        System.out.println("O fatorial de "+n1+" = "+f.fatorial(n1));
    }
    
    public static void ex_7(){
        LocalDateTime time = LocalDateTime.now();
        Scanner sc = new Scanner(System.in);
        Ficha1 f = new Ficha1();
        
        double year = time.getYear();
        Month month = time.getMonth();
        int day = time.getDayOfMonth();
        System.out.println(day+"/"+month+"/"+year);
        
        System.out.println("Insira um valor:");
        int n1 = sc.nextInt();
        
        System.out.println("O fatorial de "+n1+" = "+f.tempoGasto(n1));
    }
}
