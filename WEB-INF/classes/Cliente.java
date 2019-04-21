public class Cliente{
    public int id; 
    public int telefono; 
    public String correo;

    public Cliente(int telefono, String correo){
        this.telefono = telefono; 
        this.correo = correo;
    }

    public Cliente(int id, int telefono, String correo){
        this.id = id; 
        this.telefono = telefono; 
        this.correo = correo;
    }

    public Cliente(){
        
    }
    
}