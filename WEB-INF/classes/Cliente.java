public class Cliente{
    private int id; 
    private int telefono; 
    private String correo; 


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