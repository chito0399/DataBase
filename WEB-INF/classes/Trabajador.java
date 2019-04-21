import java.sql.*;
public class Trabajador{
    String nombre;
    String apellido;
    int cuenta;
    int edad;
    String correo;
    int telefono;
    String direccion;
    String puesto;
    String password;

    public Trabajador(String nombre, String apellido, int cuenta, int edad, String correo, String password, int telefono, String direccion, String puesto){
            this.nombre = nombre; 
            this.apellido = apellido; 
            this.cuenta = cuenta;
            this.edad = edad; 
            this.correo = correo;
            this.password = password;
            this.telefono = telefono; 
            this.direccion = direccion; 
            this.puesto = puesto;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String a){
        password = a;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String a){
        nombre = a;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String a){
        apellido = a;
    }

    public int getCuenta(){
        return cuenta;
    }

    public void setCuenta(int a){
        cuenta = a;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int a){
        edad = a;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String a){
        correo = a;
    }

    public int getTelefono(int telefono){
        return telefono;
    }

    public void setTelefono(int a){
        telefono = a;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String a){
        direccion = a;
    }

    public String getPuesto(){
        return puesto;
    }

    public void setPuesto(String a){
        puesto = a;
    }
}