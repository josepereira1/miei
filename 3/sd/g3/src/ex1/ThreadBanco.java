package ex1;

import java.util.Random;

public class ThreadBanco extends Thread{

    public Banco banco;
    public int id;

    public ThreadBanco(Banco banco, int id){
        this.banco = banco;
        this.id = id;

    }

    public void run(){
        System.out.println("THREAD_ID="+id+" COMEÇOU!!!");
        //Random r = new Random(8);
        //int from = r.nextInt(), to = r.nextInt();
        //System.out.println("From="+from+" To="+to);
        Random r = new Random();
        boolean res = r.nextBoolean();
        System.out.println("TH_ID="+id+" | res:="+res);
        if(res){
            try{
                //System.out.println("TH_ID="+id+" | Valores antes:"+this.banco.toString());
                this.banco.transfer(1,2,50, this.id);
                //System.out.println("TH_ID="+id+" | Valores depois:"+this.banco.toString());
            }catch (NaoDinheiroException e1){
                System.out.println("Não tem dinheiro!");
                e1.printStackTrace();
            }catch (ContaInvalidaException e2){
                System.out.println("Conta inválida!");
                e2.printStackTrace();
            }
        }else{
            int[] ids = {1,2,3};
            //System.out.println("Valores para balanço="+this.banco);
            System.out.println("TH_RD="+id+" | balanco="+this.banco.totalBalance(ids,this.id));
        }
    }


}
