package ex2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;

public class Warehouse {
    public Map<String,Item> items;
    ReentrantLock rl = new ReentrantLock();

    public Warehouse(){
        this.items = new HashMap<String,Item>();
    }

    public Warehouse(Map<String,Item> items){
        this.items = items;
    }

    public void supply(String item, int quantity){
        rl.lock();

        if(!this.items.containsKey(item)) { //  caso não exista, cria este item
            Item newItem = new Item(item);
            this.items.put(item, newItem);
        }

        Item i = this.items.get(item);
        i.rl.lock();    //  lock do item que vou fornecer
        rl.unlock();    //  unlock do warehouse

        i.add(quantity);
        i.rl.unlock();
    }

    public void consume(String[] items) throws ItemNaoExisteException{
        rl.lock();
        Set<Item> itemsOrdenados = new TreeSet<>();

        for (String i : items)    //  verificar se os items existem
            if (!this.items.containsKey(i)) throw new ItemNaoExisteException(i);

        for (String chave : items)    //  adicionar ao Set os items de forma ordenada
                itemsOrdenados.add(this.items.get(chave));

        for (Item it : itemsOrdenados)   //  lock dos items que me interessam, de forma ordenada
            it.rl.lock();

        rl.unlock();    //  unlock do warehouse

        for(Item it :itemsOrdenados)
            it.remove();

        for (Item it : itemsOrdenados)
            it.rl.unlock();
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "items=" + items +
                ", rl=" + rl +
                '}';
    }
}
