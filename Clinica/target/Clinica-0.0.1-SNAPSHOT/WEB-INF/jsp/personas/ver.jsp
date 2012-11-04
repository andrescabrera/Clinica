<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ver</title>
</head>
<body>
	<h1>Ver persona</h1>
	<br />
	<a href="/personas">Ver personas</a>
	<table>
		<tr>
			<td>Id</td>
			<td>${persona.id}</td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td>${persona.nombre}</td>
		</tr>
		<tr>
			<td>Apellido</td>
			<td>${persona.apellido}</td>
		</tr>
		<tr>
			<td>Documento</td>
			<td>${persona.documento}</td>
		</tr>		
		<tr>
			<td>Fecha de Baja</td>
			<td>${persona.fechaBaja}</td>
		</tr>
		
	</table>
</body>
</html>