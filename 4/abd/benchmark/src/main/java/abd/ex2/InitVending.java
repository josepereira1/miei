package abd.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InitVending {
    public static void main(String[] args) throws Exception {
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/mydb");
        Statement s = c.createStatement();

        // criar tabelas
        s.executeUpdate("create table if not exists Client (id int, name varchar , address varchar)");
        s.executeUpdate("create table if not exists Product (id int, description varchar , stock int, min int , max int)");
        s.executeUpdate("create table if not exists Invoice (id int, clientId int)");
        s.executeUpdate("create table if not exists InvoiceLine (id int, invoiceId int , productId int)");
        s.executeUpdate("create table if not exists Package (id int, productId int , supplier varchar , items int)");

        // inserir dados

        s.executeUpdate("delete from client");
        s.executeUpdate("delete from invoice");
        s.executeUpdate("delete from invoiceLine");
        s.executeUpdate("delete from package");
        s.executeUpdate("delete from product");


        //  estes valores inseridos são usados como referências para o cálculo dos Ids
        s.executeUpdate("insert into client values (0,'root', 'root')");
        s.executeUpdate("insert into invoice values (0,0)");
        s.executeUpdate("insert into invoiceLine values (0,0,0)");

        s.executeUpdate("insert into Product values (1,'macbook-air', 100, 30, 300)");
        s.executeUpdate("insert into Product values (2,'macbook-pro', 82, 30, 500)");

        s.close();
        c.close();
    }
}
