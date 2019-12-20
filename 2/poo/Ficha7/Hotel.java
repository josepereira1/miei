
/**
 * Escreva a descrição da classe Hotel aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public abstract class Hotel
{
    private String codigo;
    private String nome;
    private String localidade;
    private int categoria;
    private int quartosDisponiveis;
    private float preco;
    
    public Hotel(){
        this.setCodigo("");
        this.setNome("");
        this.setLocalidade("");
        this.setCategoria(0);
        this.setQuartosDisponiveis(0);
        this.setPreco(0);
    }
    
    public Hotel(String codigo, String nome, String localidade, int categoria, int quartosDisponiveis, float preco){
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setLocalidade(localidade);
        this.setCategoria(categoria);
        this.setQuartosDisponiveis(quartosDisponiveis);
        this.setPreco(preco);
    }
    
    public Hotel(Hotel umHotel){
        this.setCodigo(umHotel.getCodigo());
        this.setNome(umHotel.getNome());
        this.setLocalidade(umHotel.getLocalidade());
        this.setCategoria(umHotel.getCategoria());
        this.setQuartosDisponiveis(umHotel.getQuartosDisponiveis());
        this.setPreco(umHotel.getPreco());
    }
    
    public String getCodigo(){
        return this.codigo;
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
    
    public int getQuartosDisponiveis(){
        return this.quartosDisponiveis;
    }
    
    public float getPreco(){
        return this.preco;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
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
    
    public void setQuartosDisponiveis(int quartosDisponiveis){
        this.quartosDisponiveis = quartosDisponiveis;
    }
    
    public void setPreco(float preco){
        this.preco = preco;
    }
    
    public boolean equals(Object o){
        if(this == o) return true;
        
        if(o == null || o.getClass() != this.getClass()) return false;
        
        Hotel obj = (Hotel) o;
        
        return this.getCodigo().equals(obj.getCodigo()) && this.getNome().equals(obj.getNome()) &&
        this.getLocalidade().equals(obj.getLocalidade()) && this.getCategoria() == obj.getCategoria() && 
        this.getQuartosDisponiveis() == obj.getQuartosDisponiveis() && this.getPreco() == obj.getPreco();
    }
    
    //public abstract String toString();
    public abstract Hotel clone();
}
