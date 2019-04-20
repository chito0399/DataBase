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
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            int edad = Integer.parseInt(req.getParameter("edad"));
            String correo = req.getParameter("correo");
            String telefono = req.getParameter("telefono");
            String direccion = req.getParameter("direccion");
			String puesto = req.getParameter("puesto");

			Trabajador newTrabajador = new Trabajador(nombre, apellido, username, password, edad, correo, telefono, direccion, puesto);
			
		try{
			String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");
            
            Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);

            Statement stat = con.createStatement();
            String sql = "insert into trabajador(direccion, telefono, correo, puesto, edad, nombre, apellido, username, constrasenia) values(" + direccion + ", " + telefono + ", "  + correo + ", "  + puesto + ", "  + edad + ", "   + nombre + ", "   + apellido + ", "  + username + ", " + password +   ");";
            
            ResultSet result = stat.executeQuery(sql);
        }
        catch(Exception x){
        	System.out.println("Hola bb");
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
