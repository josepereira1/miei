package Ex4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Conta[] contas;

    public Banco(Map<Integer,Conta> contas, int saldo){
        this.contas = new Conta[10];
    }

    public Banco(){
        for(int i = 0; i < 10; i++)
            this.contas[i].setSaldo(0);
    }

    public Conta[] getContas(){
        return this.contas;
    }

    public void setContas(Conta[] contas){
        this.contas = contas;
    }

    /*public void transferir(int valor, int src, int dest) {
        synchronized (this.contas.get(src)) {           //  assim estamos apenas a fazer syncronized das contas específicas;
            synchronized (this.contas.get(dest)) {      //  ao invés de ter o syncronized no método, pois assim estou a bloquear
                this.contas.get(src).credito(valor);    //  o banco só para mim, logo a melhor forma é bloquear cada conta origem e destino;
                this.contas.get(dest).debito(valor);    //  quando faço syncronized de um objeto, ele é meu, ninguém pode modificar antes de mim;
            }                                           //  a razão pela qual fizemos isto foi, pq como tinhamos antes, apesar de termos syncronized
                                                        // nos métodos debito e credito, eu quando entrava no tranferir fazia o método credito
        }                                               //  por exemplo, ele bloqueava a conta, mas quando depois queria fazer o debito
    }*/                                                 //  na outra conta, ela poderia estar bloqueda por outro método, então para isso
                                                        //  bloquea-se ambos os objetos simultâneamente, garantido assim a transferência
                                                        // das contas, "sem ninguém se meter no meio", MAS ISTO FUNCIONA MAL MESMO ASSIM!!!;
    /*
    * o código antes tem falhas, então a solução é a seguinte;
    * o erro que acontece no programa anterior é que quando há transferência de uma conta i para j e simultâneamente outra de j para i
    * ocorre o erro em que cada Thread vai bloquear a origem , logo quando eles tentarem obter
    * o destino, ele vai estar bloqueado, e ficam suspensos para sempre (DEADLOCK)
    * */

    /*
    *   então o programa seguinte funciona assim:
    *
    *           T1  origem = 5, destino = 10            T2  origem = 10, origem = 5
    *           |                                       |
    *           | 5 check                               | 5 uncheck (este vai buscar o menor, ou seja, o 5, mas não vai conseguir
    *           |                                       | mas não vai conseguir pq a T1 já bloqueou e fica à espera)
    *           |                                       | (espera ...)
    *           |                                       |
    *           |                                       |
    *           |                                       |
    *           |10 check(pode pq a T2 não bloqueia     | (espera ...)
    *           |         esta)
    * */
    public void transferir(int valor, int src, int dest){
        int i = src < dest ? src:dest;  //  menor
        int j = src < dest ? dest:src;  //  maior
        synchronized (this.contas[i]){
            synchronized (this.contas[j]){
                this.contas[src].credito(valor);
                this.contas[dest].debito(valor);
            }
        }
    }


    public void credito(int valor, int id){ //  não precisamos de ter syncronized aqui, pq assim estamos a "preder" o banco, e não é isso que queremos;
        this.contas[id].credito(valor);
    }

    public void debito(int valor, int id){  //  o mesmo se aplica ao debito;
        this.contas[id].debito(valor);

    }

    @Override
    public String toString() {
        return "Banco{" +
                "contas=" + Arrays.toString(contas) +
                '}';
    }
}
