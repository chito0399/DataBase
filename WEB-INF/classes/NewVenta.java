import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
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

			int cliente = Integer.parseInt(req.getParameter("cliente"));
			String correo = req.getParameter("correo");
			int telefono = Integer.parseInt(req.getParameter("cliente"));
			String fecha = req.getParameter("datepicker");
			Float precio = Float.parseFloat(req.getParameter("precio"));
			int userTrabajador = req.getParameter("user_trabajador");

			Cliente newCliente = new Cliente(cliente, telefono, correo);
			Venta venta = new Venta(fecha, precio, cliente, userTrabajador);

			Statement stat = con.createStatement();
			String sql2 = "INSERT INTO venta (fechaDeExpedicion, precioTotal, idCliente, idTrabajador) VALUES(" + fecha + ", " + precio + ", " + cliente + ", "  + userTrabajador + ", "  ");";		

			ResultSet res2 = stat.executeUpdate(sql2);

			Vector<Venta> ventaVector = new Vector<Venta>();

			ventaVector.add(venta);                        

			stat.close();
            con.close();

			request.setAttribute("ventaVector", ventaVector);

			RequestDispatcher disp = getServletContext().getRequestDispatcher("/showVenta.jsp");

			if(disp!=null){
				disp.forward(request, response);
			}

			


		}
		catch(Exception e){			
			e.printStackTrace();
		}
				
	}

}