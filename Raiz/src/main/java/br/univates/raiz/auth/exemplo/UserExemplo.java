package br.univates.raiz.auth.exemplo;

import br.univates.raiz.auth.User;

public class UserExemplo implements User
{
    private String logName;
    private String name;
    private String hashCode;

    public UserExemplo(String logName, String name, String hashCode)
    {
        this.logName = logName;
        this.name = name;
        this.hashCode = hashCode;
    }
    
    public UserExemplo(String logName, String hashCode)
    {
        this.logName = logName;
        this.name = logName;
        this.hashCode = hashCode;
    }

    public String getLogName()
    {
        return logName;
    }

    public String getName()
    {
        return name;
    }

    public String getHashCode()
    {
        return hashCode;
    }
    
    
    
}
