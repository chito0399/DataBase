<!DOCTYPE HTML>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Nueva Venta</title>
    </head>
    <body>

        <table border="1">
            <tr>
                <th>Fecha de Venta</th>
                <th>Precio total </th>
                <th>ID del cliente </th>
                <th>ID del trabajador</th>
            </tr>
            <c:forEach items="${requestScope.ventaVector}" var="venta">
                <tr>
                        <td>
                            <c:out value="${venta.getFecha()}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${venta.getPrecio()}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${venta.getClient()}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${venta.getTrabajador()}" />
                            <br />
                        </td>
                        
                    </tr>
            </c:forEach>
        </table>

        <br>
        <br>
        <br>
        <a href="./pass.jsp">Menu</a>
    </body>
</html>
