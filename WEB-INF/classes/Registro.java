import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet("/registro")
public class Registro extends HttpServlet{

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
            String apellido = req.getParameter("apellido");
            int username = Integer.parseInt(req.getParameter("username"));
            String password = req.getParameter("password");
            int edad = Integer.parseInt(req.getParameter("edad"));
            String correo = req.getParameter("correo");
            int telefono = Integer.parseInt(req.getParameter("telefono"));
            String direccion = req.getParameter("direccion");
			String puesto = req.getParameter("puesto");
			Cuenta cuenta = new Cuenta(username, password);

			Trabajador newTrabajador = new Trabajador(nombre, apellido, cuenta, edad, correo, telefono, direccion, puesto);
			
		try{
			String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");
            
            Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);

			Statement stat = con.createStatement();
			String sql2 = "INSERT INTO `cuenta` (`ID`,`contrasenia`) VALUES ("+ username+" ," +password+ ");";
            String sql = "INSERT INTO `trabajador` ( `direccion`, `telefono`, `correo`, `puesto`, `edad`, `nombre`, `apellido`, `cuenta`, `constrasenia`) values(" + direccion + ", " + telefono + ", "  + correo + ", "  + puesto + ", "  + edad + ", "   + nombre + ", "   + apellido + ", "  + username + ", " + password +   ");";
            
			ResultSet result = stat.executeQuery(sql);
			ResultSet result2 = stat.executeQuery(sql2);
			System.out.println("Sí se guard el nuevo trabajador");
			stat.close();
			con.close();
        }
        catch(Exception x){
        	System.out.println("Error al ingresar un nuevo trabajador");
        }
            
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();

			req.setAttribute("trabajador", newTrabajador);

			RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");

			if(disp!=null){
				disp.forward(req,res);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	

}
