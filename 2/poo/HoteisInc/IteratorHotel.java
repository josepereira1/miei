import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IteratorHotel implements Iterator<Hotel>{
    
    private List<Hotel> hoteis;
    
    public IteratorHotel(){
         setHoteis(new HashMap<>());
    }
    
    public IteratorHotel(Map<String, Hotel> hoteis){
         setHoteis(hoteis);
    }
    
    public IteratorHotel(IteratorHotel iterador){
         setHoteis(iterador.getHoteis());
    }
    
    public void setHoteis(Map<String, Hotel> hoteis){ // nunca esquecer do clone() à entrada
        this.hoteis = new ArrayList<>(hoteis.size());
        for(Map.Entry<String,Hotel> entry: hoteis.entrySet())
            this.hoteis.add(entry.getValue().clone());
    }
    
    public Map<String, Hotel> getHoteis(){ // nunca esquecer do clone() à saída
        HashMap<String,Hotel> res = new HashMap<>(this.hoteis.size());
        for(Hotel h: this.hoteis)
            res.put(h.getId(), h.clone());
        return res;
    }
    
    public boolean hasNext(){
        if (!this.hoteis.isEmpty()) return true;
        else return false;
    }
    
    public Hotel next(){
        Hotel h = this.hoteis.get(0).clone();
        this.hoteis.remove(0);
        return h;
    }
    
    public void remove(){
        this.hoteis.remove(0);
    }

}
