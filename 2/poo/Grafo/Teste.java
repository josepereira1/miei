
/**
 * Escreva a descrição da classe Teste aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Teste
{
    public static void main(String[] args){
        HashMap<Integer, Set<Integer>> grafo = new HashMap<> ();
        TreeSet<Integer> tmp = new TreeSet<> ();
        tmp.add(2);
        tmp.add(3);
        tmp.add(4);
        grafo.put(1,tmp);
        
        Grafo g1 = new Grafo(grafo);
        System.out.println(g1);
        g1.addArco(2, 3);
        System.out.println(g1);
        
        
    }
}
