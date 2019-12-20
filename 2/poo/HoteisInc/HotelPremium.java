public class HotelPremium extends Hotel implements CartaoHoteis{
    
    private double taxaLuxo;
    private int pontosPorEuro;
    
    public HotelPremium(){
        super();
        setTaxaLuxo(0);
        setPontosPorEuro(2);
    }
    
    public HotelPremium(String id, String nome, String localidade, int categoria, int numero_de_quartos, int preco_por_quarto, int pontosPorEuro, double taxaLuxo){
        super(id, nome, localidade, categoria, numero_de_quartos, preco_por_quarto);
        setTaxaLuxo(taxaLuxo);
        setPontosPorEuro(pontosPorEuro);
    }
    
    public HotelPremium(HotelPremium umHotelPremium){
        super(umHotelPremium);
        this.taxaLuxo = umHotelPremium.getTaxaLuxo();
        this.pontosPorEuro = umHotelPremium.getPontosPorEuro();
    }
    
    public double getTaxaLuxo(){
        return this.taxaLuxo;
    }
    
    public int getPontosPorEuro(){
        return this.pontosPorEuro;
    }
    
    public void setTaxaLuxo(double taxaLuxo){
        this.taxaLuxo = taxaLuxo;
        super.setPreco_por_quarto(super.getPreco_por_quarto() * this.taxaLuxo);
    }
    
    public void setPontosPorEuro(int x){
        this.pontosPorEuro = 2;
    }
    
    public HotelPremium clone(){
        return new HotelPremium(this);
    }
    
    public boolean equals(Object o){
        
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        
        HotelPremium umHotelPremium = (HotelPremium) o;
        
        return super.equals(umHotelPremium) && 
               this.taxaLuxo == umHotelPremium.getTaxaLuxo();
    }
    
    public String toString(){
        
        final StringBuilder sb = new StringBuilder("HotelPremium{");
        
        sb.append("id=").append(getId()).append(", ");
        sb.append("nome=").append(getNome()).append(", ");
        sb.append("localidade=").append(getLocalidade()).append(", ");
        sb.append("categoria=").append(getCategoria()).append(", ");
        sb.append("numero_de_quartos=").append(getNumero_de_quartos()).append(", ");
        sb.append("preco_por_quarto=").append(getPreco_por_quarto()).append(", ");
        sb.append("taxaLuxo=").append(this.taxaLuxo).append("}");
        
        return sb.toString();
    }

}
