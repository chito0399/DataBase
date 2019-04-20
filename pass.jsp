<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,700" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.min.css">                
        <style>
            body{
                font-family: 'Raleway';
                margin: 0;
                background-color: #0d77b5;
            }
            section{
                min-height: 100%;
            }
        </style>

        <title>Entrada user</title>
        
    </head>

    <body>

        <section class="row justify-content-center align-items-center mx-0">


            <br> <br>
            <H1> 

                El nombre del usuario es: <c:out value = "${requestScope.trabajador}" />
            </H1>

            
            <form action="" method="get" >                  
                <div class="card text-white bg-secondary my-0 mr-5" style="max-width: 18rem;">
                    <h5 class="card-header card-title">Hacer una nueva venta</h5>
                    <div class="card-body">
                        <p class="card-text">Realiza una venta a un nuevo cliente. Ingresa todos los datos necesarios.</p>
                        <input class="venta_buton btn btn-success" type="submit"  value="Venta">
                    </div>
                </div>                                        
            </form>
            
            <form action="" method="get">
                <div class="card text-white bg-secondary my-0 ml-5" style="max-width: 18rem;">
                    <h5 class="card-header card-title">Mis proyectos</h5>
                    <div class="card-body">
                        <p class="card-text">Revisa los proyectos en los que estás envuelto y haz las modificaciones necesarias</p>
                        <input class="proyecto_buton btn btn-success" type="submit"  value="Proyectos">
                    </div>
                </div>
            </form>

            <form action="" method="get">
                    <div class="card text-white bg-secondary my-0 ml-5" style="max-width: 18rem;">
                        <h5 class="card-header card-title">Nuevo producto</h5>
                        <div class="card-body">
                            <p class="card-text">Con esta función puedes agregar un nuevo producto a la tienda y ponerlo a la venta.</p>
                            <input class="proyecto_buton btn btn-success" type="submit"  value="Agregar">
                        </div>
                    </div>
                </form>

        </section>
            


        


        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
