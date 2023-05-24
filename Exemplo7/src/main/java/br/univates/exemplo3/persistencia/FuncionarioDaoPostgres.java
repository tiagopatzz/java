package br.univates.exemplo3.persistencia;

import br.univates.exemplo3.Sys;
import br.univates.exemplo3.negocio.Funcionario;
import br.univates.raiz.Data;
import br.univates.raiz.InvalidDateException;
import br.univates.raiz.db.DataBaseConnectionManager;
import br.univates.raiz.db.DataBaseException;
import br.univates.raiz.persistence.DaoAdapter;
import br.univates.raiz.persistence.Filter;
import br.univates.raiz.persistence.IDao;
import br.univates.raiz.persistence.NotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDaoPostgres extends DaoAdapter<Funcionario,Integer>
{
    // CRUD
    // CREATE
    // READ
    // UPDATE
    // DELETE
    
    @Override
    public void create( Funcionario func )
    {
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "INSERT INTO funcionario VALUES ( ?, ?, ?, ?, ?, ?, ?);";
            
            dbcm.runPreparedSQL(sql, func.getId(), func.getName(),
                    func.getEndereco(),func.getDateNascimento(),
                    func.getLogName(),func.getHashCode(),func.getSalario() );
        } 
        catch (DataBaseException ex)
        {
            System.out.println("deu pau");
        }
    }
    
    @Override
    public Funcionario read( Integer id_func )
    {
        Funcionario f = null;
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM funcionario WHERE id_func = ?";
            
            ResultSet rs = dbcm.runPreparedQuerySQL(sql, id_func );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                // não precisa while por que eu sei que só tem um resultado
                int id = rs.getInt("id_func");
                String nome = rs.getString("nome");
                String end = rs.getString("endereco");
                Date date = rs.getDate("data_nascimento");
                String logName = rs.getString("log_name");
                String hashCode = rs.getString("hash_code");
                double salario = rs.getDouble("salario");
                
                Data data=null;
                try
                {
                    data = new Data( date.getDate(), date.getMonth()+1, date.getYear()+1900 );
                } 
                catch (InvalidDateException ex)
                {
                    
                }
                
                f = new Funcionario(id,nome,end,data,logName,hashCode,salario);
            }
        } 
        catch (DataBaseException ex)
        {
            System.out.println("deu pau");
        } 
        catch (SQLException ex)
        {
            System.out.println("deu pau");
        }
        
        return f;
    }
    
    
    @Override
    public ArrayList<Funcionario> readAll()
    {
        ArrayList<Funcionario> lista = new ArrayList();
        
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM funcionario;";
            
            ResultSet rs = dbcm.runQuerySQL( sql );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    int id = rs.getInt("id_func");
                    String nome = rs.getString("nome");
                    String end = rs.getString("endereco");
                    Date date = rs.getDate("data_nascimento");
                    String logName = rs.getString("log_name");
                    String hashCode = rs.getString("hash_code");
                    double salario = rs.getDouble("salario");

                    Data data=null;
                    try
                    {
                        data = new Data( date.getDate(), date.getMonth()+1, date.getYear()+1900 );
                    } 
                    catch (InvalidDateException ex)
                    {

                    }

                    Funcionario f = new Funcionario(id,nome,end,data,logName,hashCode,salario);
                    lista.add(f);
                    
                    rs.next();
                }
            }

        } 
        catch (DataBaseException ex)
        {
            System.out.println("deu pau");
        } 
        catch (SQLException ex)
        {
            System.out.println("deu pau");
        }
        
        return lista;

    }

    @Override
    public void update(Funcionario objeto) throws NotFoundException
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
