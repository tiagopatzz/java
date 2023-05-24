package Login.Auth;

import java.util.Objects;

public class Usuario {
    private String logName;
    private String name;
    
    public Usuario(String logName, String name) {
        this.logName = logName;
        this.name = name;
    }
    
    public String getLogName() {
        return logName;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHashCode() {
        return Objects.hash(logName, name);
    }
}
