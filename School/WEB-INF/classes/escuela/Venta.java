package escuela;
public class Venta{
    private int id; 
    private String fechaExpedicion; 
    private float precioTotal; 
    private int idCliente; 
    private int idTrabajador;

    public Venta(){

    }

    public Venta(String fechaExpedicion, float precioTotal, int idCliente, int idTrabajador){
        this.fechaExpedicion = fechaExpedicion; 
        this.precioTotal = precioTotal; 
        this.idCliente = idCliente; 
        this.idTrabajador = idTrabajador;
    }

    public Venta(int id, String fechaExpedicion, float precioTotal, int idCliente, int idTrabajador){
        this.id = id;
        this.fechaExpedicion = fechaExpedicion; 
        this.precioTotal = precioTotal; 
        this.idCliente = idCliente; 
        this.idTrabajador = idTrabajador;
    }

    public void setId(int a){
        this.id = a; 
    }
    public int getId(){
        return id;
    }

    public void setFecha(String a){
        this.fechaExpedicion = a; 
    }
    public String getFecha(){
        return fechaExpedicion;
    }

    public void setPrecio(float a){
        this.precioTotal = a; 
    }
    public float getPrecio(){
        return precioTotal;
    }

    public void setCliente(int a){
        this.idCliente = a; 
    }
    public int getCliente(){
        return idCliente;
    }

    public void setTrabajador(int a){
        this.idTrabajador = a; 
    }
    public int geTrabajador(){
        return idTrabajador;
    }
}