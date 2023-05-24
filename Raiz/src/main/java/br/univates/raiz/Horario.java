/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.raiz;

import java.text.DecimalFormat;
import java.util.Calendar;

/**
 *
 * @author mouriac
 */
public class Horario
{
    final public static int HHMMSS = 1;
    final public static int HHMM = 2;
    
    private int hora;
    private int minuto;
    private int segundo;

    public Horario(String horario)
    {
        String[] partes = horario.split(":");
        
        this.hora = Integer.parseInt(partes[0]);
        this.minuto = Integer.parseInt(partes[1]);
        this.segundo = Integer.parseInt(partes[2]);
    }
    
    
    public Horario(int hora, int minuto, int segundo)
    {
        // falta validação
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    
    public Horario()
    {
        Calendar c = Calendar.getInstance();
        
        hora = c.get( Calendar.HOUR_OF_DAY );
        minuto = c.get( Calendar.MINUTE );
        segundo = c.get( Calendar.SECOND );
    }

    public int getHora()
    {
        return hora;
    }

    public int getMinuto()
    {
        return minuto;
    }

    public int getSegundo()
    {
        return segundo;
    }
    
    public String getHorario( int formato )
    {
        String formatado = (hora < 10 ? "0"+hora+":" : hora+":")+
                           (minuto < 10 ? "0"+minuto : minuto );

        if (formato == Horario.HHMMSS)
        {
            formatado += ":"+(segundo < 10 ? "0"+segundo : segundo+"" );
        }
        return formatado;
    }
}
