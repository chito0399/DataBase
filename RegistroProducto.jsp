<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,700" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.min.css">     
        <link href="css/productos.css" rel="stylesheet">

        <title>Nuevo producto</title>
    </head>

    <body>

        <h4 class="text-center mt-5 font-weight-bold">Registro de un nuevo producto</h4>

        <form action="/.RegistroProducto" method="get" class="mt-5">

            <img src="img/product.jpg" alt="">

            <input type="text" id="nombre" name="nombre" class="input" required>            
            <span class="user_label">Nombre</span>

            <input type="text" id="uso" name="uso" class="input" required>            
            <span class="user_label">Uso</span>  
            
            <input type="date" id="fecha" name="fecha" class="input" required>            
            <span class="user_label">Fecha de llegada</span>

            <input type="date" id="fechaVenta" name="fechaVenta" class="input" required>            
            <span class="user_label">Fecha de venta</span>

            <input type="text" id="Pproveedor" name="Pproveedor" class="input" required>            
            <span class="user_label">Precio proveedor</span>
            
            <input type="text" id="cliente" name="cliente" class="input" required>            
            <span class="user_label">Precio cliente</span> 

            <input type="text" id="proveedor" name="proveedor" class="input" required>            
            <span class="user_label">Proveedor</span> 

            <input type="text" id="tabla" name="tabla" class="input" required>            
            <span class="user_label">Tabla</span>

            <input type="text" id="ganancia" name="ganancia" class="input" required>            
            <span class="user_label">Ganancia</span>

                   
            <input class="login_button" type="submit"  value="GUARDAR">

            <a href="pass.jsp">
                <p>Atrás</p>
            </a>
            
        
        </form>
    </body>
</html>
