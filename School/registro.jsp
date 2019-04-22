<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,700" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.min.css">     
        <link href="css/registro.css" rel="stylesheet">

        <title>Registro</title>
    </head>

    <body>

        <h4 class="text-center mt-5 font-weight-bold">Registro de un nuevo empleado</h4>

        <form action="./registro" method="post" class="mt-5">

            <img src="img/sign.png" alt="">

            <input type="text" id="id" name="id" class="input" required>            
            <span class="user_label">ID</span>
    
            <input type="text" id="nombre" name="nombre" class="input" required>            
            <span class="user_label">Nombre</span>

            <input type="text" id="apellido" name="apellido" class="input" required>            
            <span class="user_label">Apellido</span>  
            
            <input type="text" id="username" name="username" class="input" required>            
            <span class="user_label">Username</span>

            <input type="password" id="password" name="password" class="input" required>            
            <span class="user_label">Contraseña</span>
            
            <input type="text" id="edad" name="edad" class="input" required>            
            <span class="user_label">Edad</span> 

            <input type="email" id="correo" name="correo" class="input" required>            
            <span class="user_label">Correo</span> 

            <input type="text" id="telefono" name="telefono" class="input" required>            
            <span class="user_label">Teléfono</span>

            <input type="text" id="direccion" name="direccion" class="input" required>            
            <span class="user_label">Dirección</span>

            <input type="text" id="puesto" name="puesto" class="input" required>            
            <span class="user_label">Puesto</span>
            
            <input class="login_button" type="submit"  value="GUARDAR">

            <a href="index.jsp">
                <p>Atrás</p>
            </a>
            
        
        </form>
    </body>
</html>
