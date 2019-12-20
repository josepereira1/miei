
/**
 * Write a description of class FBFeed here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.stream.*;
import java.util.*;
import java.time.*;
import java.lang.Float;

public class FBFeed
{
    private List <FBPost> feed;
    
    public FBFeed(){
        this.feed = new ArrayList();
    }
    /*public FBFeed(List <FBPost> feed){
        this.feed = new ArrayList <> ();
        feed.forEach(p->this.feed.add(p.clone()));
    }*/
    
    public FBFeed(List <FBPost> feed){
        this.feed = feed.stream().map(FBPost::clone).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public List<FBPost> getFeed(){
        ArrayList<FBPost> tmp = new ArrayList(this.feed.size());
        FBPost post;
        /*for(FBPost post :this.feed){
            tmp.add(post);
        }*/
        Iterator<FBPost> it = this.feed.iterator();
        while(it.hasNext()){
            post = it.next();
            tmp.add(post.clone());
        }
        return tmp;
    }
    
    public void add(FBPost post){
        this.feed.add(post.clone());
    }
    
    //exercício 4_a:
    public int nPosts(String user){
        return feed.stream().filter(p->p.getUsername() == user).mapToInt(p -> { return 1;}).sum();
    }
    
    //exercício 4_b:
    public List<FBPost> postsOf(String user){
        return feed.stream().filter(p->p.getUsername() == user).map(FBPost::clone).collect(Collectors.toList());
    }
    
    //exercício 4_c:
    public List <FBPost> postOf(String user, LocalDateTime inicio , LocalDateTime fim){
        return feed.stream().filter(p->p.getUsername() == user && p.getData().isAfter(inicio) 
        && p.getData().isBefore(fim)).map(FBPost::clone).collect(Collectors.toList());
    }
    //exercício 4_i:
    public List <Integer> top5Comments(){
        return feed.stream().sorted(new Comparator <FBPost>(){
            public int compare (FBPost a, FBPost b){
                if(a.getComentarios().size() > b.getComentarios().size()){return -1;}else{return 1;}
            }
    }).limit(5).map(FBPost::getId).collect(Collectors.toList());
    }
    
    public String toString(){
        return this.feed.toString();
    }
}
