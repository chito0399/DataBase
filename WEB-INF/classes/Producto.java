import java.sql.*;
public class Producto{
    public int id;
    public String uso;            
    public Date fechaLlegada;  
    public Date fechaVenta;
    public float precioProveedor;            
    public float precioCliente;            
    public String proveedor;                      
    public int tabla;            
    public float ganancia;       

    public Producto(String uso, Date fechaLlegada, Date  fechaVenta ,float precioProveedor, float precioCliente, 
        String proveedor, int tabla, float ganancia){
        this.uso = uso; 
        this.fechaLlegada = fechaLlegada;
        this.fechaVenta = fechaVenta;
        this.precioProveedor = precioProveedor;
        this.precioCliente = precioCliente;
        this.proveedor = proveedor; 
        this.tabla = tabla;
        this.ganancia = ganancia;
    }

    public Producto(int id, String uso, Date fechaLlegada, Date  fechaVenta ,float precioProveedor, float precioCliente, 
        String proveedor, int tabla, float ganancia){
        this.id = id;
        this.uso = uso; 
        this.fechaLlegada = fechaLlegada;
        this.fechaVenta = fechaVenta;
        this.precioProveedor = precioProveedor;
        this.precioCliente = precioCliente;
        this.proveedor = proveedor; 
        this.tabla = tabla;
        this.ganancia = ganancia;
    }
}