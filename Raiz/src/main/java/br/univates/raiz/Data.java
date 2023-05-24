package br.univates.raiz;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data
{

    private int dia;
    private int mes;
    private int ano;
    
    public Data()
    {
        Calendar c = Calendar.getInstance();
        
        dia = c.get( Calendar.DAY_OF_MONTH );
        mes = c.get( Calendar.MONTH )+1;
        ano = c.get( Calendar.YEAR );
        //c.get( Calendar.HOUR_OF_DAY );
    }

    public Data(String data) throws InvalidDateException, InvalidDateFormateException
    {
        String[] vet = data.split("/");
        try
        {
            int d = Integer.parseInt(vet[0]);
            int m = Integer.parseInt(vet[1]);
            int a = Integer.parseInt(vet[2]);
            
            if (Data.isRight(d, m, a))
            {
                this.dia = d;
                this.mes = m;
                this.ano = a;
            } 
            else
            {
                throw new InvalidDateException();
            }
        } 
        catch (NumberFormatException e)
        {
            throw new InvalidDateFormateException("A data deve estar no formato dd/mm/aaaa");
        }
    }

    public Data(int dia, int mes, int ano) throws InvalidDateException
    {
        if (Data.isRight(dia, mes, ano))
        {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else
        {
            throw new InvalidDateException();
        }
    }

    public static boolean isRight(int d, int m, int a)
    {
        boolean correto = false;
        if (a > 1900) // 1582
        {
            if (m >= 1 && m <= 12)
            {
                int[] dias =
                {
                    31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
                };
                if (a % 400 == 0 || (a % 4 == 0 && a % 100 != 0)) // bissexto
                {
                    dias[1] = 29;
                }
                if (d >= 1 && d <= dias[m - 1])
                {
                    correto = true;
                }
            }
        }
        return correto;
    }

    public int getDia()
    {
        return dia;
    }

    public int getMes()
    {
        return mes;
    }

    public int getAno()
    {
        return ano;
    }

    /**
     * Definir o dia e mês de uma data. Não irá modificar o ano. O dia e mês
     * serão definidos pelo dia sequencial a partir de primeiro de janeiro.
     *
     * @param sequencial
     */
    public void setData(int sequencial)
    {
        /*
        ??
        ??
         */
    }

    public void setDia(int dia)
    {
        if (Data.isRight(dia, this.mes, this.ano))
        {
            this.dia = dia;
        }
    }

    public void setMes(int mes)
    {
        if (Data.isRight(this.dia, mes, this.ano))
        {
            this.mes = mes;
        }
    }

    public void setAno(int ano)
    {
        if (Data.isRight(this.dia, this.mes, ano))
        {
            this.ano = ano;
        }
    }

    public String getSigno()
    {
        return "";
    }

    public boolean isBissexto()
    {
        return (ano % 400 == 00 || (ano % 4 == 0 && ano % 100 != 0));
    }

    public String getEstacao()
    {
        return "";
    }

    public boolean isFeriados() // Nacionais oficiais
    {
        /*
        ArrayList<Data> feriados = new ArrayList();
        feriados.add( new Data(21,4,ano ));
        feriados.add( new Data(15,11,ano));
        feriados.add( new Data(12,10,ano ));
        feriados.add( new Data(7,9,ano ));
        feriados.add( new Data(25,12,ano ));
        feriados.add( new Data(1,1,ano ));
        feriados.add( new Data(1,5,ano ));
        
        return feriados.contains(this);*/
        return false;
    }

    @Override
    public boolean equals(Object outraData)
    {
        /*
        boolean igual = false;
        Data aux = (Data)outraData;
        if (aux.dia == this.dia && aux.mes==this.mes && aux.ano==this.ano)
        {
            igual = true;
        }
        return igual;
         */

        Data aux = (Data) outraData;
        return (aux.dia == this.dia && aux.mes == this.mes && aux.ano == this.ano);

    }

    private int getDiaDoSeculo()
    {
        //www.inf.ufrgs.br/~cabral/Dia_do_Seculo.html
        int diaDoSeculo = (ano - 1901) * 365 + (ano - 1901) / 4 + dia + (mes - 1)
                * 31 - ((mes * 4 + 23) / 10)
                * ((mes + 12) / 15) + ((4 - ano % 4) / 4)
                * ((mes + 12) / 15);
        return diaDoSeculo;
    }

    public String getDiaSemana()
    {
        String[] dias =
        {
            "Segunda-feira", "Terça-feira", "Quarta-feira",
            "Quinta-feira", "Sexta-feira", "Sábado", "Domingo"
        };

        return dias[this.getDiaDoSeculo() % 7];
    }

    /**
     * Retorna a sequência cardinal em relação ao ano. Exemplo: a data 01/fev é
     * o dia 32 do ano.
     *
     * @return
     */
    public int getDiaSequencial()
    {
        //return this.getDiferenca( new Data( 1, 1, ano ) )+1;
        return 0;
    }

    public String getDataFormatada(int codFormato)
    {
        // 31 de março de 2023
        // Terça-feira, 31 de março de 2023
        // 31/mar/2023
        // 31/03/2023
        

        
        return  ano+"-"+
               (mes < 10 ? "0"+mes+"-" : mes+"-")+
               (dia < 10 ? "0"+dia : dia+"");
    }

    public int getDiferenca(Data outraData)
    {
        return Math.abs(this.getDiaDoSeculo() - outraData.getDiaDoSeculo());
    }

    public String getFaseLua()
    {
        return "";
    }

    public void avancarUmDia()
    {
        this.dia++;
        if (!Data.isRight(dia, mes, ano))
        {
            dia = 1;
            this.mes++;
            if (!Data.isRight(dia, mes, ano))
            {
                this.mes = 1;
                this.ano++;
            }
        }
    }

    public void retrocederUmDia()
    {

    }

    public void avancarDias(int quant)
    {
        for (int i = 0; i < quant; i++)
        {
            avancarUmDia();
        }
    }

    public void retrocederDias(int quant)
    {

    }

    public int getTrimestre()
    {
        return 0;
    }

    public int getUltimoDiaMes()
    {
        return 0;
    }

    public boolean isHorarioVerao()
    {
        return false;
    }

    public Data getDataFutura(int dias)
    {
        /*
        Data novaData = new Data(dia,mes,ano);
        novaData.avancarDias(dias);
        return novaData;
         */
        return null;
    }

    @Override
    public String toString()
    {
        return (dia < 10 ? "0"+dia+"/" : dia+"/")+
               (mes < 10 ? "0"+mes+"/" : mes+"/")+
                ano;
    }
    
}
