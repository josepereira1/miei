package abd.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

public class Init {
    public static void main(String[] args) throws Exception {
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/mydb");

        String dados = "bla";
        for(int i=0; i<100; i++)
            dados = dados + " bla";

        Statement s = c.createStatement();

        // criar tabelas
        s.executeUpdate("create table if not exists t1 (a int, b int, data varchar)");
        s.executeUpdate("create table if not exists t2 (a int, b int, data varchar)");


        // inserir dados
        Random rand = new Random();
        for(int i=0; i<1024; i++) {
            int v = rand.nextInt(1024)|rand.nextInt(1024);
            // CUIDADO: Não se devem criar statements sql assim!!!!!
            s.executeUpdate("insert into t1 values (" + i + ", " + v + ", '"+dados+"')");
            s.executeUpdate("insert into t2 values (" + i + ", " + v + ", '"+dados+"')");
        }

        s.close();
        c.close();
    }
}
