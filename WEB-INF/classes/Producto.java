


public class Producto{
    private int id;
    private String uso;            
    private String fechaLlegada;  
    private String fechaVenta;
    private float precioProveedor;            
    private float precioCliente;            
    private String proveedor;                      
    private int tabla;            
    private float ganancia;   


    // public int id;
    // public String uso;            
    // public String fechaLlegada;  
    // public String fechaVenta;
    // public float precioProveedor;            
    // public float precioCliente;            
    // public String proveedor;                      
    // public int tabla;            
    // public float ganancia; 

    // public Producto(String uso, String fechaLlegada, String  fechaVenta ,float precioProveedor, float precioCliente, 
    //     String proveedor, int tabla, float ganancia){
    //     this.uso = uso; 
    //     this.fechaLlegada = fechaLlegada;
    //     this.fechaVenta = fechaVenta;
    //     this.precioProveedor = precioProveedor;
    //     this.precioCliente = precioCliente;
    //     this.proveedor = proveedor; 
    //     this.tabla = tabla;
    //     this.ganancia = ganancia;
    // }

    // public Producto(int id, String uso, String fechaLlegada, String  fechaVenta ,float precioProveedor, float precioCliente, 
    //     String proveedor, int tabla, float ganancia){
    //     this.id = id;
    //     this.uso = uso; 
    //     this.fechaLlegada = fechaLlegada;
    //     this.fechaVenta = fechaVenta;
    //     this.precioProveedor = precioProveedor;
    //     this.precioCliente = precioCliente;
    //     this.proveedor = proveedor; 
    //     this.tabla = tabla;
    //     this.ganancia = ganancia;
    // }
    // public Producto(){


    // }

    public int getId(){
        return id;
    }

    public void setId(int a){
        id=a;
    }
    public String getUso(){
        return uso;
    }

    public void setUso(String a){
        uso=a;
    }
    public String getFechaLlegada(){
        return fechaLlegada;
    }

    public void setFechaLlegada(String a){
        fechaLlegada=a;
    }
    public String getFechaVenta(){
        return fechaVenta;
    }

    public void setFechaVenta(String a){
        fechaVenta=a;
    }
    
    public float getPrecioProveedor(){
        return precioProveedor;
    }

    public void setPrecioProveedor(float a){
        precioProveedor=a;
    }
    public float getPrecioCliente(){
        return precioCliente;
    }

    public void setPrecioCliente(float a){
        precioCliente=a;
    }
    public String getProveedor(){
        return proveedor;
    }

    public void setProveedor(String a){
        proveedor=a;
    }
    public int getTabla(){
        return tabla;
    }

    public void setTabla(int a){
        tabla=a;
    }
    public float getGanancia(){
        return ganancia;
    }

    public void setGanancia(float a){
        ganancia=a;
    }
    


}