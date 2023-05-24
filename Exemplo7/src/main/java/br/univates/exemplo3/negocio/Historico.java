package br.univates.exemplo3.negocio;

import br.univates.raiz.Data;
import br.univates.raiz.Horario;
import br.univates.raiz.InvalidDateException;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Historico
{
    private Data data;
    private Horario horario;
    private Retangulo retangulo;

    public Historico(Date date, Time time, Retangulo retangulo)
    {
        try
        {
            this.data = new Data( date.getDate(), date.getMonth()+1, date.getYear()+1900 );
        } 
        catch (InvalidDateException ex)
        {
            Logger.getLogger(Historico.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.horario = new Horario( time.getHours(), time.getMinutes(), time.getSeconds() );
        this.retangulo = retangulo;
    }
    
    public Historico(Data data, Horario horario, Retangulo retangulo)
    {
        this.data = data;
        this.horario = horario;
        this.retangulo = retangulo;
    }
   
    public Data getData()
    {
        return data;
    }

    public void setData(Data data)
    {
        this.data = data;
    }

    public Horario getHorario()
    {
        return horario;
    }

    public void setHorario(Horario horario)
    {
        this.horario = horario;
    }

    public Retangulo getRetangulo()
    {
        return retangulo;
    }

    public void setRetangulo(Retangulo retangulo)
    {
        this.retangulo = retangulo;
    }
    
    public String toString()
    {
        return this.data.toString()+";"+
               this.horario.getHorario(Horario.HHMMSS)+";"+
               this.retangulo.getBase()+";"+
               this.retangulo.getAltura();
    }
    
}
