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

    public void setId(int id){
        this.id = id; 
    }
    public int getId(){
        return id;
    }

    public void setFecha(String fechaExpedicion){
        this.fechaExpedicion = fechaExpedicion; 
    }
    public String getFecha(){
        return fechaExpedicion;
    }

    public void setPrecio(float precioTotal){
        this.precioTotal = precioTotal; 
    }
    public float getPrecio(){
        return precioTotal;
    }

    public void seCliente(int idCliente){
        this.idCliente = idCliente; 
    }
    public int getCliente(){
        return idCliente;
    }

    public void setTrabajador(int idTrabajador){
        this.idTrabajador = idTrabajador; 
    }
    public int geTrabajador(){
        return idTrabajador;
    }
}