package br.univates.raiz;

public class Numero
{
    private int valor;

    public Numero(int valor)
    {
        this.valor = valor;
    }

    public void setValor(int valor)
    {
        if (valor > 0)
        {
            this.valor = valor;
        }
    }

    public int getValor()
    {
        return valor;
    }
    
    public int getQuantDivisores()
    {
        int contador = 1;
        for (int i = 1; i <= valor/2; i++)
        {
            if (valor % i == 0)
            {
                contador ++;
            }
        }
        return contador;
    }
    
    public boolean isPrimo()
    {
        return (this.getQuantDivisores() <= 2);
    }
    
    public boolean isPrimoRelativo(Numero outroNumero)
    {
        boolean primoRelativo = true;
        int menor = Math.min( this.valor, outroNumero.valor );
        for (int i = 2; i <= menor; i++)
        {
            if (this.valor % i == 0 && outroNumero.valor % i == 0)
            {
                primoRelativo = false;
                break;
            }
        }
        return primoRelativo;
    }
    
    public int getFatorial()
    {
        return Util.calcularFatorial( this.valor );
    }
    
    public boolean isPar()
    {
        return (this.valor % 2 == 0);
    }
    
    public boolean isImpar()
    {
        return !isPar();
    }
    
}
