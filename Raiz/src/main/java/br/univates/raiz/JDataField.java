/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.raiz;

import java.awt.Color;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mouriac
 */
public class JDataField extends JTextFieldCustomized
{
    private Data dt;
            
    public JDataField()
    {
        dt = null;
        try
        {
            this.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } 
        catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }
        this.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                try
                {
                    if (!getTextFlat().isEmpty())
                    {
                        dt = new Data( getText() );
                        setBackground(Color.WHITE);
                    }
                } 
                catch (InvalidDateException | InvalidDateFormateException ex)
                {
                    setBackground(Color.RED);
                } 
            }
        });
    }

    public Data getData()
    {
        return dt;
    }

    public void setData(Data dt)
    {
        this.dt = dt;
        this.setText( dt.toString() );
    }
    
    public Date getDate()
    {
        Date date = new Date( dt.getAno()-1900, dt.getMes()-1, dt.getDia() );
        return date;
    }
    
    public void setDate( Date date )
    {
        try
        {
            dt = new Data( date.getDate(), date.getMonth()+1, date.getYear()+1900 );
            this.setText( dt.toString() );
        } 
        catch (InvalidDateException ex)
        {
        
        }
    }
}
