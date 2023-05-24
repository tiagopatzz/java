package br.univates.exemplo3;

import br.univates.exemplo3.apresentacao.Tela;
import br.univates.raiz.Horario;
import br.univates.raiz.auth.Authenticator;
import java.util.Date;

public class Main {

    public static void main(String[] args) 
    {
        //System.out.println( Authenticator.getHashCode( "123" ) );
        
        //Date dt = new Date( 2023-1900, 3, 26 );
        
        Horario h = new Horario(8,8,5);
        
        System.out.println( h.getHorario( Horario.HHMMSS ) );
        
        //Tela t = new Tela();
        //t.setVisible(true);
    }
}
