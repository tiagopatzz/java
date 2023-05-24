package br.univates.raiz;

public class CPF
{
    private String cpf;
    
    public CPF(String cpf) throws InvalidCpfException
    {
        if (CPF.isRight(cpf))
        {
            this.cpf = cpf.replaceAll("[^0-9]","");;
        }
        else
        {
            throw new InvalidCpfException();
        }
    }

    public String getCpf()
    {
        return cpf;
    }
    
    public String getCpfFormatado()
    {
        return cpf.substring(0,0+3)+"."+cpf.substring(3,3+3)+"."+cpf.substring(6,6+3)+"-"+cpf.substring(9,9+2);
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf.replaceAll("[^0-9]","");;
    }
    
    public static boolean isRight( String cpf )
    {
        /*
        boolean ok = false;
        String cpfSomenteNumeros = cpf.trim().replaceAll("[^0-9]","");
        
        if (!cpfSomenteNumeros.isEmpty() && cpfSomenteNumeros.length() == 11)
        {
            ok = Util.validarCPF(cpfSomenteNumeros);
        }
        return ok
        */
        return Util.validarCPF(cpf.replaceAll("[^0-9]",""));
    }
   
    
}
