
/**
 * Write a description of class Ficha5Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
public class Ficha5Test
{
    public static void main(String[] args){
    LocalDateTime date1 = LocalDateTime.now();
    List<String> comentarios = new ArrayList();
    FBPost post1 = new FBPost(1,"José Pereira",date1,"Hello World!",500,comentarios);
    
    FBFeed feed = new FBFeed();
    feed.add(post1);
    System.out.println(feed.toString());
    }
}
