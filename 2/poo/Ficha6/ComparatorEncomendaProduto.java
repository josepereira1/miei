import java.util.Map;
import java.util.TreeSet;
import java.util.Comparator;

/**
 * Write a description of class ComparatorEncomendaProduto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ComparatorEncomendaProduto implements Comparator<Encomenda>
{
    public int compare(Encomenda e1, Encomenda e2){
        if(e1.numeroTotalProdutos() >= e2.numeroTotalProdutos()){
            return -1;
        }else{
            return 1;
        }
    }
}
