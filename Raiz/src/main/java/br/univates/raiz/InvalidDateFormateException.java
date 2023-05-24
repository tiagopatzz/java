/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.raiz;

/**
 *
 * @author mouriac
 */
public class InvalidDateFormateException extends Exception
{

    public InvalidDateFormateException(String string)
    {
        super(string);
    }

    public InvalidDateFormateException()
    {
        super("Data em formato inválido");
    }
    
    
    
    
}
