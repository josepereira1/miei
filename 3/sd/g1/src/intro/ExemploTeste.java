package intro;

import intro.Exemplo;
import intro.Exemplo2;

public class ExemploTeste {
    public static void main(String[] args){
        Exemplo ex = new Exemplo(10);
        ex.start();
        //  isto é o que inicializa a Thread e executa o código que está no run();

        Exemplo2 ex2 = new Exemplo2(10);
        //ex2.start();
        //  não posso fazer isto pq a interface runnable n tem o método start();
        //  Então para contronar este problema, cria-se um Thread, enviando o
        //  nosso objeto como argumento;
        Thread t = new Thread(ex2);
        t.start();
        try{
            t.join();
            //  esperar pela morte desta thread, tal como o wait() em C;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
