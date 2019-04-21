<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Producto Registrado</title>

    </head>

    <body>
        
        Se registro el producto <c:out value = "${requestScope.producto.nombre}" />
        <br>

        Uso: <c:out value = "${requestScope.producto.uso}" />
        <br>

        La fecha de llegada es: <c:out value = "${requestScope.producto.llegada}" />
        <br>

        La fecha de venta es: <c:out value = "${requestScope.producto.venta}" />
        <br>
        
        El precio de proveedor es: <c:out value = "${requestScope.producto.precioProveedor}" />
        <br>

        El precio cliente es: <c:out value = "${requestScope.producto.precioCliente}" />
        <br>

        El proveedor es: <c:out value = "${requestScope.producto.proveedor}" />
        <br>

        La tabla en la que esta es:  <c:out value = "${requestScope.producto.tabla}" />
        <br>

        La ganancia es: <c:out value = "${requestScope.producto.ganancia}" />
        <br>

<!-- 
        <c:forEach items="${requestScope.producto}" var="product">
	  
            <c:out value="${product.nombre}" />
            
            <c:out value="${al.edad}" />
      	
        
        </c:forEach> -->


        <a href="pass.jsp">
            Menú
        </a>
        

    </body>

</html>