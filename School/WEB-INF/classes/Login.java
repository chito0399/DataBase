import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import escuela.Trabajador;
import javax.servlet.annotation.WebServlet;
import java.util.Vector;

@WebServlet("/Login")
public class Login extends HttpServlet{

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
            
            Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);
            writer.close();

            int username = Integer.parseInt(request.getParameter("username"));
            String password = request.getParameter("password");            


            Statement stat = con.createStatement();

            String sql ="select * from trabajador;";
            // String sql = "SELECT EXISTS(select * FROM trabajador where cuenta="+username+" and contrasenia='"+password+"');";
            
            ResultSet res = stat.executeQuery(sql);



            // ResultSet = stat.executeQuery(sql);;

            // int check=result.getInt(1);


            Vector<Trabajador> productos = new Vector<Trabajador>();
            int checkCuenta;
            String checkContraseña;
            String nombre="";
            boolean checkLog = false;
            while(res.next()){
                
                if(res.getInt("cuenta")==username && res.getString("contrasenia").equals(password)){
                    nombre=res.getString("nombre");

                    checkLog=true;
                    break;
                }

            }
            writer3.println(nombre);
            writer3.close();


            stat.close();
            con.close();


            
            //request.setAttribute("productos",productos);
            RequestDispatcher disp =  getServletContext().getRequestDispatcher("/productoRegistrado.jsp");

            if(checkLog){
                request.setAttribute("response", nombre);
            }
            if(checkLog){
                //req.setAttribute("trabajador", username);
                disp = getServletContext().getRequestDispatcher("/pass.jsp");
            }else{
                disp = getServletContext().getRequestDispatcher("/index.jsp");
            }


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
