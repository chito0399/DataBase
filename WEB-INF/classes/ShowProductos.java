import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Vector;
import java.text.SimpleDateFormat;  
import java.util.Date;

import javax.servlet.annotation.WebServlet;

@WebServlet("/showProducts")
public class ShowProductos extends HttpServlet{

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
			ResultSet result = null;
            try{
                String base = getServletContext().getInitParameter("base");
                String usuario = getServletContext().getInitParameter("usuario");
                String pass = getServletContext().getInitParameter("pass");
                
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
                Connection con = DriverManager.getConnection(url,usuario,pass);

                Statement stat = con.createStatement();                
                String sql = "SELECT * from `producto`";
                
                result = stat.executeQuery(sql);
                System.out.println("Sí se despliega todo de producto");

                stat.close();
            	con.close();

            }
            catch(Exception x){
                System.out.println("Error al ver los productos en la base de datos");
            }
            
            Vector<Producto> productos = new Vector<Producto>();
            while(result.next()){

				Producto aux = new Producto();

				aux.id = Integer.parseInt(result.getString("idProducto"));
				aux.uso = result.getString("Uso");
				aux.fechaLlegada = result.getString("fechaDeLlegada");
                aux.fechaVenta = result.getString("fechaDeVenta");               
                aux.precioProveedor = Float.parseFloat(result.getString("precioProveedor"));
                aux.precioCliente = Float.parseFloat(result.getString("precioCliente"));
                aux.proveedor = result.getString("proveedor");
                aux.tabla = Integer.parseInt(result.getString("tabla"));
                aux.ganancia = Float.parseFloat(result.getString("ganancia"));

				productos.add(aux);

            }

			res.setContentType("text/html");
			PrintWriter out = res.getWriter();

			req.setAttribute("productos", productos);

			RequestDispatcher disp = getServletContext().getRequestDispatcher("/showProducts.jsp");

			if(disp!=null){
				disp.forward(req,res);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	

}
