import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

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
            String fechaVenta = req.getParameter("fechaVenta");

            float precioProveedor = Float.parseFloat(req.getParameter("Pproveedor")) ;            
            float precioCliente = Float.parseFloat(req.getParameter("cliente"));            
            String proveedor = req.getParameter("proveedor");                      
            int tabla = Integer.parseInt(req.getParameter("tabla"));            
            float ganancia = Float.parseFloat(req.getParameter("ganancia"));      
            
            Producto newProduct = new Producto(uso, fechaLlegada, fechaVenta, precioProveedor, precioCliente, proveedor, tabla, ganancia);

            try{
                String base = getServletContext().getInitParameter("base");
                String usuario = getServletContext().getInitParameter("usuario");
                String pass = getServletContext().getInitParameter("pass");
                
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
                Connection con = DriverManager.getConnection(url,usuario,pass);
    
                Statement stat = con.createStatement();
                String sql = "insert into producto(Uso, fechaDeLlegada, fechaDeVenta, precioProveedor, precioCliente, proveedor, tabla, ganancia) values(" + uso + ", "  + fechaLlegada + ", "  + fechaVenta + ", " + precioProveedor + ", "  + precioCliente + ", "   + proveedor + ", "   + tabla + ", "  + ganancia + ");";
                
                ResultSet result = stat.executeQuery(sql);

                System.out.println("se agrego el nuevo producto");

                stat.close();
            	con.close();

            }catch(Exception ex){
                ex.printStackTrace();
                System.out.println("no se agrego el nuevo producto");
            }

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
