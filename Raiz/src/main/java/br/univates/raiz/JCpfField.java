/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.raiz;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mouriac
 */
public class JCpfField extends JTextFieldCustomized
{
    private CPF cpf;
    
    public JCpfField()
    {
        try
        {
            setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } 
        catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }
        
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                try
                {
                    if (!getTextFlat().isEmpty())
                    {
                        cpf = new CPF( getText() );
                        setBackground(Color.WHITE);
                    }
                }   
                catch (InvalidCpfException ex)
                {
                    setBackground(Color.RED);
                }
            }

        });
    }
    
}
