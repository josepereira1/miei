
/**
 * Escreva a descrição da classe HoteisInc aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.*;
import java.util.stream.Collectors;

public class HoteisInc
{
    private Map<String,Hotel> hoteis;
    
    public HoteisInc(){
        this.setHoteis(new HashMap<String,Hotel> ());
    }
    
    public HoteisInc(Map<String,Hotel> hoteis){
        this.setHoteis(hoteis);
    }
    
    public HoteisInc(HoteisInc umHotel){
        this.setHoteis(umHotel.getHoteis());
    }
    
    public Map<String,Hotel> getHoteis(){   //  NUNCA esquecer clone à saída;
        HashMap<String,Hotel> clone = new HashMap<String,Hotel> (this.hoteis.size());
        for(Map.Entry<String,Hotel> entry : this.hoteis.entrySet()){    //  entrySet vai buscar todos os valores do HashMap e coloca-os em pares, esses pares são os designados por Map.Entry
            clone.put(entry.getKey(), entry.getValue().clone());
        }
        return clone;
    }
    
    public void setHoteis(Map<String,Hotel> hoteis){    //  NUNCA esquecer clone à entrada;
        this.hoteis = new HashMap<String,Hotel> (hoteis.size());
        for(Map.Entry<String,Hotel> entry : hoteis.entrySet()){    //  entrySet vai buscar todos os valores do HashMap e coloca-os em pares, esses pares são os designados por Map.Entry
            this.hoteis.put(entry.getKey(), entry.getValue().clone());
        }
    }
    
    public HoteisInc clone(){
        return new HoteisInc(this);
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || o.getClass() != this.getClass())return false;
        
        HoteisInc hotel = (HoteisInc) o;
        
        return this.getHoteis().equals(hotel.getHoteis());
    }
    
    public boolean existeHotel(String cod){
        /*
        for(Map.Entry<String,Hotel> entry :this.getHoteis().entrySet()){
            if(entry.getValue().getCodigo().equals(cod))return true;
        }
        return false;
        */
       return this.getHoteis().containsKey(cod);
    }
    
    public int quantos(){
        return this.getHoteis().size();
    }
    
    public int quantos(String local){
        int cnt = 0;
        for(Map.Entry<String,Hotel> entry : this.getHoteis().entrySet()){
            if(entry.getValue().getLocalidade() == local)cnt++;
        }
        return cnt;
    }
    
    public Hotel getHotel(String cod){
        /*for(Map.Entry<String,Hotel> entry :this.getHoteis().entrySet()){
            if(entry.getValue().getCodigo().equals(cod))return entry.getValue();
        }
        return null;
        */
        return this.getHoteis().get(cod);
    }
    
    public void adiciona(Hotel h){
        this.hoteis.put(h.getCodigo(), h.clone());
    }
    
    public List<Hotel> getHoteis1(){
        return this.getHoteis().values().stream().collect(Collectors.toList());
    }
    
    public double valorTotal(){
        return this.hoteis.values().stream().mapToDouble(
            h -> {
                if (h instanceof HotelDiscount){
                    HotelDiscount hs = (HotelDiscount) h;
                    float tmp = hs.getOcupacao();
                    hs.setOcupacao(1); //  1 = 100% -> coloca a ocupação ao máximo para saber o valor total máximo!
                    float t = hs.getQuartosDisponiveis() * hs.getPreco();   //  a setOcupacao(1) vai colocar o preco no máximo, logo é necessário neste caso;
                    hs.setOcupacao(tmp);
                    return t;
                }
                else return h.getQuartosDisponiveis() * h.getPreco();
            }).sum();
    }
    
    public List<CartaoHoteis> daoPontos(){
        List<CartaoHoteis> res = new ArrayList<>();
        
        for(Hotel h : hoteis.values()){
            if(h instanceof CartaoHoteis){
                res.add((CartaoHoteis)(h.clone()));
            }
        }
        return res;
    }
    
    public void adiciona(Set<Hotel> hoteis){
        /*Set<Hotel> tmp = new HashSet(hoteis.size());
        Hotel hotel;
        Iterator<Hotel> it = tmp.iterator();
        
        while(it.hasNext()){
            hotel = it.next();
            this.hoteis.put(hotel.getCodigo(), hotel);
        }
        */
        hoteis.forEach(h -> this.hoteis.put(h.getCodigo(),h));
    }
    
    /*  getSimpleName é vantajoso quando queremos realmente uma só class, pq o instanceof dá true na subclasss e 
     * na superclass, ou seja, se fosse um HotelStandard e um HotelDiscount o instanceof dá true nos dois 
       e no entanto são diferentes, o getSimpleName() vai buscar mesmo o nome da class*/
    public int quantosT(String tipo){
        return (int) this.getHoteis().values().stream().filter(h -> h.getClass().getSimpleName().equals(tipo)).count();
    }
    
    public void mudaPara(){
        this.getHoteis().values().forEach((Hotel h) -> {
            if (h instanceof HotelStandard){ 
                HotelStandard hs = (HotelStandard) h;
                if(hs.getEpoca() == true){
                     hs.setEpoca(false);
                }else{
                    hs.setEpoca(true);
                }
            }
            } );
    }
}   

