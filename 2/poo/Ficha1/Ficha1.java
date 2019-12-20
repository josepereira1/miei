import java.time.LocalDateTime;
import java.time.Clock;

/**
 * Escreva a descrição da classe Ficha1 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Ficha1
{ 
    public double celsiusParaFarenheit(double graus){
    return graus*1.8+32;
    }
    
    public int maximoNumeros( int a, int b){
    return a > b ? a : b;
    }
    
    public String criaDescricaoConta(String nome, double saldo){
    return ("nome: "+nome+"," +"saldo: "+saldo);
    }
    
    public double eurosParaLibras( double valor, double taxaConversao){
    return valor * taxaConversao;
    }
    
    public void sortMedian(int n1, int n2){
        double median = ((n1+n2)/2);
        if(n1>n2){
        System.out.println(n1+" "+n2+" median = "+median);
        }else{
        System.out.println(n2+" "+n1+" median = "+median);
        }
    }
    public long fatorial(int num){
        long res = num;
        num--;
        while(num != 0){
        res = res*num;
        num--;
        }
        return res;
    }
    
    public long tempoGasto(int num){
        LocalDateTime time = LocalDateTime.now();
        long millis1 = System.currentTimeMillis();
        long res = fatorial(num);
        //double millis2 = System.currentTimeMillis() % 1000;
        long millis2 = System.currentTimeMillis();
        System.out.println("millis antes: "+millis1);
        System.out.println("millis: "+millis2);
        System.out.println((millis2-millis1));
        return res;
    }
}
