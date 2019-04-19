public class Producto{
    public String nombre;
    public String uso;            
    public String fechaLlegada;  
    public float precioProveedor;            
    public float precioCliente;            
    public String proveedor;                      
    public String tabla;            
    public float ganancia;       

    public Producto(String nombre, String uso, String fechaLlegada, float precioProveedor, float precioCliente, 
        String proveedor, String tabla, float ganancia){
        this.nombre = nombre; 
        this.uso = uso; 
        this.fechaLlegada = fechaLlegada;
        this.precioProveedor = precioProveedor;
        this.precioCliente = precioCliente;
        this.proveedor = proveedor; 
        this.tabla = tabla;
        this.ganancia = ganancia;
    }
}