public abstract class Hotel implements Comparable<Hotel>{
    
    private String id;
    private String nome;
    private String localidade;
    private int categoria;
    private int numero_de_quartos;
    private double preco_por_quarto;

    public Hotel(){
        setId("");
        setNome("");
        setLocalidade("");
        setCategoria(0);
        setNumero_de_quartos(0);
        setPreco_por_quarto(0);
    }
    
    public Hotel(String id, String nome, String localidade, int categoria, int numero_de_quartos, int preco_por_quarto){ 
        setId(id);
        setNome(nome);
        setLocalidade(localidade);
        setCategoria(categoria);
        setNumero_de_quartos(numero_de_quartos);
        setPreco_por_quarto(preco_por_quarto);
    }
    
    public Hotel(Hotel umHotel){
        setId(umHotel.getId());
        setNome(umHotel.getNome());
        setLocalidade(umHotel.getLocalidade());
        setCategoria(umHotel.getCategoria());
        setNumero_de_quartos(umHotel.getNumero_de_quartos());
        setPreco_por_quarto(umHotel.getPreco_por_quarto());
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getLocalidade(){
        return this.localidade;
    }
    
    public int getCategoria(){
        return this.categoria;
    }
    
    public int getNumero_de_quartos(){
        return this.numero_de_quartos;
    }
    
    public double getPreco_por_quarto(){
        return this.preco_por_quarto;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setLocalidade(String localidade){
        this.localidade = localidade;
    }
    
    public void setCategoria(int categoria){
        this.categoria = categoria;
    }
    
    public void setNumero_de_quartos(int numero_de_quartos){
        this.numero_de_quartos = numero_de_quartos;
    }
    
    public void setPreco_por_quarto(double preco_por_quarto){
        this.preco_por_quarto = preco_por_quarto;
    }
    
    public abstract Hotel clone();
    
    public boolean equals(Object o){
        
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Hotel umHotel = (Hotel) o;
        return this.id.equals(umHotel.getId()) &&
        this.nome.equals(umHotel.getNome()) &&
        this.localidade.equals(umHotel.getLocalidade()) &&
        this.categoria == umHotel.getCategoria() &&
        this.numero_de_quartos == umHotel.getNumero_de_quartos() &&
        this.preco_por_quarto == umHotel.getPreco_por_quarto(); 
    }
    
    public abstract String toString();
    
    public int compareTo(Hotel h){
        String cod = h.getId();
        if (cod.compareTo(this.id) == 0) return 0;
        else if (cod.compareTo(this.id) > 0) return -1;
        else return 1;
    }   
}
