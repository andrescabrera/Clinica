<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- TODO: Unificar formatos hacia HTML 5 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Clinica :: Empleado</title>
</head>
<body>
	<h1>Ver Empleado</h1>
	<br />
	<!-- Navegacion -->
		<a href="/empleados">Listar Empleados</a>
	
	<table>
		<tr>
			<td>Id</td>
			<td>${empleado.id}</td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td>${empleado.persona.nombre}</td>
		</tr>
		<tr>
			<td>Apellido</td>
			<td>${empleado.persona.apellido}</td>
		</tr>
		<tr>
			<td>Documento</td>
			<td>${empleado.persona.documento}</td>
		</tr>		
		<tr>
			<td>Fecha de Baja</td>
			<td>${empleado.persona.fechaBaja}</td>
		</tr>
		<!-- Datos generales a todos los tipos de empleado -->
		<tr>
			<td>Legajo</td>
			<td>${empleado.legajo}</td>
		</tr>
		<tr>
			<td>Sueldo Actual</td>
			<td>${empleado.fechaBaja}</td>
		</tr>
		<tr>
			<td>Horarios</td>
			<td>${empleado.horarios}</td>
		</tr>
<!-- 		<tr> -->
<!-- 			<td>Horas Trabajadas</td> -->
<%-- 			<td>${empleado.horasTrabajadas}</td> --%>
<!-- 		</tr> -->
		<!-- Datos especificos de Medicos -->
<!-- 		<tr> -->
<!-- 			<td>Matricula</td> -->
<%-- 			<td>${empleado.matricula}</td> --%>
<!-- 		</tr> -->
	</table>
</body>
</html>