public class Venta{
    public int id; 
    public String fechaExpedicion;
    public float precioTotal; 
    public Cliente cliente;
    public Trabajador trabajador;

    public Venta(){

    }

    //sin ID
    public Venta(String fechaExpedicion, float precioTotal, Cliente cliente, Trabajador trabajador ){
        this.fechaExpedicion = fechaExpedicion; 
        this.precioTotal = precioTotal; 
        this.cliente = cliente; 
        this.trabajador = trabajador;
    }

    //sin ID y TRABAJADOR
    public Venta(String fechaExpedicion, float precioTotal, Cliente cliente ){
        this.fechaExpedicion = fechaExpedicion; 
        this.precioTotal = precioTotal; 
        this.cliente = cliente; 
    }

    //TODO
    public Venta(int id, String fechaExpedicion, float precioTotal, Cliente cliente, Trabajador trabajador ){
        this.id = id;
        this.fechaExpedicion = fechaExpedicion; 
        this.precioTotal = precioTotal; 
        this.cliente = cliente; 
        this.trabajador = trabajador;
    }
}