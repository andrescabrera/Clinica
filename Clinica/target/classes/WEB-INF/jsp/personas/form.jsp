<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Formulario</title>

</head>

<body>
	<h1>Formulario persona</h1>
	<br />
	<form:form commandName="personaForm" method="POST" action="/personas">
		<form:hidden path="id" />
		<table>
			<tr>
				<td>Nombre</td>
				<td><form:input path="nombre" /> <form:errors path="nombre" /></td>
			</tr>
			<tr>
				<td>Apellido</td>
				<td><form:input path="apellido" /> <form:errors
						path="apellido" /></td>
			</tr>
			<tr>
				<td>Direccion</td>
				<td><form:input path="direccion" /> <form:errors
						path="direccion" /></td>
			</tr>
			<tr>
				<td>Documento</td>
				<td><form:input path="documento" /> <form:errors
						path="documento" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Guardar" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>