package br.univates.exemplo3.persistencia;

import br.univates.exemplo3.Sys;
import br.univates.exemplo3.negocio.Historico;
import br.univates.exemplo3.negocio.Retangulo;
import br.univates.raiz.Arquivo;
import br.univates.raiz.Data;
import br.univates.raiz.Horario;
import br.univates.raiz.InvalidDateException;
import br.univates.raiz.InvalidDateFormateException;
import br.univates.raiz.db.DataBaseConnectionManager;
import br.univates.raiz.db.DataBaseException;
import br.univates.raiz.persistence.Filter;
import br.univates.raiz.persistence.IDao;
import br.univates.raiz.persistence.InvalidKeyException;
import br.univates.raiz.persistence.KeyViolationException;
import br.univates.raiz.persistence.NotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HistoricoDaoPostgres implements IDao<Historico,String>
{
    @Override
    public void create(Historico historico) throws KeyViolationException, InvalidKeyException
    {
        /*
        if (a chave é errada)
        {
            new InvalidKeyException();
        }
        */
        
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "INSERT INTO historico VALUES ( ?, ?, ?, ?);";

            dbcm.runPreparedSQL(sql, historico.getData().getDataFormatada(0), 
                                     historico.getHorario().getHorario( Horario.HHMMSS ), 
                                     historico.getRetangulo().getBase(),
                                     historico.getRetangulo().getAltura() );
                                     
            dbcm.closeConnection();
        } 
        catch (DataBaseException ex)
        {
            throw new KeyViolationException();
        }
    }
    
    @Override
    public ArrayList<Historico> readAll()
    {
        ArrayList<Historico> lista = new ArrayList();
        
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM historico;";
            
            ResultSet rs = dbcm.runQuerySQL(sql);
            
            if (rs.isBeforeFirst())
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    Date dt = rs.getDate("data_calculo");
                    Time time = rs.getTime("hora_calculo");
                    Double base = rs.getDouble("base");
                    Double altura = rs.getDouble("altura");
                    
                    Historico h = new Historico(dt,time,new Retangulo(base,altura) );
                    lista.add(h);
                    
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
            Logger.getLogger(HistoricoDaoPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public Historico read(String primaryKey) throws NotFoundException
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Historico> readAll(Filter<Historico> filtro)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Historico objeto) throws NotFoundException
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String primaryKey) throws NotFoundException
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
