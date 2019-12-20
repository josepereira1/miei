public class HotelStandard extends Hotel implements CartaoHoteis{
    
    private boolean epoca;
    private int pontosPorEuro;
    
    public HotelStandard(){  
        super();
        setEpoca(false);
        setPontosPorEuro(1);
    }
    
    public HotelStandard(String id, String nome, String localidade, int categoria, int numero_de_quartos, int preco_por_quarto, boolean epoca, int pontosPorEuro){
        super(id, nome, localidade, categoria, numero_de_quartos, preco_por_quarto);
        setEpoca(epoca);
        setPontosPorEuro(pontosPorEuro);
    }
    
    public HotelStandard(HotelStandard umHotelStandard){
        super(umHotelStandard);
        this.epoca = umHotelStandard.getEpoca();
        this.pontosPorEuro = umHotelStandard.getPontosPorEuro();
    }
    
    public boolean getEpoca(){
        return this.epoca;
    }
    
    public int getPontosPorEuro(){
        return this.pontosPorEuro;
    }
    
    public void setEpoca(boolean epoca){
        this.epoca = epoca;
        if (this.epoca == true) super.setPreco_por_quarto( super.getPreco_por_quarto() + 20);
        else super.setPreco_por_quarto( super.getPreco_por_quarto() - 20);
    }
    
    public void setPontosPorEuro(int x){
        this.pontosPorEuro = x;
    }
    
    public HotelStandard clone(){
        return new HotelStandard(this);
    }
    
    public boolean equals(Object o){
        
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        
        HotelStandard umHotelStandard = (HotelStandard) o;
        
        return super.equals(umHotelStandard) && 
               this.epoca == umHotelStandard.getEpoca();
    }
    
    public String toString(){
        
        final StringBuilder sb = new StringBuilder("HotelStandard{");
        
        sb.append("id=").append(getId()).append(", ");
        sb.append("nome=").append(getNome()).append(", ");
        sb.append("localidade=").append(getLocalidade()).append(", ");
        sb.append("categoria=").append(getCategoria()).append(", ");
        sb.append("numero_de_quartos=").append(getNumero_de_quartos()).append(", ");
        sb.append("preco_por_quarto=").append(getPreco_por_quarto()).append(", ");
        sb.append("epoca=").append(this.epoca).append("}");
        
        return sb.toString();
    }
}