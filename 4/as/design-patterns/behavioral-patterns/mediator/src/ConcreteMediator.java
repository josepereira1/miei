import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    List<Colleague> colleagues;

    public ConcreteMediator(){
        this.colleagues = new ArrayList<>();
    }

    //  utilizou-se o nome das classes para saber o destino
    public void send(String destination, String msg){
        String str = "class ";  //  str deve-se ao facto de c.getClass().toString() retornar "class Colleague2", logo temos que adicionar o "class "
        for(Colleague c : colleagues){
            if(c.getClass().toString().equals(str+destination)){
                c.receive(msg);
            }
        }
    }

}
