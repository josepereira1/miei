import java.util.*;
import java.util.stream.Collectors;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;

public class HoteisInc{
    
    private Map<String, Hotel> hoteis;

    public HoteisInc(){
        setHoteis(new HashMap<>());
    }
    
    public HoteisInc(Map<String, Hotel> hoteis){
        setHoteis(hoteis);
    }
    
    public HoteisInc(HoteisInc umHoteisInc){
        setHoteis(umHoteisInc.getHoteis());
    }
    
    public void setHoteis(Map<String, Hotel> hoteis){ // nunca esquecer do clone() à entrada
        this.hoteis = new HashMap<>(hoteis.size());
        for(Map.Entry<String,Hotel> entry: hoteis.entrySet())
            this.hoteis.put(entry.getKey(), entry.getValue().clone());
    }
    
    public Map<String, Hotel> getHoteis(){ // nunca esquecer do clone() à saída
        HashMap<String,Hotel> res = new HashMap<>(this.hoteis.size());
        for(Map.Entry<String, Hotel> entry: this.hoteis.entrySet())
            res.put(entry.getKey(), entry.getValue().clone());
        return res;
    }
    
    public HoteisInc clone(){
        return new HoteisInc(this);
    }
    
    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        HoteisInc umHoteisInc = (HoteisInc) o;
        return this.hoteis.equals(umHoteisInc.getHoteis());
    }
    
    public String toString(){
        final StringBuilder sb = new StringBuilder("HoteisInc{ ");
        sb.append("hoteis=").append(this.hoteis).append(" }");  
        return sb.toString();
    }
    
    public boolean existeHotel(String cod){
        
        /*
        for(String key: this.hoteis.keySet())
            if (key.equals(cod)) return true;
         
        return false;
        */
        
        return this.hoteis.containsKey(cod);
    }
    
    public int quantos(){
        return this.hoteis.size();
    }
    
    public int quantos(String loc){
        
       /* 
       int count = 0;
        
       for(Hotel hotel: this.hoteis.values())
           if (hotel.getLocalidade().equals(loc)) count++;
            
       return count;
       */
       
       return (int) this.hoteis.values().stream().filter(h -> h.getLocalidade().equals(loc)).count();
    }
    
    public Hotel getHotel(String cod) throws HotelInexistente{ // nunca esquecer do clone() à saída
        if(!existeHotel(cod)) throw new HotelInexistente(cod);
        return this.hoteis.get(cod).clone();
    }

    public void adiciona(Hotel h) throws AdicionarHotelRepetido, AdicionarHotelInvalido{ // nunca esquecer do clone() à entrada
        //if() throw new AdicionarHotelInvalido("Hotel inválido!"); não sabemos o que define um hotel inválido
        if(existeHotel(h.getId())) throw new AdicionarHotelRepetido(h.getId());
        this.hoteis.put(h.getId(), h.clone());
    }
    

    public List<Hotel> gethoteisList(){ 
        return this.hoteis.values().stream().map(h -> h.clone()).collect(Collectors.toList());  
    }
    

    public void adiciona(Set<Hotel> hs) throws AdicionarHotelRepetido{ // nunca esquecer do clone() à saída
        if(this.hoteis.containsKey(hs.stream())) throw new AdicionarHotelRepetido("Hotel repetido!");
        hs.forEach(h -> this.hoteis.put(h.getId(), h.clone()));
    }
    
    public int quantosT(String tipo){
        return (int) this.hoteis.values().stream().filter(h -> h.getClass().getSimpleName().equals(tipo)).count();
    }
    
    public void mudaPara(){
        for(Hotel h: this.hoteis.values())
            if (h instanceof HotelStandard){
                HotelStandard hs = (HotelStandard) h;
                if (hs.getEpoca() == true) hs.setEpoca(false);
                else hs.setEpoca(true);
            }
    }
    
    public double valorTotal(){
        return this.hoteis.values().stream().mapToDouble(
            h -> {
                if (h instanceof HotelDiscount){
                    HotelDiscount hs = (HotelDiscount) h;
                    double tmp = hs.getOcupacao();
                    hs.setOcupacao(1);
                    double t = hs.getNumero_de_quartos() * hs.getPreco_por_quarto();
                    hs.setOcupacao(tmp);
                    return t;
                }
                else return h.getNumero_de_quartos() * h.getPreco_por_quarto();
            }).sum();
    }
    
    public List<CartaoHoteis> daoPontos(){ 
       List<CartaoHoteis> res = new ArrayList<>();
       for(Hotel h: this.hoteis.values())
            if (h instanceof CartaoHoteis)
                res.add((CartaoHoteis)(h.clone()));
       return res;
    }
    
    public TreeSet<Hotel> ordenarHoteis(){
        TreeSet<Hotel> res = new TreeSet<>();
        this.hoteis.values().forEach(h -> res.add(h.clone()));
        return res;
    }
    
    public TreeSet<Hotel> ordenarHoteis(Comparator<Hotel> c){
        TreeSet<Hotel> res = new TreeSet<>(c);
        this.hoteis.values().forEach(h -> res.add(h.clone()));
        return res;
    }
    
    public Iterator<Hotel> ordenarHoteis(String criterio){
        
        //return new IteratorHotel(this.hoteis);
        
        TreeSet<Hotel> res = new TreeSet<>();
        this.hoteis.values().forEach(h -> res.add(h.clone()));
        return res.iterator();
    }
    
    public void save(String nomeFicheiro) throws FileNotFoundException, IOException{
        FileOutputStream foos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(foos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }
    
    public HoteisInc load(String nomeFicheiro) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(nomeFicheiro);
        ObjectInputStream oos = new ObjectInputStream(fis);
        HoteisInc hi = (HoteisInc) oos.readObject();
        oos.close();
        return hi;
    }
}
