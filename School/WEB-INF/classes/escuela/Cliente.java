package escuela;
public class Cliente{
    private int id; 
    private int telefono; 
    private String correo; 

    public Cliente(){

    }

    public Cliente(int id, int telefono, String correo){
        this.id = id; 
        this.telefono = telefono; 
        this.correo = correo;
    }

    public Cliente(int telefono, String correo){
        this.telefono = telefono; 
        this.correo = correo;
    }

    public void setId(int id){
        this.id = id; 
    }
    public int getId(){
        return id;
    }

    public void setTelefono(int telefono){
        this.telefono = telefono; 
    }
    public int getTelefono(){
        return telefono;
    }

    public void setCorreo(String correo){
        this.correo = correo; 
    }
    public String getCorreo(){
        return correo;
    }
}