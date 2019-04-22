import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import escuela.Producto;
import javax.servlet.annotation.WebServlet;
import java.util.Vector;
@WebServlet("/RegistroProducto")
public class RegistroProducto extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
            PrintWriter writer = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto1.txt", "UTF-8");
            PrintWriter writer2 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto2.txt", "UTF-8");
            PrintWriter writer3 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto3.txt", "UTF-8");

            writer.println("The first lines");
            writer.println("The second line");

            String base = getServletContext().getInitParameter("base");
            String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");
                
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);
            writer.close();
    
            Statement stat = con.createStatement();

            int id= Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String uso = request.getParameter("uso");            
            String fechaLlegada = request.getParameter("fecha");  
            String fechaVenta = request.getParameter("fechaVenta");

            float precioProveedor = Float.parseFloat(request.getParameter("Pproveedor")) ;            
            float precioCliente = Float.parseFloat(request.getParameter("cliente"));            
            String proveedor = request.getParameter("proveedor");                      
            int tabla = Integer.parseInt(request.getParameter("tabla"));            
            float ganancia = Float.parseFloat(request.getParameter("ganancia"));      
            
            Producto newProduct = new Producto(id, nombre, uso, fechaLlegada, fechaVenta, precioProveedor, precioCliente, proveedor, tabla, ganancia);

            
            
            String sql = "INSERT INTO producto values("+id+",'"+nombre+"','" + uso + "', '"  + fechaLlegada + "', '"  + fechaVenta + "', " + precioProveedor + ", "  + precioCliente + ", '"   + proveedor + "', "   + tabla + ","  + ganancia + ");";
                
            stat.executeUpdate(sql);
            writer2.println(sql);
            System.out.println("se agrego el nuevo producto");

            String sql2 = "SELECT * FROM producto where idProducto="+id+";";

            writer2.println(sql2);
            writer2.close();


            ResultSet res = stat.executeQuery(sql2);

            Vector<Producto> productos = new Vector<Producto>();

            while(res.next()){
                Producto aux = new Producto();
                 aux.setId(res.getInt("idProducto"));
                aux.setNombre(res.getString("nombre"));
                aux.setUso(res.getString("Uso"));
                aux.setFechaLlegada(res.getString("fechaDeLlegada"));
                aux.setFechaVenta(res.getString("fechaDeVenta"));
                aux.setPrecioProveedor(res.getFloat("precioProveedor"));
                aux.setPrecioCliente(res.getFloat("precioCliente"));
                aux.setProveedor(res.getString("proveedor"));
                aux.setTabla(res.getInt("tabla"));
                aux.setGanancia(res.getFloat("ganancia"));
                productos.add(aux);
            }
            
            stat.close();
            con.close();
            
            request.setAttribute("productos",productos);
            RequestDispatcher disp =  getServletContext().getRequestDispatcher("/productoRegistrado.jsp");
            
            if(disp!=null){
                disp.forward(request,response);
            }
		}
		catch(Exception e){
			try{
                PrintWriter writer4 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto4.txt", "UTF-8");
                e.printStackTrace();
                writer4.println(e);
                writer4.close();
            }
            catch(Exception e2){
                try{
                PrintWriter writer5 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto5.txt", "UTF-8");
                e.printStackTrace();
                writer5.println(e);
                writer5.close();
            }
            catch(Exception e3){
                e3.printStackTrace();
            }   
            }   
          
		}

	}

	

}
