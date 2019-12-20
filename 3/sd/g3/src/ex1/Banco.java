package ex1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private Map<Integer,Conta> contas;
    private int lastId;
    public ReentrantLock l = new ReentrantLock();

    public Banco(){
        this.lastId = 0;
        this.contas = new HashMap<Integer, Conta>();
    }

    public Banco(Map<Integer,Conta> contas){
        this.contas = contas;
    }

    public int createAccount(float initialBalance){
        try {
            l.lock();
            //System.out.println("FIZ LOCK DO BANCO!!!!");
            Conta conta = new Conta(initialBalance, this.lastId);
            this.contas.put(this.lastId, conta);
            this.lastId++;
            return conta.getId();
        }finally {
            l.unlock();
        }
    }
    public float closeAccount(int id) throws ContaInvalidaException{
        try{
            l.lock();
            //System.out.println("FIZ LOCK DO BANCO!!!!");
            if(!this.contas.containsKey(id)) throw new ContaInvalidaException(String.valueOf(id));
            float valor = this.contas.get(id).getSaldo();
            this.contas.remove(id);
            return valor;
        }finally {
            l.unlock();
        }
    }

    public void transfer(int from, int to, float amount, int idThread) throws ContaInvalidaException, NaoDinheiroException{
        Set<Conta> contasOrdenadas = new TreeSet<Conta>();

        l.lock();   //  lock do Banco
        System.out.println("idThread="+idThread+" - FIZ LOCK DO BANCO!!!!");

        if(!this.contas.containsKey(from) || !this.contas.containsKey(to))throw new ContaInvalidaException(String.valueOf(from)+String.valueOf(to));

        Conta contaFrom = contas.get(from);Conta contaTo = contas.get(to);

        contasOrdenadas.add(contaFrom);contasOrdenadas.add(contaTo);

        /**
         * neste caso não é necessariamente obrigatório, mas vamos fazer os locks de forma ordenada por algum critério num Set<Conta>
         * para garantir que faço sempre os locks pela mesma ordem.
         */
        for(Conta c : contasOrdenadas)
            c.rl.lock();    //  aqui estou a fazer lock de forma ordenada

        System.out.println("Contas da transferência="+contasOrdenadas.toString());
        /**
         * Aqui conseguimos ver a grande vantagem de ter o ReentrantLock como
         * variável public, pois permite fazer locks exteriormente à class Conta, isto trás vantangem,
         * pq posso fazer unlock do banco, depois de fazer lock às contas que interessam neste método, reduzindo
         * assim o tempo critíco (tempo em que o banco fica bloqueado sem ser necessário), não esquecer de ordenar as
         * contas antes de fazer lock, para que o lock siga uma ordem, pois tem que seguir!
         */

        l.unlock();
        System.out.println("idThread="+idThread+" - FIZ UNLOCK DO BANCO!!!!");
        //  unlock do Banco - a partir de aqui o
        //  banco está livre para outros clientes
        //  e já tenho as contas que interessam bloqueadas


        contaFrom.debito(amount);
        contaTo.credito(amount);

        System.out.println("Contas da transferência="+contasOrdenadas.toString());

        for(Conta c : contasOrdenadas)
            c.rl.unlock();

    }

    public float totalBalance(int accounts[], int idThread){
        l.lock();
        System.out.println("idThread="+idThread+" - FIZ LOCK DO BANCO!!!!");
        Set<Conta> contasOrdenadas = new TreeSet<Conta>();
        for(Conta c : this.contas.values()){
           for(int id : accounts) {
               if (c.getId() == id) {
                   //System.out.println(c.getId()+" == "+id);
                   contasOrdenadas.add(c);
                   break;
               }
           }
        }
        for(Conta c : contasOrdenadas)
            c.rl.lock();

        System.out.println("Estado antes do totalBalance das contas envolvidas="+contasOrdenadas.toString());

        l.unlock();
        System.out.println("idThread="+idThread+" - FIZ UNLOCK DO BANCO!!!!");

        float balanco = 0;
        for(Conta c : contasOrdenadas)
            balanco += c.getSaldo();
        System.out.println("Estado depois do totalBalance das contas envolvidas="+contasOrdenadas.toString());
        for(Conta c : contasOrdenadas)
            c.rl.unlock();
        return balanco;
    }

    @Override
    public String toString() {
        try {
            l.lock();
            System.out.println("FIZ LOCK DO BANCO!!!!");
            return "Banco{" +
                    "contas=" + contas +
                    ", lastId=" + lastId +
                    ", l=" + l +
                    '}';
        }finally {
            l.unlock();
        }
    }
}
