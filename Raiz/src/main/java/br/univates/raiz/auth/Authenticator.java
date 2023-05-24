package br.univates.raiz.auth;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Authenticator
{
    private JAuthenticator tela;
    private ArrayList<? extends User> users;
    private User loggedUser;

    public Authenticator(ArrayList<? extends User> users)
    {
        this.users = users;
        this.tela = new JAuthenticator(null,true);
        this.loggedUser = null;
    }
    
   
    public boolean showDialog( boolean withRepetition )
    {
        if (withRepetition)
        {
            boolean repeat = true;
            while (repeat)
            {
                repeat = false;
                showDialog();
                if (!tela.isCanceled() && !isRight())
                {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos","Autenticação",JOptionPane.ERROR_MESSAGE);
                    repeat = true;
                }
            }
        }
        else
        {
            showDialog();
        }
        return (this.loggedUser != null);
    }
    
    public void showDialog()
    {
        tela.setVisible(true);
    }
    
    public boolean isRight()
    {
        boolean ok = false;
        if (!tela.isCanceled() &&
            !tela.getLogName().isEmpty() &&
            !tela.getSenha().isEmpty() )
        {
            for (User user: users)
            {
                if (user.getLogName().equals( tela.getLogName() ))
                {
                    if (user.getHashCode().equals( Authenticator.getHashCode( tela.getSenha() ) ))
                    {
                        this.loggedUser = user;
                        ok = true;
                        break;
                    }
                }
            }
        }
        return ok;
    }
    
    /**
     * Usado para gerar um hashcode para a senha. Somente este método deve
     * ser usado para isso, deixando a lógica de marcaramento da senha apenas
     * neste local. Se desejar gear um hashcode mais complexo, mude este método.
     * 
     * @param senha uma senha aberta para ser codificada
     * @return hashcode correspondente a senha recebida
     */
    public static String getHashCode(String senha)
    {
        return senha.hashCode()+"";
    }

    public User getLoggedUser()
    {
        return loggedUser;
    }
    
    
    
}
