package Login.Auth;

import java.util.ArrayList;

public class Authenticator
{
    private ArrayList<Usuario> users;
    private Usuario loggedUser;

    public Authenticator(ArrayList<Usuario> users)
    {
        this.users = users;
    }
    
    public void showDialog()
    {
        JAuthenticator tela = new JAuthenticator(null,true);
        tela.setVisible(true);
        
        System.out.println( tela.getLogName() );
        System.out.println( tela.getSenha() );
    }
    
    public boolean isRight()
    {
        return false;
    }
    
    public static String getHashCode(String senha)
    {
        return senha.hashCode()+"";
    }
    
    
}
