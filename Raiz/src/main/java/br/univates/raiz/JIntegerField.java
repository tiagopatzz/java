/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.raiz;

/**
 *
 * @author mouriac
 */
public class JIntegerField extends JTextFieldCustomized
{

    public JIntegerField()
    {
        this.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                char key = evt.getKeyChar();
                if (!Character.isDigit(key))
                {
                    evt.consume();
                }
            }
        });
    
    }
    
    public int getInteger()
    {
        int valor = 0;
        try
        {
            valor = Integer.parseInt(this.getText());
        }
        catch (Exception e)
        {
            valor = 0;
        }
        return valor;
    }
    
    public void setInteger( int valor )
    {
        this.setText( valor+"" );
    }
    
    
}
