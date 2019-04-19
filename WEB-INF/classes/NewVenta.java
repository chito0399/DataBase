import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet("/NewVenta")
public class NewVenta extends HttpServlet{

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

            /*
            Aquí se debe de jalar todos los productos para imprimirlos en ventas jsp
            */ 

            

			res.setContentType("text/html");
			PrintWriter out = res.getWriter();

			req.setAttribute("trabajador", newTrabajador.nombre);

			RequestDispatcher disp = getServletContext().getRequestDispatcher("/ventas.jsp");

			if(disp!=null){
				disp.forward(req,res);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	

}
