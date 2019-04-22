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
                
             
               
            </tr>
            <c:forEach items="${requestScope.ventas}" var="venta">
                <tr>
                        <td>
                            <c:out value="${venta.id}" />
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

