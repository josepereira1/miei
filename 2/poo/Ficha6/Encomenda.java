
/**
 * Write a description of class Encomenda here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Iterator;

public class Encomenda
{
    private String nome;
    private String nif;
    private String morada;
    private int numEncomenda;
    private ArrayList<LinhaDeEncomenda> linha;
    private LocalDate data;
    
    public Encomenda(){
    this.nome = "";
    this.nif = "";
    this.morada = "";
    this.numEncomenda = 0;
    this.linha = new ArrayList<LinhaDeEncomenda>();
    }
    
    public Encomenda(String nome, String nif, String morada, int numEncomenda, ArrayList<LinhaDeEncomenda> linha, int tamanho){
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.numEncomenda = numEncomenda;
        this.linha= new ArrayList<LinhaDeEncomenda>(linha.size());
        this.setLinha(linha);   //  aqui não fazemos this.linha.setLinha(linha), pq o método setLinha(linha) 
                                //  não é um método da variável de instância, mas sim do objeto da encomenda;
        
    }
    
    public Encomenda(Encomenda umaEncomenda){
       this.nome = umaEncomenda.getNome();
       this.nif = umaEncomenda.getNif();
       this.morada = umaEncomenda.getMorada();
       this.numEncomenda = umaEncomenda.getNumEncomenda();
       this.linha = umaEncomenda.getLinha();
    
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
    private ArrayList <LinhaDeEncomenda> getLinha(){
        return this.linha;
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
    
    public void setLinha(ArrayList<LinhaDeEncomenda> linha){
        /*
        for(LinhaDeEncomenda le: linha){
            this.linha.add(le.clone());
        }*/
        
        this.linha = new ArrayList<>(linha.size());
        
         for(Iterator <LinhaDeEncomenda> it = linha.iterator(); it.hasNext(); ){
            LinhaDeEncomenda encomenda = it.next();
            this.linha.add(encomenda.clone());
        
        }
    }
    
    public Encomenda clone(){
        Encomenda encomenda = new Encomenda(this);
        return encomenda;
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || (this.getClass() != o.getClass()))return false;
        
        Encomenda enc = (Encomenda) o;
        
        return(this.nome.equals(enc.getNome()) && this.nif.equals(enc.getNif()) 
        && this.morada.equals(enc.getMorada()) && this.numEncomenda == enc.getNumEncomenda() 
        && this.linha.equals(enc.getLinha()));
    }
    
    public double calculaValorDesconto(){
    
    return 1;
    }

}
