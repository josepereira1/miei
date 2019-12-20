
/**
 * Escreva a descrição da classe HotelStandard aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class HotelStandard extends Hotel implements CartaoHoteis
{
    private boolean epoca;
    private int pontos;
    
    public HotelStandard(){
        super();
        this.setEpoca(true);
    }
    
    public HotelStandard(String codigo, String nome, String localidade, int categoria, int quartosDisponiveis, float preco, boolean epoca){
        super(codigo, nome, localidade, categoria, quartosDisponiveis, preco);
        this.setEpoca(epoca);
    }
    
    public HotelStandard(HotelStandard umHotel){
        super(umHotel);
        this.setEpoca(umHotel.getEpoca());
    }
    
    public boolean getEpoca(){
        return this.epoca;
    }
    
    public int getPontos(){
        return this.pontos;
    }
    
    public void setEpoca(boolean epoca){
        this.epoca = epoca;
    }
    
    public void setPontos(int pontos){
        this.pontos = pontos;
    }
    
    public HotelStandard clone(){
        return new HotelStandard(this);
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || this.getClass() != o.getClass())return false;
        
        HotelStandard hotel = (HotelStandard) o;
        
        return this.equals(hotel) && this.getEpoca() == hotel.getEpoca();
    }
    
    
}
