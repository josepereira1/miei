
/**
 * Escreva a descrição da classe EncomendaSemArrayList aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class EncomendaSemArrayList
{
    private String nome;
    private String nif;
    private String morada;
    private int numEncomenda;
    private LinhaDeEncomenda[] linha;
    
    private int tamanhoInicial = 10;
    

    public EncomendaSemArrayList(){
    this.nome = "";
    this.nif = "";
    this.morada = "";
    this.numEncomenda = 0;
    this.linha = new LinhaDeEncomenda[tamanhoInicial];
    }
    
    public EncomendaSemArrayList(String nome, String nif, String morada, int numEncomenda, LinhaDeEncomenda[] linha, int tamanho){
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.numEncomenda = numEncomenda;
        this.linha = linha;
        
    }
    
    public EncomendaSemArrayList(EncomendaSemArrayList umaEncomenda){
       this.nome = umaEncomenda.getNome();
       this.nif = umaEncomenda.getNif();
       this.morada = umaEncomenda.getMorada();
       this.numEncomenda = umaEncomenda.getNumEncomenda();
       this.linha = umaEncomenda.getLinha();
       this.tamanhoInicial = umaEncomenda.getTamanhoInicial();
    
    }
    
    public String getNome(){
        return this.nome;
    }
    
    
    public String getNif(){
        return this.nif;
    }
    
    
    public String getMorada(){
        return this.morada;
    }
    
    
    public int getNumEncomenda(){
        return this.numEncomenda;
    }
    
    //nos slides o exemplo do professor, ele colocou este método que está relacionado com outra classe, em private.
    private LinhaDeEncomenda[] getLinha(){
        return this.linha;
    }
    
    
    public int getTamanhoInicial(){
        return this.tamanhoInicial;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setNif(String nif){
        this.nif = nif;
    }
    
    public void setMorada(String Morada){
        this.morada = morada;
    }
    
    public void setNumEncomenda(int numEncomenda){
        this.numEncomenda = numEncomenda;
    }
    
    public void setLinha(LinhaDeEncomenda linha){
         
    }
    
    public EncomendaSemArrayList clone(){
        EncomendaSemArrayList encomenda = new EncomendaSemArrayList(this);
        return encomenda;
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || (this.getClass() != o.getClass()))return false;
        
        EncomendaSemArrayList enc = (EncomendaSemArrayList) o;
        
        return(this.nome.equals(enc.getNome()) && this.nif.equals(enc.getNif()) 
        && this.morada.equals(enc.getMorada()) && this.numEncomenda == enc.getNumEncomenda() 
        && this.linha.equals(enc.getLinha()));
    }

}
