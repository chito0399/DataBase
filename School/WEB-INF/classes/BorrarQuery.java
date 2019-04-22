import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import escuela.Alumno;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/Prueba")
public class BorrarQuery extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			PrintWriter writer = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/prueba.txt", "UTF-8");
			PrintWriter writer2 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/prueba2.txt", "UTF-8");
			PrintWriter writer3 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/prueba3.txt", "UTF-8");
			writer.println("The first line");
			writer.println("The second line");
			
			String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
			String password = getServletContext().getInitParameter("pass");


			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
			//String url = "jdbc:mysql://localhost/"+base; probarlo asi
			writer.close();
			System.out.println(url);
			Connection con = DriverManager.getConnection(url,usuario,password);


			Statement stat = con.createStatement();
			String sql="5ri205i23";


			String carrera2 = request.getParameter("carrera2");
			
			writer2.println(sql);
			writer2.close();


			if(!carrera2.equals("")){
				
				sql = "DELETE FROM alumno where carrera='"+ carrera2 + "';";
				writer3.println(sql);
				writer3.close();
			

				stat.executeUpdate(sql);
			}
			else{
				writer3.println(":(");
				writer3.close();
			}
			// ResultSet res = stat.executeUpdate(sql);
			// Vector<Alumno> alumnos = new Vector<Alumno>();
			// while(res.next()){
			// 	Alumno aux = new Alumno();
			// 	aux.setNombre(res.getString("nombre"));
			// 	aux.setMatricula(res.getString("matricula"));
			// 	aux.setCarrera(res.getString("carrera"));
			// 	aux.setEdad(res.getInt("edad"));
			// 	alumnos.add(aux);
			// }
			
			stat.close();
			con.close();
			
			// request.setAttribute("alumnos",alumnos);
			// RequestDispatcher disp =  getServletContext().getRequestDispatcher("/index.html");
			// if(disp!=null){
			// 	disp.forward(request,response);
			// }


		}
		catch(Exception e){
			try{
				PrintWriter writer4 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/prueba4.txt", "UTF-8");
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