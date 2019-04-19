<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

	<head>
		<title>
			Process
		</title>
	</head>

	<body>
		El nombre del usuario es: <c:out value = "${requestScope.trabajador}" />
</html>