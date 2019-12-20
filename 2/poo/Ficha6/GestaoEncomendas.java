import java.util.Map;
import java.util.TreeSet;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Write a description of class GestaoEncomendas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GestaoEncomendas
{
    private Map<Integer, Encomenda> gl;
    
    public Integer EncomendaComMaisProdutos(){
        TreeSet <Encomenda> r = new TreeSet<>(new ComparatorEncomendaProduto());
        gl.values().forEach(e->r.add(e));
        return r.first().getNumEncomenda();
    }
    
    //  execício 4 f):
    public Set<Integer> encomendasComProduto(String cod){
        return gl.values().stream().filter(e-> e.existeProdutoEncomenda(cod)).map(Encomenda :: getNumEncomenda).collect(Collectors.toSet());
        //  values -> vai buscar os valores do Map (estrutura), na parte direita!, ou seja, neste caso Encomenda;
    }
    
    //  execício 4 h):
    public Set<Encomenda> EncomendaValorDecrescente(){
        TreeSet<Encomenda> res = new TreeSet<>(new ComparatorEnomendaValor());
        gl.values().forEach(l->res.add(l.clone()));
        return res;
    }
    
    //  execício 4 i):
    public Map<String,List<String>> encomendasDeProduto(){
        Map<String,List<String>> res = new HashMap<>();
        for(Encomenda e: gl.values()){
            for(LinhaDeEncomenda le: e.getLinha()){
                String cp = le.getCodigo();
                if(res.containsKey(cp)){
                    res.put(cp,new ArrayList<String>());
                }
                res.get(cp).add(e.getNumEncomenda());
            }
        }
        return res;
    }
    
}
