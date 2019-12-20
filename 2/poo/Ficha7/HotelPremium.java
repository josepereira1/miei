
/**
 * Escreva a descrição da classe HotelPremium aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class HotelPremium extends Hotel implements CartaoHoteis
{
    private float taxaDeLuxo;
    private int pontos;
    
    public HotelPremium(){
        super();
        this.setTaxaDeLuxo(0);
    }
    
    public HotelPremium(String codigo, String nome, String localidade, int categoria, int quartosDisponiveis, float preco, float taxaDeLuxo){
        super(codigo, nome, localidade, categoria, quartosDisponiveis, preco);
        this.setTaxaDeLuxo(taxaDeLuxo);
    }
    
    public HotelPremium(HotelPremium umHotel){
        super(umHotel);
        this.setTaxaDeLuxo(umHotel.getTaxaDeLuxo());
    }
    
    public float getTaxaDeLuxo(){
        return this.taxaDeLuxo;
    }
    
    public int getPontos(){
        return this.pontos;
    }
    
    public void setTaxaDeLuxo(float taxaDeLuxo){
        this.taxaDeLuxo = taxaDeLuxo;
    }
    
    public void setPontos(int pontos){
        this.pontos = pontos;
    }
    
    public HotelPremium clone(){
        return new HotelPremium(this);
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || this.getClass() != o.getClass())return false;
        
        HotelPremium hotel = (HotelPremium) o;
        
        return this.equals(hotel) && this.getTaxaDeLuxo() == hotel.getTaxaDeLuxo();
    }
}
