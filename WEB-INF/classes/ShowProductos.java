import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Vector;

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

            try{
                String base = getServletContext().getInitParameter("base");
                String usuario = getServletContext().getInitParameter("usuario");
                String pass = getServletContext().getInitParameter("pass");
                
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
                Connection con = DriverManager.getConnection(url,usuario,pass);

                Statement stat = con.createStatement();                
                String sql = "SELECT * from `producto`";
                
                ResultSet result = stat.executeQuery(sql);
                System.out.println("Sí se despliega todo de producto");
            }
            catch(Exception x){
                System.out.println("Error al ver los productos en la base de datos");
            }
            
            Vector<Producto> productos = new Vector<Producto>();
            while(res.next()){

				Alumno aux = new Alumno();

				aux.id(res.getString("idProducto"));
				aux.uso(res.getString("Uso"));
				aux.fechaLlegada(res.getString("fechaDeLlegada"));
                aux.fechaVenta(res.getInt("fechaDeVenta"));                
                aux.precioProveedor(res.getInt("precioProveedor"));
                aux.precioCliente(res.getInt("precioCliente"));
                aux.proveedor(res.getInt("proveedor"));
                aux.tabla(res.getInt("tabla"));
                aux.ganancia(res.getInt("ganancia"));

				productos.add(aux);

            }
            
            stat.close();
            con.close();

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
