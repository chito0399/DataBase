import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet("/Login")
public class Login extends HttpServlet{

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

            int username = Integer.parseInt(req.getParameter("username"));
            String password = req.getParameter("password");            

            String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");
            
            Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);

            Statement stat = con.createStatement();
            String sql = "SELECT * FROM trabajador;";
            
            ResultSet result = stat.executeQuery(sql);

            boolean exists = false;

            while(result.next()){
                int user = Integer.parseInt(result.getString("cuenta"));
                String passdata = result.getString("contrasenia");

                if(user == username && passdata.equals(password)){
                    exists = true;
                    break;
                }
            }


            stat.close();
            con.close();
            
            res.setContentType("text/html");
			PrintWriter out = res.getWriter();

            req.setAttribute("trabajador", username);
            
            RequestDispatcher disp = null;

            if(exists){
                //req.setAttribute("trabajador", username);
                disp = getServletContext().getRequestDispatcher("/pass.jsp");
            }else{
                disp = getServletContext().getRequestDispatcher("/index.jsp");
            }
            

			if(disp!=null){
				disp.forward(req,res);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	

}
