/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.raiz;

/**
 *
 * @author mouriac
 */
public class InvalidDateException extends Exception
{

    public InvalidDateException(String string)
    {
        super(string);
    }

    public InvalidDateException()
    {
        super("Data inválida");
    }
    
    
    
    
}
