package br.univates.exemplo3.persistencia;

import br.univates.exemplo3.negocio.Historico;
import br.univates.exemplo3.negocio.Retangulo;
import br.univates.raiz.Arquivo;
import br.univates.raiz.Data;
import br.univates.raiz.Horario;
import br.univates.raiz.InvalidDateException;
import br.univates.raiz.InvalidDateFormateException;
import br.univates.raiz.persistence.Filter;
import br.univates.raiz.persistence.IDao;
import br.univates.raiz.persistence.InvalidKeyException;
import br.univates.raiz.persistence.KeyViolationException;
import br.univates.raiz.persistence.NotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HistoricoDaoTxt implements IDao<Historico,String>
{
    public void create(Historico historico) throws KeyViolationException, InvalidKeyException
    {
        ArrayList<Historico> lista = readAll();

        Arquivo a = new Arquivo("historico.dat");
        if (a.abrirEscrita())
        {
            for (Historico h: lista)
            {
                a.escreverLinha( h.toString() );
            }
            a.escreverLinha(historico.toString());
            a.fecharArquivo();
        }
    }
    
    public ArrayList<Historico> readAll()
    {
        ArrayList<Historico> lista = new ArrayList();
        Arquivo a = new Arquivo("historico.dat");
        if (a.abrirLeitura())
        {
            String linha = a.lerLinha();
            while (linha != null)
            {
                //data;horario;base;altura
                try
                {
                    String[] partes = linha.split(";");
                    Data dt = new Data(partes[0]);
                    Horario hr = new Horario(partes[1]);
                    double base = Double.parseDouble(partes[2]);
                    double altura = Double.parseDouble(partes[3]);
                    Retangulo ret = new Retangulo(base,altura);
                    
                    Historico hist = new Historico(dt,hr,ret);
                    lista.add(hist);
                } 
                catch (InvalidDateException | InvalidDateFormateException ex)
                {
                    
                } 
                
                linha = a.lerLinha();
            }
            a.fecharArquivo();
        }
        return lista;
    }

   
    @Override
    public Historico read(String primaryKey) throws NotFoundException
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public ArrayList<Historico> readAll(Filter<Historico> filtro)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Historico objeto) throws NotFoundException
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String primaryKey) throws NotFoundException
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
