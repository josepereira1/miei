
/**
 * Write a description of class Encomenda here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.stream.*;
import java.lang.Float;
import java.lang.Object;

public class Encomenda
{
    private String nome;
    private String nif;
    private String morada;
    private int numEncomenda;
    private ArrayList<LinhaDeEncomenda> linha;
    
    private final int tamanhoInicial = 10;
    
    public Encomenda(){
        this.setNome("");
        this.setNIF("");
        this.setMorada("");
        this.setNumEncomenda(0);
        this.linha = new ArrayList<LinhaDeEncomenda>(tamanhoInicial);
    }
    
    public Encomenda(String nome, String nif, String morada, int numEncomenda, ArrayList<LinhaDeEncomenda> linha){
        this.setNome(nome);
        this.setNIF(nif);
        this.setMorada(morada);
        this.setNumEncomenda(numEncomenda);
        this.setLinha(linha);
    }
    
    public Encomenda(Encomenda umaEncomenda){
        this.setNome(umaEncomenda.getNome());
        this.setNIF(umaEncomenda.getNIF());
        this.setMorada(umaEncomenda.getMorada());
        this.setNumEncomenda(umaEncomenda.getNumEncomenda());
        this.setLinha(umaEncomenda.getLinha());
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getNIF(){
        return this.nif;
    }
    
    public String getMorada(){
        return this.morada;
    }
    
    public int getNumEncomenda(){
        return this.numEncomenda;
    }
    
    public ArrayList<LinhaDeEncomenda> getLinha(){
        ArrayList<LinhaDeEncomenda> tmp = new ArrayList<LinhaDeEncomenda>(this.linha.size());
        tmp.addAll(this.linha);
        return tmp;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setNIF(String nif){
        this.nif = nif;
    }
    
    public void setMorada(String morada){
        this.morada = morada;
    }
    
    public void setNumEncomenda(int numEncomenda){
        this.numEncomenda = numEncomenda;
    }
    
    public void setLinha(ArrayList<LinhaDeEncomenda> linha){
        ArrayList<LinhaDeEncomenda> tmp = new ArrayList<LinhaDeEncomenda>(linha.size());
        tmp.addAll(linha);
        this.linha = tmp;
    }
    
    public Encomenda clone(){
        Encomenda tmp = new Encomenda(this);
        return tmp;
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || this.getClass() != o.getClass())return false;
        
        Encomenda tmp = (Encomenda) o;
        
        return this.getNome().equals(tmp.getNome()) && this.getNIF().equals(tmp.getNIF()) && this.getMorada().equals(tmp.getMorada()) &&
        this.getNumEncomenda() == tmp.getNumEncomenda() &&  this.getLinha().equals(tmp.getLinha());
    }
    
    public String toString(){
        Iterator<LinhaDeEncomenda> it = this.linha.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("Nome:");sb.append(this.getNome());
        sb.append("\nNIF:");sb.append(this.getNIF());
        sb.append("\nMorada:");sb.append(this.getMorada());
        sb.append("\nNum encomendas:\n");sb.append(this.getNumEncomenda());sb.append("\n\n");
        LinhaDeEncomenda elem;
        
        while(it.hasNext()){
            elem = it.next();
            sb.append(elem.toString());
        }
        
        return sb.toString();
    }
    
    public double calculaValorTotal(){
        return this.linha.stream().mapToDouble(LinhaDeEncomenda :: calculaValorLinhaEnc).sum();
    }
    
    public double calculaValorDesconto(){
        return this.linha.stream().mapToDouble(LinhaDeEncomenda :: calculaValorDesconto).sum();
    }
    
    public int numeroTotalProdutos(){
        return this.linha.stream().mapToInt(LinhaDeEncomenda :: getQuantidade).sum();
    }
    
    public boolean existeProdutoEncomenda(String refProduto){
        //return this.linha.stream().anyMatch((LinhaDeEncomenda a)-> {a.getDescricao().equals(refProduto);});
        return this.linha.stream().anyMatch(a-> a.getDescricao().equals(refProduto)); 
    }
    
    public void adicionaLinha(LinhaDeEncomenda linha){
        this.linha.add(linha);
    }
    
    public void removeProduto(String codProd){
        //this.linha.remove(this.linha.stream().filter(a->a.getCodigo() == codProd));
        System.out.println("CODIGO A APAGAR :"+(this.linha.stream().filter(a->a.getCodigo() == codProd)));
        //  isto não está a funcionar!
    }

}
