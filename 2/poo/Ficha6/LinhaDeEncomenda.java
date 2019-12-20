
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
    this.codigo = "";
    this.descricao = "";
    this.preco = 0;
    this.quantidade = 0;
    this.iva = 0;
    this.desconto = 0;
    }
    
    public LinhaDeEncomenda(String codigo, String descricao, double preco, int quantidade, double iva, double desconto){
    this.codigo = codigo;
    this.descricao = descricao;
    this.preco = preco;
    this.quantidade = quantidade;
    this.iva = iva;
    this.desconto = desconto;
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
    
    public LinhaDeEncomenda(LinhaDeEncomenda umaEncomenda){
    this.codigo = umaEncomenda.getCodigo();
    this.descricao = umaEncomenda.getDescricao();
    this.preco = umaEncomenda.getPreco();
    this.quantidade = umaEncomenda.getQuantidade();
    this.iva = umaEncomenda.getIVA();
    this.desconto = umaEncomenda.getDesconto();
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
        
        LinhaDeEncomenda umaEncomenda = (LinhaDeEncomenda)o;
        
        return(this.codigo.equals(umaEncomenda.getCodigo()) &&
        this.descricao.equals(umaEncomenda.getDescricao()) &&
        this.preco == umaEncomenda.getPreco() &&
        this.quantidade == umaEncomenda.getQuantidade() &&
        this.iva == umaEncomenda.getIVA() &&
        this.desconto == umaEncomenda.getDesconto());
    }
    
    public LinhaDeEncomenda clone(){
        LinhaDeEncomenda encomenda = new LinhaDeEncomenda(this);
        return encomenda;
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("codigo=").append(this.codigo).append("\n");
        str.append("descricao=").append(this.descricao).append("\n");
        str.append("preco=").append(this.preco).append("\n");
        str.append("quantidade=").append(this.quantidade).append("\n");
        str.append("iva=").append(this.iva).append("\n");
        str.append("desconto=").append(this.desconto).append("\n");
        
        return str.toString();
    }
    //exercício 7_b:
    public double calculaValorLinhaEnc(){
        return this.getPreco() * (1-this.getDesconto()) * (1 + this.getIVA());
    }
    //exercício 7_c:
    public double calculaValorDesconto(){
        return this.getPreco()*this.getDesconto();
    }
}
