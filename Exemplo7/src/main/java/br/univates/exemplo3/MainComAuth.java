package br.univates.exemplo3;

import br.univates.exemplo3.apresentacao.Tela;
import br.univates.exemplo3.negocio.Funcionario;
import br.univates.exemplo3.persistencia.FuncionarioDaoPostgres;
import br.univates.raiz.auth.Authenticator;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class MainComAuth {

    public static void main(String[] args) 
    {
        Sys sys = Sys.getInstance();
        
        FuncionarioDaoPostgres dao = new FuncionarioDaoPostgres();
        ArrayList<Funcionario> users = dao.readAll();
        
        Authenticator auth = new Authenticator( users );

        if (auth.showDialog(true))
        {
            sys.setUser( auth.getLoggedUser() );
            
            Tela t = new Tela();
            t.setVisible(true);
        }       
        
    }
}
