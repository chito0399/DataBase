import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
// import escuela.Producto;
// import escuela.Alumno;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/NewVenta")
public class NewVenta extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			
			String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
			String password = getServletContext().getInitParameter("pass");


			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
		
			System.out.println(url);
			Connection con = DriverManager.getConnection(url,usuario,password);

			String cliente = req.getParameter("cliente");
			String correo = req.getParameter("correo");
			int telefono = Integer.parseInt(req.getParameter("cliente"));
			String fecha = req.getParameter("datepicker");
			int precio = req.getParameter("precio");
			int userTrabajador = req.getParameter("user_trabajador");

			

			Statement stat = con.createStatement();
			String sql = "SELECT * FROM trabajador";
			String sql2 = "";		
			
			ResultSet res1 = stat.executeQuery(sql);
			ResultSet res2 = stat.executeQuery(sql2);

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

            writer3.println("the vector size is "+productos.size());
            // writer3.println("hello "+productos.get(0).id);
            // writer3.println("hello "+productos.get(1).id);
            writer3.close();

			stat.close();
            con.close();

			request.setAttribute("productos", productos);

			RequestDispatcher disp = getServletContext().getRequestDispatcher("/showProducts.jsp");

			if(disp!=null){
				disp.forward(request, response);
			}

			


		}
		catch(Exception e){			
			e.printStackTrace();
		}
				
	}

}