package ex1;

import java.util.Random;

public class MinhaThread extends Thread{
    BoundedBuffer bf;
    int idThread;

    public MinhaThread(BoundedBuffer bf, int idThread){
        this.bf = bf;
        this.idThread = idThread;
    }

    public void run(){
        Random r = new Random();
        if(r.nextBoolean()){
            System.out.println("TH:"+idThread+"Vou fazer um get()!");
            bf.get();
            System.out.println("idThread="+this.idThread+":"+bf.toString());
        }else{
            System.out.println("TH:"+idThread+"Vou fazer um put()!");
            bf.put(r.nextInt());
            System.out.println("idThread="+this.idThread+":"+bf.toString());
        }
        System.out.println("idThread="+this.idThread+":"+bf.toString());
    }
}
