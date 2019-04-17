public class Trabajador{
    String nombre;
    String apellido;
    String username;
    String password;
    int edad;
    String correo;
    String telefono;
    String direccion;
    String puesto;

    public Trabajador(String nombre, String apellido, String username, String password, int edad, 
        String correo, String telefono, String direccion, String puesto){
            this.nombre = nombre; 
            this.apellido = apellido; 
            this.username = username; 
            this.password = password; 
            this.edad = edad; 
            this.correo = correo;
            this.telefono = telefono; 
            this.direccion = direccion; 
            this.puesto = puesto;
    }

}