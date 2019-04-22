package escuela;
public class Cuenta{
    private int username;
    private String password;

    public Cuenta (int username, String password){
        this.username = username; 
        this.password = password;
    }

    public void setUsername(int username){
        this.username = username;
    }

    public int getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    } 
}