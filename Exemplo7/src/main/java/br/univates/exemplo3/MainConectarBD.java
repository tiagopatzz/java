package br.univates.exemplo3;

import br.univates.raiz.db.DataBaseConnectionManager;
import br.univates.raiz.db.DataBaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;

public class MainConectarBD
{
    public static void main(String[] args)
    {
        String url = "jdbc:postgresql://localhost:5432/teste";
        String user = "postgres";
        String pw = "postgres";

        /**
         * EXEMPLO DIRETO
         */
        /*
        try
        {
            Connection c = DriverManager.getConnection( url, user, pw );
            System.out.println("A conexão ocorreu");
            
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM funcionario;");
            
            if (rs.isBeforeFirst()) // significa que retornou alguma coisa no select
            {
                rs.next(); // avançar para o primeiro item do ResultSet
                while (!rs.isAfterLast())
                {
                    int id = rs.getInt("id_func");
                    String nome = rs.getString("nome");
                    String senha = rs.getString("hash_code");
                    
                    
                    System.out.println(id+" - "+nome+" - "+senha);
                    rs.next();
                }
            }
            c.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Falhou a conexão");
        }
        */
        /**
         * EXEMPLO USANDO A CLASSE DE GERENCIAMENTO QUE ESTÁ A RAIZ
         */
        
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = new DataBaseConnectionManager( DataBaseConnectionManager.POSTGRESQL,
                    "teste",user, pw);
            System.out.println("A conexão ocorreu");
            
            ResultSet rs = dbcm.runQuerySQL("SELECT * FROM funcionario;");
            
            if (rs.isBeforeFirst()) // significa que retornou alguma coisa no select
            {
                rs.next(); // avançar para o primeiro item do ResultSet
                while (!rs.isAfterLast())
                {
                    int id = rs.getInt("id_func");
                    String nome = rs.getString("nome");
                    
                    System.out.println(id+" - "+nome);
                    rs.next();
                }
            }
            
            dbcm.closeConnection();
        } 
        catch (SQLException ex)
        {
            System.out.println("Erro com o ResultSet");
        }
        catch (DataBaseException ex)
        {
            System.out.println("A conexão ocorreu");
        }
        
        
        
        
    }
}
