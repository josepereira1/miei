public class HotelDiscount extends HotelStandard{
    
    private double ocupacao;

    public HotelDiscount(){
        super();
        setOcupacao(0);
    }
    
    public HotelDiscount(String id, String nome, String localidade, int categoria, int numero_de_quartos, int preco_por_quarto, boolean epoca, int pontosPorEuro, double ocupacao){
        super(id, nome, localidade, categoria, numero_de_quartos, preco_por_quarto, epoca, pontosPorEuro);
        setOcupacao(ocupacao);
    }
    
    public HotelDiscount(HotelDiscount umHotelDiscount){
        super(umHotelDiscount);
        this.ocupacao = umHotelDiscount.getOcupacao();
    }
    
    public double getOcupacao(){
        return this.ocupacao;
    }
    
    public void setOcupacao(double ocupacao){
        this.ocupacao = ocupacao;
        setPreco_por_quarto(this.ocupacao); // falta implementar a taxa linear...
    }
    
    public HotelDiscount clone(){
        return new HotelDiscount(this);
    }
   
    
    public boolean equals(Object o){
        
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        
        HotelDiscount umHotelDiscount = (HotelDiscount) o;
        
        return super.equals(umHotelDiscount) && 
               this.ocupacao == umHotelDiscount.getOcupacao();
    }
    
    public String toString(){
        
        final StringBuilder sb = new StringBuilder("HotelDiscount{");
        
        sb.append("id=").append(getId()).append(", ");
        sb.append("nome=").append(getNome()).append(", ");
        sb.append("localidade=").append(getLocalidade()).append(", ");
        sb.append("categoria=").append(getCategoria()).append(", ");
        sb.append("numero_de_quartos=").append(getNumero_de_quartos()).append(", ");
        sb.append("preco_por_quarto=").append(getPreco_por_quarto()).append(", ");
        sb.append("Ocupacao=").append(this.ocupacao).append("}");
        
        return sb.toString();
    }


}
