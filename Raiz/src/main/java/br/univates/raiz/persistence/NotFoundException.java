package br.univates.raiz.persistence;

public class NotFoundException extends Exception
{

    public NotFoundException()
    {
        super("Registro não encontrado");
    }

    
    
}
