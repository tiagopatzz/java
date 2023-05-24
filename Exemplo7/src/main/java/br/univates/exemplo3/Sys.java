package br.univates.exemplo3;

import br.univates.raiz.auth.User;
import br.univates.raiz.db.DataBaseConnectionManager;
import br.univates.raiz.db.DataBaseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sys
{
    private String nomeSys;
    private String licenciado;
    private User user;
    private DataBaseConnectionManager dbcm;
    
    private static Sys sys = new Sys();

    public static Sys getInstance()
    {
        return sys;
    }
    
    
    private Sys()
    {
        this.nomeSys = "Sistema de Cálculos de Retângulo";
        this.licenciado = "Mouriac Diemer";
        this.user = null;
        try
        {
            this.dbcm = new DataBaseConnectionManager( DataBaseConnectionManager.POSTGRESQL,
                    "teste","postgres","postgres");
        } 
        catch (DataBaseException ex)
        {
            System.exit(0);
        }
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    
    
    
    public String getNomeSistema()
    {
        return nomeSys;
    }

    public String getNomeLicenciado()
    {
        return licenciado;
    }

    public User getUser()
    {
        return user;
    }

    public DataBaseConnectionManager getDB()
    {
        return dbcm;
    }
    
    
    
    
    
}
