
/**
 * Escreva a descrição da classe HotelInexistente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class HotelInexistente extends Exception
{
    public HotelInexistente(){
        super();
    }
    
    public HotelInexistente(String msg){
        super(msg);
    }
    
    /*
    Como é que se implementa as Exceptions nos métodos onde vão ser precisas.
    As Exceptions deve ser tratadas no main();
    public class A{
        public void metodoB(...) throws ExA,ExB ...{
            ...
            Throw new ExA(...);
        }
    }
    
    Em métodos que usem o método acima, eu tenho que fazer throws das Exceptions que ele chama.
    public void metodoC(...) throws ExA,ExB,...{
        metodoB(...);
    }
    isto é feito no main:
    try{
        x.metodoC(...);
    }catch (ExA e ){
        e.printStackTrace());
    }
    */
}
