import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Vector;
import escuela.Cliente;
import escuela.Venta;

import javax.servlet.annotation.WebServlet;

@WebServlet("/NewVenta")
public class NewVenta extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			PrintWriter writer = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto1.txt", "UTF-8");
            PrintWriter writer2 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto2.txt", "UTF-8");
            PrintWriter writer3 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto3.txt", "UTF-8");
			
			String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
			String password = getServletContext().getInitParameter("pass");
			writer.println("The first lines");
            writer.println("The second line");

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
		
			System.out.println(url);
			Connection con = DriverManager.getConnection(url,usuario,password);

			int idVenta=Integer.parseInt(request.getParameter("id"));
			int cliente = Integer.parseInt(request.getParameter("cliente"));
			String correo = request.getParameter("correo");
			int telefono = Integer.parseInt(request.getParameter("telefono"));
			String fecha = request.getParameter("datepicker");
			Float precio = Float.parseFloat(request.getParameter("precio"));
			int userTrabajador =Integer.parseInt(request.getParameter("user_trabajador"));

			Cliente newCliente = new Cliente(cliente, telefono, correo);
			Venta venta = new Venta(idVenta, fecha, precio, cliente, userTrabajador);

			Statement stat = con.createStatement();
			String sql = "INSERT INTO venta VALUES( "+idVenta+", '" + fecha + "', " + precio + ", " + cliente + ", "  + userTrabajador + ");";		
			String sql2 = "INSERT INTO cliente VALUES(" + cliente + "," + telefono+ ",'" + correo +"');";

			stat.executeUpdate(sql2);

			stat.executeUpdate(sql);

			// ResultSet res = stat.executeQuery(sql2);

			String sql3 = "SELECT * FROM venta where idVenta="+idVenta+";";

            writer2.println(sql2);
            


            ResultSet res = stat.executeQuery(sql3);

            Vector<Venta> ventas = new Vector<Venta>();

            while(res.next()){
                Venta aux = new Venta();

               	aux.setId(res.getInt("idVenta"));

               	writer2.println("HolaBB "+res.getInt("idVenta"));

                aux.setFecha(res.getString("fechaDeExpedicion"));

                writer2.println("HolaCarnal "+res.getString("fechaDeExpedicion"));

                aux.setPrecio(res.getFloat("precioTotal"));
                aux.setCliente(res.getInt("idCliente"));
                aux.setTrabajador(res.getInt("idTrabajador"));
                
                ventas.add(aux);
            }
            writer2.close();
            
            stat.close();
            con.close();
            
            request.setAttribute("ventas", ventas);
            RequestDispatcher disp =  getServletContext().getRequestDispatcher("/showVenta.jsp");
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