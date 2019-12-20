
/**
 * Write a description of class Grafo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Set;
import java.util.HashSet;
import java.util.Map; 
import java.util.HashMap;
import java.util.*;

public class Grafo {
    private Map<Integer, Set<Integer>> adj;
    
    public Grafo(){
        Map<Integer,Set<Integer>> adj = new HashMap<>();
    }
    
    public Grafo(Map<Integer, Set<Integer>> adj){
        Map<Integer,Set<Integer>> clone = new HashMap<>();
        this.adj = new HashMap<>();
        for(Map.Entry<Integer, Set<Integer>> entry : adj.entrySet()){   //  Map.Entry<Integer, Set<Integer>> isto é um elemento do SET!!
            this.adj.put(entry.getKey(), new HashSet<Integer>(entry.getValue()));
            //entry.values().stream().map(Class :: clone).collect(Collectors.toSet());  //esta linha era caso o nosso tipo do Map, fosse
                                                                                        // uma nossa uma estrutura
            
        }
        
        /*
        for(Integer i: adj.keySet()){   //  keySet() dá-me o conjunto das keys;
            this.adj.put(i;new HashSet(adj.get(i));
        }   
        */
        
        
    }
    
    //exercício 5 b):
    void addArco(Integer from, Integer to){
        if(!adj.containsKey(from)){
            adj.put(from,new HashSet<>());
        }
        if(!adj.containsKey(to)){
            adj.put(to,new HashSet<>());
        }
        adj.get(from).add(to);  //  vai buscar a lista dos nós que saem do from e adiciona o to;
    }
    
    //exercício 5 c):
    boolean isSink(Integer v){
        return !adj.get(v).isEmpty();
    }
    
    //exercício 6 d):
    boolean isSource(Integer v){    //  values() pega em todos os valores;
        for(Set<Integer> vertices: this.adj.values()){
            if(vertices.contains(v)) return false;
        }
        return true;
    }
    
    /*
     * ISTO É MUITO BONITO , MAS O Map.Entry é uma interface, logo não posso criar instâncias de uma coisa que não é um class, a
     * segunda solução é a correcta, visto que o java já fez uma maneira de contronar o problema;
    public Set<Map.Entry<Integer,Integer>>fanOut(Integer v){
        if(!adj.containKey(v)) return null;
        
        Set<Map.Entry<Integer,Integer>> res = new TreeSet();
        
        for(Integer a: adj.get(v)){
            res.add(new Map.Entry<Integer,Integer>(v,a));
        }
        return res;
    }
    */
    
    public Set<Map.Entry<Integer,Integer>>fanOut(Integer v){
        if(this.adj.containsKey(v)) return null;
        
        Set<Map.Entry<Integer,Integer>> res = new TreeSet();    //  AQUI NÃO PODEMOS FAZER new Set<>(), pq supreendemen-te o Set é UMA INTERFACE;
        
        /*
         *  for(Map.Entry<int,Set<int>> e: adj.entrySet()){
            if(e.getValue().containsKey(v)){
            res.add(new AbstractMap.SimpleEntry(e.getKey(),v));
            }
        }*/
        
        for(Integer a: adj.get(v)){
            res.add(new AbstractMap.SimpleEntry<Integer,Integer>(v,a));
        }
        return res;
    }
    
    
}
