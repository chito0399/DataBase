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

			int cliente = Integer.parseInt(request.getParameter("cliente"));
			String correo = request.getParameter("correo");
			int telefono = Integer.parseInt(request.getParameter("cliente"));
			String fecha = request.getParameter("datepicker");
			Float precio = Float.parseFloat(request.getParameter("precio"));
			int userTrabajador =Integer.parseInt(request.getParameter("user_trabajador"));
			String cl = Integer.toString(cliente);
			String tr = Integer.toString(userTrabajador);
			String pr = Float.toString(precio);

			Cliente newCliente = new Cliente(cliente, telefono, correo);
			Venta venta = new Venta(fecha, precio, cliente, userTrabajador);

			Statement stat = con.createStatement();
			String sql = "INSERT INTO venta (fechaDeExpedicion, precioTotal, idCliente, idTrabajador) VALUES( " + fecha + ", " + pr + ", " + cl + ", "  + tr + ");";		

			ResultSet res2 = stat.executeQuery(sql);

			Vector<Venta> ventaVector = new Vector<Venta>();

			ventaVector.add(venta);                        

			stat.close();
            con.close();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

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