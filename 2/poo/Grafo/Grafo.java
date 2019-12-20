
/**
 * Escreva a descrição da classe Grafo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;

public class Grafo
{
    private Map<Integer, Set<Integer>> adj;
    
    public Grafo(){
        this.setAdj(new HashMap<Integer,Set<Integer>>());
    }
    
    public Grafo(Map<Integer,Set<Integer>> adj){
        this.setAdj(adj);
    }
    
    public Grafo(Grafo umGrafo){
        this.setAdj(umGrafo.getAdj());
    }
    
    public Map<Integer, Set<Integer>> getAdj(){
        HashMap<Integer, Set<Integer>> clone = new HashMap<Integer,Set<Integer>>();
        
        for(Map.Entry<Integer, Set<Integer>> entry : this.adj.entrySet()){
            clone.put(entry.getKey(), entry.getValue());
        }
        return clone;
    }
    
    public void setAdj(Map<Integer,Set<Integer>> adj){
        this.adj = new HashMap<Integer, Set<Integer>> ();
        
        for(Map.Entry<Integer, Set<Integer>> entry : adj.entrySet()){
            this.adj.put(entry.getKey(), entry.getValue());
        }
    }
    
    public Grafo clone(){
        return new Grafo(this);
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || this.getClass() != o.getClass())return false;
        
        Grafo grafo = (Grafo) o;
        
        return this.adj.equals(grafo);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder("Grafo={");
        sb.append("adj=").append(this.adj.toString());
        return sb.toString();
    }
    
    public void addArco(Integer vOrig, Integer vDest){
        if(!this.adj.containsKey(vOrig)){
            TreeSet<Integer> tmp = new TreeSet<Integer>();
            tmp.add(vDest);
            this.adj.put(vOrig, tmp);
        }else{
            this.adj.get(vOrig).add(vDest);
        }
    }
    
    public boolean isSink(Integer v){
        return this.adj.get(v).isEmpty();
    }
    
    public boolean isSource(Integer v){
        for(Map.Entry<Integer,Set<Integer>> entry : this.adj.entrySet())
            if(entry.getValue().contains(v))return false;
        return true;
    }
    
    public int size(){
        return this.adj.size() + this.adj.values().size();
    }
    
    /*
    public boolean haCaminho(Integer vOrig, Integer vDest){
        for(Integer no : this.adj.get(vOrig)){
            if(no == vDest) return true;
        }
    }*/
    
    
}
