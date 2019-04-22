<!DOCTYPE HTML>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Products</title>
    </head>
    <body>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Uso</th>
                <th>Nombre</th>
                <th>Fecha de llegada</th>
                <th>Fecha de venta</th>
                <th>Precio proveedor</th>
                <th>Precio cliente</th>
                <th>Proveedor</th>
                <th>Tabla</th>
                <th>Ganancia</th>
            </tr>
            <c:forEach items="${requestScope.productos}" var="product">
                <tr>
                        <td>
                            <c:out value="${product.id}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${product.nombre}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${product.uso}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${product.fechaLlegada}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${product.fechaVenta}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${product.precioProveedor}" />
                            <br />
                        </td>

                        <td>
                            <c:out value="${product.precioCliente}" />
                            <br />
                        </td>

                        <td>
                            <c:out value="${product.proveedor}" />
                            <br />
                        </td>

                        <td>
                            <c:out value="${product.tabla}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${product.ganancia}" />
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
