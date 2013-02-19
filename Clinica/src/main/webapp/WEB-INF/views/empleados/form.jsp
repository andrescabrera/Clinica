<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Clinica :: Empleados</title>

</head>

<body>
	<h1>Alta de Empleado</h1>
	<br />
	<form:form commandName="empleadoForm" method="POST" action="/empleados">
		<form:hidden path="id" />
		<table>
			<!-- Datos personales -->
			<tr>
				<td>Nombre</td>
				<td><form:input path="personaForm.nombre" /> <form:errors path="personaForm.nombre" /></td>
			</tr>
			<tr>
				<td>Apellido</td>
				<td><form:input path="personaForm.apellido" /> <form:errors
						path="personaForm.apellido" /></td>
			</tr>
			<tr>
				<td>Direccion</td>
				<td><form:input path="personaForm.direccion" /> <form:errors
						path="personaForm.direccion" /></td>
			</tr>
			<tr>
				<td>Documento</td>
				<td><form:input path="personaForm.documento" /> <form:errors
						path="personaForm.documento" /></td>
			</tr>
			<tr> <!-- TODO: Mejorar el select cargando tipos de empleados disponibles desde el controlador. -->
				<td>Tipo de Empleado</td>
				<td><form:select path="tipoEmpleado">
						<form:option value="0" label="Seleccionar" /> <!-- Validar campo via JS -->
						<form:option value="1" label="Administrativo" />
						<form:option value="2" label="Secretaria" />
						<form:option value="3" label="Medico" />
					</form:select></td>
			</tr>
			<!-- Mostrar el resto de los campos según si se esta cargando un Medico
			 ú otro tipo de empleado -->
			<!-- Datos de los Empleados -->
			<tr>
				<td>Legajo</td>
				<td><form:input path="legajo" /> <form:errors path="legajo" /></td>
			</tr>
			<tr>
				<td>Sueldo Neto Actual</td>
				<td><form:input path="sueldoNetoActual" /> <form:errors
						path="sueldoNetoActual" /></td>
			</tr>
			<tr>
				<td>Sueldo Bruto Actual</td>
				<td><form:input path="sueldoBrutoActual" /> <form:errors
						path="sueldoBrutoActual" /></td>
			</tr>
			<tr>
				<td>Horarios</td>
				<td><form:input path="horarios" /> <form:errors
						path="horarios" /></td>
			</tr>
			<!-- Datos de los Medicos -->
			<tr>
				<td>Matricula</td>
				<td><form:input path="matricula" /> <form:errors
						path="matricula" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Guardar" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>