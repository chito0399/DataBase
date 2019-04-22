<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,700" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.min.css">     
        <link href="css/venta.css" rel="stylesheet">           
        <title>Ventas</title>
        
    </head>

    <body>


        <form action="./NewVenta" method="post" class="mb-5">

            <img src="img/venta.png" class="login_img">

            <input type="text" id="id" name="id" class="input mt-4" required>            
            <span class="user_label mt-3">IdVenta</span>


            <input type="text" id="cliente" name="cliente" class="input mt-4" required>            
            <span class="user_label mt-3">Cliente</span>

            <input type="email" id="correo" name="correo" class="input" required>            
            <span class="user_label mt-3">Correo</span>

            <input type="text" id="telefono" name="telefono" class="input" required>            
            <span class="user_label mt-3">Teléfono</span>

            <span class="user_label my-4">Productos</span>

            <!-- <section id="products" class="">

                <c:forEach items="${requestScope.venta}" var="ven">
                    <input class="mb-3"type="checkbox" name="vehicle1" value="Bike">                    
                    <c:out value="${ven.nombre}" />
                    <br>
                </c:forEach>

            </section> -->
                <!-- <input class="mb-3"type="checkbox" name="vehicle1" value="Bike"> I have a bike<br>
                <input class="mb-3"type="checkbox" name="vehicle2" value="Car"> I have a car<br>
                <input class="mb-3"type="checkbox" name="vehicle3" value="Boat"> I have a boat<br><br> -->
            
            
            <input type="text" id="precio" name="precio" class="input" required>            
            <span class="user_label mt-3">Precio</span>

            <input type="text" id="user_trabajador" name="user_trabajador" class="input" required>            
            <span class="user_label mt-3">Username trabajador</span>

            <span class="user_label my-2">Fecha</span>
            <input type="date" name="datepicker" id="datepicker" required>                        
            <input class="login_button my-5" type="submit"  value="Listo">
            
            
        </form>
                  
    

    </body>

</html>