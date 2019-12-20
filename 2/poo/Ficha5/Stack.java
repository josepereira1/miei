
/**
 * Write a description of class Stack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.lang.Object;
import java.util.Iterator;

public class Stack
{
    private ArrayList<String> stack;
    
    public Stack(){
        this.setStack(new ArrayList<>());
    }
    
    public Stack(Stack stack){
        this.setStack(stack.getStack());
    }
    
    public Stack(ArrayList<String> stack){
        this.setStack(stack);
    }
    
    public ArrayList<String> getStack(){
        ArrayList<String> res = new ArrayList<>(this.getStack().size());
        Iterator<String> it1 = this.stack.iterator();
        Iterator<String> it2 = res.iterator();
        
        String elem;
        
        /*
        for(String s: stack){
            res.add(s);
            //s.clone(s);   // caso não fossem Strings teria que fazer isto;
        }*/
        
        while(it1.hasNext()){
            elem = it1.next();
            res.add(elem);
        }
        
        return res;
    }
    
    public void setStack(ArrayList<String> elems){
        this.stack = new ArrayList<>(elems.size());
        
        for(Iterator <String> it = elems.iterator();it.hasNext();){
            String s = it.next();
            stack.add(s);
        
        }
        //este for podia ser feito desta maneira:
        
        //for(String s: elems)stack.add(s);
        
    }
    
    public Stack clone(){
        return new Stack(this);
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(this.getClass() != o.getClass())return false;
        
        Stack s = (Stack) o;
        
        return stack.equals(s.getStack());  //  aqui está a chamar o equals do ArrayList, pq a stack é um ArrayList, se fosse aceder ao meu equals teria que ser Stack. ....
    }
    
    public String toString(){
        return "Stack" + stack.toString();
    }
    
    public String top(){
        return stack.get(stack.size()-1);
    }
    
    public void push(String s){
        stack.add(s);
    }
    
    public void pop(){
        if(!stack.isEmpty())
        stack.remove(stack.size()-1);
    }
    
    public boolean empty(){
        return stack.isEmpty();
    }
    
    public int length(){
        return stack.size();
    }
}
