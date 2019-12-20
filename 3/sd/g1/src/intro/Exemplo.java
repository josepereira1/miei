package intro;

public class Exemplo extends Thread {

    /*
    Temos que definir sempre o método run()
    Quando criamos um instância do tipo exemplo,
    não estamos a criar um Thread, só quando invocarmos o método start().
     */

    private int x;

    public Exemplo(int x){
        super();
        this.x = x;
    }

    public void run(){
        for(int i = 0; i < this.x; i++){
            System.out.println(i);
        }
    }
}
