import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet("/RegistroProducto")
public class RegistroProducto extends HttpServlet{

	public void init(ServletConfig config){
		try{
			super.init(config);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res){

		try{

            String nombre = req.getParameter("nombre");
            String uso = req.getParameter("uso");            
            String fechaLlegada = req.getParameter("fecha");  
            float precioProveedor = Float.parseFloat(req.getParameter("Pproveedor")) ;            
            float precioCliente = Float.parseFloat(req.getParameter("cliente"));            
            String proveedor = req.getParameter("proveedor");                      
            String tabla = req.getParameter("tabla");            
            float ganancia = Float.parseFloat(req.getParameter("ganancia"));      
            
            Producto newProduct = new Producto(nombre, uso, fechaLlegada, precioProveedor, precioCliente, proveedor, tabla, ganancia);

            String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");
            
            Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);

            Statement stat = con.createStatement();
            String sql = "insert into producto(nombre, uso, fechaLlegada, precioProveedor, precio_cliente, proveedor, tabla, ganancia) values(" + nombre + ", " + uso + ", "  + fechaLlegada + ", "  + precioProveedor + ", "  + precioCliente + ", "   + proveedor + ", "   + tabla + ", "  + ganancia + ");";
            
            ResultSet result = stat.executeQuery(sql);

            stat.close();
            con.close();
            
            res.setContentType("text/html");
			PrintWriter out = res.getWriter();

            req.setAttribute("producto", newProduct);
            
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/productoRegistrado.jsp");
            
            

			if(disp!=null){
				disp.forward(req,res);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	

}
