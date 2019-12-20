import java.time.LocalDate;
import java.util.Arrays;
import java.lang.Long;
import java.time.temporal.ChronoUnit;
/**
 * Escreva a descrição da classe Datas aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Datas
{
    private LocalDate[] ldatas;
    private int ocupados;
    
    public Datas(){
    ldatas = new LocalDate[10];
    ocupados = 0;
    }
    public Datas(LocalDate[] datas, int ocu){
    ldatas = datas;
    ocupados = ocu;
    }
    
    //exercicio 3_a:
    public void insereData(LocalDate d){
        if(ocupados < ldatas.length)
        ldatas[ocupados++]=d;
    }
    //exercicio 3_b:
    public LocalDate dataMaisProxima (LocalDate data){
    long min = Long.MAX_VALUE;
    if(ocupados == 0)return null;   // se nao tiver nenhum data no array, n posso comparar nada, logo retorno NULL;
    int pos = 0;
    
    for(int i = 0; i < ocupados; i++){
    long dist = ldatas[i].until(data,ChronoUnit.DAYS);
        if(dist < min){
            min = dist;
            pos = i;
        }
    }
    return ldatas[pos];
    }
    //exercicio 3_c:
    public String toString(){
    return Arrays.toString(Arrays.copyOfRange(ldatas, 0,ocupados)); // copia desde a posiçao zero ate a posiçao ocupados;
    }
}
