package br.univates.exemplo3.persistencia;

import br.univates.exemplo3.negocio.Historico;
import br.univates.raiz.persistence.IDao;

public class DaoFactory
{
    public static IDao<Historico,String> criarHistoricoDao()
    {
        return new HistoricoDaoTxt();
    }
}
