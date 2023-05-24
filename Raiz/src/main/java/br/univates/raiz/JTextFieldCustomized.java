/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.raiz;

import java.awt.Color;
import java.io.InputStream;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author mouriac
 */
public class JTextFieldCustomized extends JFormattedTextField
{

    private boolean required;

    public JTextFieldCustomized()
    {
        this.required = false;
        
        this.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                if (isRequired())
                {
                    //if (getText().isEmpty())
                    if (getTextFlat().isEmpty())
                    {
                        setBackground(Color.YELLOW);
                    } 
                    else
                    {
                        setBackground(Color.WHITE);
                    }
                }
            }
        });
    }

    public boolean isRequired()
    {
        return required;
    }

    public void setRequired(boolean required)
    {
        this.required = required;
    }

    public String getTextFlat()
    {
        String without = "./-";
        return this.getText().replaceAll("["+without+"]", "").trim();
    }
    
}
