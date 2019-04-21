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


	public void doPost(HttpServletRequest req, HttpServletResponse res){

		try{

			PrintWriter writer = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto1.txt", "UTF-8");
			PrintWriter writer2 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto2.txt", "UTF-8");
			PrintWriter writer3 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto3.txt", "UTF-8");

			writer.println("The first line");
			writer.println("The second line");

			ResultSet result = null;
            	
                String base = getServletContext().getInitParameter("base");
                String usuario = getServletContext().getInitParameter("usuario");
                String pass = getServletContext().getInitParameter("pass");
                
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost/"+base"?useSSL=false&allowPublicKeyRetrieval=true";
                Connection con = DriverManager.getConnection(url,usuario,pass);
                writer.close();

                Statement stat = con.createStatement();                
                String sql = "SELECT * from producto";
                
                result = stat.executeQuery(sql);
                System.out.println("Sí se despliega todo de producto");
                writer2.println(sql);
				writer2.close();

                

            
            
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

			stat.close();
            con.close();

			req.setAttribute("productos", productos);

			RequestDispatcher disp = getServletContext().getRequestDispatcher("/showProducts.jsp");

			if(disp!=null){
				disp.forward(req,res);
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
				e2.printStackTrace();
			}
		}

	}

	

}
