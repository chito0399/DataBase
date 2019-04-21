import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
// import escuela.Producto;
// import escuela.Alumno;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/ShowProducts")
public class ShowPQuery extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			
			PrintWriter writer = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto1.txt", "UTF-8");
			PrintWriter writer2 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto2.txt", "UTF-8");
			PrintWriter writer3 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto3.txt", "UTF-8");

			writer.println("The first line");
			writer.println("The second line");

			String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
			String password = getServletContext().getInitParameter("pass");


			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
		
			System.out.println(url);
			Connection con = DriverManager.getConnection(url,usuario,password);
			writer.close();

			Statement stat = con.createStatement();
			String sql;


			
			String sql2 = "SELECT * FROM producto;";
			writer2.println(sql2);
			writer2.close();

			ResultSet res = stat.executeQuery(sql2);

			Vector<Producto> productos = new Vector<Producto>();


            while(res.next()){

				Producto aux = new Producto();

				// aux.id = res.getInt("idProducto");

				// writer3.println(aux.id);
				// aux.uso = res.getString("Uso");
				// writer3.println(aux.uso);
				// aux.fechaLlegada = res.getString("fechaDeLlegada");
				// writer3.println(aux.fechaLlegada);
    //             aux.fechaVenta = res.getString("fechaDeVenta");  
    //             writer3.println(aux.fechaVenta);             
    //             aux.precioProveedor = res.getFloat("precioProveedor");
    //             writer3.println(aux.precioProveedor);
    //             aux.precioCliente = res.getFloat("precioCliente");
    //             writer3.println(aux.precioCliente);
    //             aux.proveedor = res.getString("proveedor");
    //             writer3.println(aux.proveedor);
    //             aux.tabla = res.getInt("tabla");
    //             writer3.println(aux.tabla);
    //             aux.ganancia = res.getFloat("ganancia");
    //             writer3.println(aux.ganancia);

				aux.setId(res.getInt("idProducto"));
				aux.setUso(res.getString("Uso"));
				aux.setFechaLlegada(res.getString("fechaDeLlegada"));
				aux.setFechaVenta(res.getString("fechaDeVenta"));
				aux.setPrecioProveedor(res.getFloat("precioProveedor"));
				aux.setPrecioCliente(res.getFloat("precioCliente"));
				aux.setProveedor(res.getString("proveedor"));
				aux.setTabla(res.getInt("tabla"));
				aux.setGanancia(res.getFloat("ganancia"));



				productos.add(aux);

            }

            writer3.println("the vector size is "+productos.size());
            // writer3.println("hello "+productos.get(0).id);
            // writer3.println("hello "+productos.get(1).id);
            writer3.close();

			stat.close();
            con.close();

			request.setAttribute("productos", productos);

			RequestDispatcher disp = getServletContext().getRequestDispatcher("/showProducts.jsp");

			if(disp!=null){
				disp.forward(request, response);
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

// import java.sql.*;
// import java.io.*;
// import javax.servlet.*;
// import javax.servlet.http.*;
// import java.util.Vector;
// import java.text.SimpleDateFormat;  
// import java.util.Date;

// import javax.servlet.annotation.WebServlet;

// @WebServlet("/showProducts")
// public class ShowProductos extends HttpServlet{


// 	public void doPost(HttpServletRequest req, HttpServletResponse res){

// 		try{

// 			PrintWriter writer = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto1.txt", "UTF-8");
// 			PrintWriter writer2 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto2.txt", "UTF-8");
// 			PrintWriter writer3 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto3.txt", "UTF-8");

// 			writer.println("The first line");
// 			writer.println("The second line");

// 			ResultSet result = null;
            	
//                 String base = getServletContext().getInitParameter("base");
//                 String usuario = getServletContext().getInitParameter("usuario");
//                 String pass = getServletContext().getInitParameter("pass");
                
//                 Class.forName("com.mysql.jdbc.Driver");
//                 String url = "jdbc:mysql://localhost/"+base"?useSSL=false&allowPublicKeyRetrieval=true";
//                 Connection con = DriverManager.getConnection(url,usuario,pass);
//                 writer.close();

//                 Statement stat = con.createStatement();                
//                 String sql = "SELECT * from producto";
                
//                 result = stat.executeQuery(sql);
//                 System.out.println("Sí se despliega todo de producto");
//                 writer2.println(sql);
// 				writer2.close();

                

            
            
//             Vector<Producto> productos = new Vector<Producto>();
//             while(result.next()){

// 				Producto aux = new Producto();

// 				aux.id = Integer.parseInt(result.getString("idProducto"));
// 				aux.uso = result.getString("Uso");
// 				aux.fechaLlegada = result.getString("fechaDeLlegada");
//                 aux.fechaVenta = result.getString("fechaDeVenta");               
//                 aux.precioProveedor = Float.parseFloat(result.getString("precioProveedor"));
//                 aux.precioCliente = Float.parseFloat(result.getString("precioCliente"));
//                 aux.proveedor = result.getString("proveedor");
//                 aux.tabla = Integer.parseInt(result.getString("tabla"));
//                 aux.ganancia = Float.parseFloat(result.getString("ganancia"));

// 				productos.add(aux);

//             }

// 			stat.close();
//             con.close();

// 			req.setAttribute("productos", productos);

// 			RequestDispatcher disp = getServletContext().getRequestDispatcher("/showProducts.jsp");

// 			if(disp!=null){
// 				disp.forward(req,res);
// 			}
// 		}
// 		catch(Exception e){
// 			try{
// 				PrintWriter writer4 = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto4.txt", "UTF-8");
// 				e.printStackTrace();
// 				writer4.println(e);
// 				writer4.close();
// 			}
// 			catch(Exception e2){
// 				e2.printStackTrace();
// 			}
// 		}

// 	}

	

// }
