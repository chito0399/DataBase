<!DOCTYPE HTML>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>School</title>
</head>
<body>

<table border="1">
	<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Student ID</th>
			<th>Program</th>
	</tr>
  <c:forEach items="${requestScope.alumnos}" var="al">
	  <tr>
			<td>
        <c:out value="${al.nombre}" />
      	<br />
			</td>
			<td>
        <c:out value="${al.edad}" />
      	<br />
			</td>
			<td>
        <c:out value="${al.matricula}" />
      	<br />
			</td>
			<td>
        <c:out value="${al.carrera}" />
      	<br />
			</td>
		</tr>
  </c:forEach>
</table>
<br />
<a href="./index2.html">Back</a>
</body>
</html>

<!-- <!DOCTYPE HTML>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>School</title>
</head>
<body>

<table border="1">
	<tr>
		<th>ID</th>
        <th>Uso</th>
        <th>Fecha de llegada</th>
        <th>Fecha de venta</th>
        <th>Precio proveedor</th>
        <th>Precio cliente</th>
        <th>Proveedor</th>
        <th>Tabla</th>
        <th>Ganancia</th>
	</tr>
  <c:forEach items="${requestScope.productos}" var="pro">
	  <tr>
			<td>
        <c:out value="${pro.id}" />
      	<br />
			</td>
			<td>
        <c:out value="${pro.uso}" />
      	<br />
			</td>
			<td>
        <c:out value="${pro.fechaLlegada}" />
      	<br />
			</td>
			<td>
        <c:out value="${pro.fechaVenta}" />
      	<br />
			</td>
		<c:out value="${pro.precioProveedor}" />
      	<br />
			</td>
		<c:out value="${pro.precioCliente}" />
      	<br />
			</td>
		<c:out value="${pro.proveedor}" />
      	<br />
			</td>
		<c:out value="${pro.tabla}" />
      	<br />
			</td>
		<c:out value="${pro.ganancia}" />
      	<br />
			</td>

		</tr>
  </c:forEach>
</table>
<br />
<a href="./index.html">Back</a>
</body>
</html> -->

