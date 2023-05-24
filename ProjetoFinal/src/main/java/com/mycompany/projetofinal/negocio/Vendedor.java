package com.mycompany.projetofinal.negocio;

import br.univates.raiz.Data;
import br.univates.raiz.auth.User;
import java.util.Date;

public class Vendedor implements User
{
    private int id;
    private String nome;
    private String endereco;
    private Data dataNascimento;
    private String logName;
    private String hashCode;
    private double salario;

    public Vendedor(int id, String nome, String endereco, Data dataNascimento, String logName, String hashCode, double salario)
    {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.logName = logName;
        this.hashCode = hashCode;
        this.salario = salario;
    }

    public Vendedor( int id, String logName, String hashCode )
    {
        this.id = id;
        this.nome = "";
        this.endereco = "";
        this.dataNascimento = null;
        this.logName = logName;
        this.hashCode = hashCode;
        this.salario = 0;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return nome;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public Data getDataNascimento()
    {
        return dataNascimento;
    }
    
    public Date getDateNascimento()
    {
        Date dt = new Date(dataNascimento.getAno()-1900,
        dataNascimento.getMes()-1, dataNascimento.getDia() );
        
        return dt;
    }

    public String getLogName()
    {
        return logName;
    }

    public String getHashCode()
    {
        return hashCode;
    }

    public double getSalario()
    {
        return salario;
    }
    
    
    
    
}
