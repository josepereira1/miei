package dataaccess;

/**
 * Exemplo de um DAO (para o acesso aos dados de Aluno).
 * Como forma de minimizar o impacto de alteração dos Diag de Sequência, o DAO assume
 * a API da estrutura de dados que substitui - neste caso vai substituir um Map de Aluno.
 * @author jfc
 */

import business.*;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
import java.sql.*;

public class AlunoDAO implements Map<String,Aluno> {
    
    public Connection conn;
    
    public AlunoDAO () {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            this.conn = DriverManager.getConnection("jdbc:odbc:alunos");
        }
        catch (ClassNotFoundException e) {}
        catch (SQLException e) {}
    }
    
    public void clear () {
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM TAlunos");
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
    public boolean containsKey(Object key) throws NullPointerException {
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT nome FROM TAlunos WHERE numero='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
    public boolean containsValue(Object value) {
        throw new NullPointerException("public boolean containsValue(Object value) not implemented!");
    }
    
    public Set<Map.Entry<String,Aluno>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
    }
    
    public boolean equals(Object o) {
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }
    
    public Aluno get(Object key) {
        try {
            Aluno al = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM TAlunos WHERE numero='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) 
                al = new Aluno(rs.getString(2),rs.getString(1),rs.getInt(3),rs.getInt(4));
            return al;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
    public int hashCode() {
        return this.conn.hashCode();
    }
    
    public boolean isEmpty() {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT nome FROM TAlunos");
            return !rs.next();
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
    public Set<String> keySet() {
        throw new NullPointerException("Not implemented!");
    }
    
    public Aluno put(String key, Aluno value) {
        try {
            Aluno al = null;
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM TAlunos WHERE numero='"+key+"'");
            String sql = "INSERT INTO TAlunos VALUES ('"+value.getNome()+"','"+key+"',";
            sql += value.getNotaT()+","+value.getNotaP()+")";
            int i  = stm.executeUpdate(sql);
            return new Aluno(value.getNumero(),value.getNome(),value.getNotaT(),value.getNotaP());
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public void putAll(Map<? extends String,? extends Aluno> t) {
        throw new NullPointerException("Not implemented!");
    }
    
    public Aluno remove(Object key) {
        try {
            Aluno al = this.get(key);
            Statement stm = conn.createStatement();
            String sql = "DELETE '"+key+"' FROM TAlunos";
            int i  = stm.executeUpdate(sql);
            return al;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT nome FROM TAlunos");
            for (;rs.next();i++);
            return i;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
    public Collection<Aluno> values() {
        try {
            Collection<Aluno> col = new HashSet<Aluno>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM TAlunos");
            for (;rs.next();) {
                col.add(new Aluno(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
            }
            return col;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
}

