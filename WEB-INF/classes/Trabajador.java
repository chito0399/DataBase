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

    public Trabajador(String nombre, String apellido, int username, String password, int edad, String correo, int telefono, String direccion, String puesto){
            this.nombre = nombre; 
            this.apellido = apellido; 
            this.cuenta = new Cuenta(username, password);
            this.edad = edad; 
            this.correo = correo;
            this.telefono = telefono; 
            this.direccion = direccion; 
            this.puesto = puesto;
    }

}