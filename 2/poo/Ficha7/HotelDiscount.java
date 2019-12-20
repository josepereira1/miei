
/**
 * Escreva a descrição da classe HotelDiscount aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class HotelDiscount extends HotelStandard
{
    private float ocupacao;
    private static final int maxPreco = 100;
    
    public HotelDiscount(){
        super();
        this.setOcupacao(0);
    }
    
    public HotelDiscount(String codigo, String nome, String localidade, int categoria, int quartosDisponiveis, float preco, boolean epoca, float ocupacao){
        super(codigo, nome, localidade, categoria, quartosDisponiveis, preco, epoca);
        this.setOcupacao(ocupacao);
    }
    
    public HotelDiscount(HotelDiscount umHotel){
        super(umHotel);
        this.setOcupacao(umHotel.getOcupacao());
    }
    
    public float getOcupacao(){
        return this.ocupacao;
    }
    
    public void setOcupacao(float ocupaca){
        this.ocupacao = ocupacao;
        this.setPreco(maxPreco);
    }
    
    public HotelDiscount clone(){
        return new HotelDiscount(this);
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || this.getClass() != o.getClass())return false;
        
        HotelDiscount hotel = (HotelDiscount) o;
        
        return this.equals(hotel) && this.getOcupacao() == hotel.getOcupacao();
    }
}
