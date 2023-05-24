package br.univates.raiz.auth.exemplo;

import br.univates.raiz.auth.Authenticator;
import br.univates.raiz.auth.User;
import br.univates.raiz.auth.exemplo.UserExemplo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main
{
    public static void main(String[] args)
    {
        User u1 = new UserExemplo("joão","joão".hashCode()+"");
        User u2 = new UserExemplo("maria","maria".hashCode()+"");
        User u3 = new UserExemplo("juca","juca".hashCode()+"");
        User u4 = new UserExemplo("carla","carla".hashCode()+"");
        
        ArrayList<User> vetor = new ArrayList();
        vetor.add(u1);
        vetor.add(u2);
        vetor.add(u3);
        vetor.add(u4);
        
        Authenticator auth = new Authenticator(vetor);
        
        auth.showDialog();
        
        if (auth.isRight())
        {
            // entrar no sistema
            System.out.println("Entrar no sistema");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
            System.exit(0);
        }
    }
}
