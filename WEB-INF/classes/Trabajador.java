import java.sql.*;
public class Trabajador{
    String nombre;
    String apellido;
    Cuenta cuenta;
    int edad;
    String correo;
    int telefono;
    String direccion;
    String puesto;

    public Trabajador(String nombre, String apellido, Cuenta cuenta, int edad, String correo, int telefono, String direccion, String puesto){
            this.nombre = nombre; 
            this.apellido = apellido; 
            this.cuenta = cuenta;
            this.edad = edad; 
            this.correo = correo;
            this.telefono = telefono; 
            this.direccion = direccion; 
            this.puesto = puesto;
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

    public Cuenta getCuenta(){
        return cuenta;
    }

    public void setCuenta(Cuenta a){
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