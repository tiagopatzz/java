/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.exemplo3;

import br.univates.exemplo3.negocio.Funcionario;
import br.univates.exemplo3.persistencia.FuncionarioDaoPostgres;
import br.univates.raiz.Data;
import br.univates.raiz.persistence.Filter;
import br.univates.raiz.persistence.IDao;
import br.univates.raiz.persistence.InvalidKeyException;
import br.univates.raiz.persistence.KeyViolationException;
import br.univates.raiz.persistence.NotFoundException;
import java.util.ArrayList;

/**
 *
 * @author mouriac
 */
public class TesteDoDao
{
    public static void main(String[] args)
    {
        /* EXEMPLO PARA SALVAR
        Funcionario f = new Funcionario(3,"Carlos","Rua das Flores, 33",
                new Data(),"carlos","48690",7400);
        
        FuncionarioDao dao = new FuncionarioDao();
        dao.create(f);
        */
        
        /**
         * EXEMPLO PARA LER TODOS
         *
        FuncionarioDaoPostgres dao = new FuncionarioDaoPostgres();
        ArrayList<Funcionario> lista = dao.readAll();
        
        for (Funcionario f: lista)
        {
            System.out.println( f.getName() );
        }
        */
        
        
        /**
         * EXEMPLO PARA LER TODOS COM FILTRO
         *
        FuncionarioDaoPostgres dao = new FuncionarioDaoPostgres();
        ArrayList<Funcionario> lista = dao.readAll();
        
        for (Funcionario f: lista)
        {
            System.out.println( f.getName() );
        }
        */
 
        
        
        Funcionario func = new Funcionario(3,"Carlos","Rua das Flores, 33",
                new Data(),"carlos","48690",400);
        
        
        
        IDao<Funcionario,Integer> dao = new FuncionarioDaoPostgres();
        
        ArrayList<Funcionario> lista = dao.readAll( new Filter<Funcionario>() {
            @Override
            public boolean isAccept(Funcionario record)
            {
                return (record.getSalario() > 1000);
            }
        } );
        
        for (Funcionario f: lista)
        {
            System.out.println( f.getName() );
        }
        
    }
}
