import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import escuela.Trabajador;
import escuela.Cuenta;
import javax.servlet.annotation.WebServlet;

@WebServlet("/registro")
public class Registro extends HttpServlet{

	// public void init(ServletConfig config){
	// 	try{
	// 		super.init(config);
	// 	}
	// 	catch(Exception e){
	// 		e.printStackTrace();
	// 	}
		
		
	// }

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

            int id= Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            int username = Integer.parseInt(request.getParameter("username"));
            String password = request.getParameter("password");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String correo = request.getParameter("correo");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String direccion = request.getParameter("direccion");
			String puesto = request.getParameter("puesto");

			Cuenta cuenta = new Cuenta(username, password);


			Trabajador newTrabajador = new Trabajador(id, nombre, apellido, cuenta, edad, correo, telefono, direccion, puesto);
            
            Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);

			Statement stat = con.createStatement();

			String sql2 = "INSERT INTO cuenta VALUES ("+ username+" ,'" +password+ "');";
			writer3.println(sql2);
            String sql = "INSERT INTO trabajador values("+id+", '" + direccion + "', " + telefono + ", '"  + correo + "', '"  + puesto + "', "  + edad + ", '"   + nombre + "', '"   + apellido + "', "  + username + ", '" + password +   "');";
            writer2.println(sql);
			stat.executeUpdate(sql2);
			stat.executeUpdate(sql);
			System.out.println("Sí se guard el nuevo trabajador");
			writer2.close();
			writer3.close();
			stat.close();
			con.close();
        
            
			// res.setContentType("text/html");
			// PrintWriter out = res.getWriter();

			// req.setAttribute("trabajador", newTrabajador);

			RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");

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
