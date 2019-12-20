
/**
 * Write a description of class LinhaDeEncomenda here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinhaDeEncomenda
{
    private String codigo;
    private String descricao;
    private double preco;
    private int quantidade;
    private double iva;
    private double desconto;
    
    public LinhaDeEncomenda(){
    this.setCodigo("");
    this.setDescricao("");
    this.setPreco(0);
    this.setQuantidade(0);
    this.setIVA(0);
    this.setDesconto(0);
    }
    
    public LinhaDeEncomenda(String codigo, String descricao, double preco, int quantidade, double iva, double desconto){
    this.setCodigo(codigo);
    this.setDescricao(descricao);
    this.setPreco(preco);
    this.setQuantidade(quantidade);
    this.setIVA(iva);
    this.setDesconto(desconto);
    }
    
    public LinhaDeEncomenda(LinhaDeEncomenda umaEncomenda){
    this.setCodigo(umaEncomenda.getCodigo());
    this.setDescricao(umaEncomenda.getDescricao());
    this.setPreco(umaEncomenda.getPreco());
    this.setQuantidade(umaEncomenda.getQuantidade());
    this.setIVA(umaEncomenda.getIVA());
    this.setDesconto(umaEncomenda.getDesconto());
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public double getIVA(){
        return this.iva;
    }
    
    public double getDesconto(){
        return this.desconto;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public void setDescricao(String descricao ){
        this.descricao = descricao;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public void setIVA(double iva){
        this.iva = iva;
    }
    
    public void setDesconto(double desconto){
        this.desconto = desconto;
    }
    
    public boolean equals(Object o){
        if(this == o) return true;
        
        if(o == null || (this.getClass() != o.getClass()))return false;
        
        LinhaDeEncomenda umaEncomenda = (LinhaDeEncomenda) o;
        
        return(this.getCodigo().equals(umaEncomenda.getCodigo()) &&
        this.getDescricao().equals(umaEncomenda.getDescricao()) &&
        this.getPreco() == umaEncomenda.getPreco() &&
        this.getQuantidade() == umaEncomenda.getQuantidade() &&
        this.getIVA() == umaEncomenda.getIVA() &&
        this.getDesconto() == umaEncomenda.getDesconto());
    }
    
    public LinhaDeEncomenda clone(){
        LinhaDeEncomenda encomenda = new LinhaDeEncomenda(this);
        return encomenda;
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("codigo=").append(this.getCodigo()).append("\n");
        str.append("descricao=").append(this.getDescricao()).append("\n");
        str.append("preco=").append(this.getPreco()).append("\n");
        str.append("quantidade=").append(this.getQuantidade()).append("\n");
        str.append("iva=").append(this.getIVA()).append("\n");
        str.append("desconto=").append(this.getDesconto()).append("\n");
        
        return str.toString();
    }
    //exercício 7_b:
    public double calculaValorLinhaEnc(){
        return this.getQuantidade()*(this.getPreco() * (1-this.getDesconto()) * (1 + this.getIVA()));
    }
    //exercício 7_c:
    public double calculaValorDesconto(){
        return this.getPreco()*this.getDesconto();
    }
}