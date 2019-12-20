import java.util.Comparator;
/**
 * Write a description of class ComparatorEnomendaValor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ComparatorEnomendaValor implements Comparator<Encomenda>
{
    public int compare(Encomenda e1, Encomenda e2){
        
        if(e1.numeroTotalEncomendas() >= e2.numeroTotalEncomendas()){
            return -1;
        }else{
            return 1;
        }
    }
}
