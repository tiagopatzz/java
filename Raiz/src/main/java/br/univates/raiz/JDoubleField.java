package br.univates.raiz;

import javax.swing.text.NumberFormatter;

/**
 *
 * @author mouriac
 */
public class JDoubleField extends JTextFieldCustomized
{

    public JDoubleField()
    {
        setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##########"))));
        
        this.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                char key = evt.getKeyChar();
                if (key != ',' && !Character.isDigit(key))
                {
                    evt.consume();
                }
            }
        });
    }
    
    /**
     * Retorna o valor digitado pelo usuário no campo.
     * @return o valor double digitado
     */
    public double getDouble()
    {
        double r = 0;
        if (this.getValue() instanceof Double)
        {
            r = (Double)this.getValue();
        }
        else if (this.getValue() instanceof Long)
        {
            Long aux = (Long)this.getValue();
            r = aux.doubleValue();
        }
        return r;
    }
    
    /**
     * Define um valor inicial para o campo.
     * @param value valor double a ser atribuido ao campo
     */
    public void setDouble( double value )
    {
        this.setValue(value);
    }
}
