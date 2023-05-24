/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.exemplo3;

import br.univates.exemplo3.negocio.Funcionario;
import br.univates.raiz.persistence.Filter;

/**
 *
 * @author mouriac
 */
public class MeuFiltro implements Filter<Funcionario>
{

    @Override
    public boolean isAccept(Funcionario record)
    {
        return (record.getSalario() >= 1000);
    }
    
}
