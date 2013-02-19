<%@page
	import="org.springframework.web.context.request.RequestAttributes"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>

<title><spring:message code="label.personas.title" /></title>
<link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css" />
</head>

<body>
	<header>
		<h1>
			<spring:message code="label.personas.title"></spring:message>
		</h1>
	</header>
	<nav>
		<ul>
			<li><spring:message code="label.language"></spring:message></li>
			<li><a href="?lang=es"><spring:message code="label.spanish"></spring:message></a></li>
			<li><a href="?lang=en"><spring:message code="label.english"></spring:message></a></li>
		</ul>
		<ul>
			<li><spring:message code="label.style"></spring:message></li>
			<li><a href="?theme=default"><spring:message
						code="label.default"></spring:message></a></li>
			<li><a href="?theme=blue"><spring:message code="label.blue"></spring:message></a></li>
		</ul>
		<ul>
			<li><spring:message code="label.listFilters"></spring:message></li>
			<li><a href="#"><spring:message code="label.personas.title"></spring:message></a>
				<ul>
					<li><a href="#"><spring:message
								code="label.pacientes.title"></spring:message></a></li>
					<li><a href="#"><spring:message
								code="label.empleados.title"></spring:message></a>
						<ul>
							<li><a href="#"><spring:message code="label.medicos"></spring:message></a></li>
							<li><a href="#"><spring:message code="label.secretarias"></spring:message></a></li>
							<li><a href="#"><spring:message
										code="label.administrativos"></spring:message></a></li>
						</ul></li>
				</ul></li>
		</ul>
	</nav>
	<br>
	<section id="opciones">
		<a href="/empleados/alta.html"><spring:message
				code="label.empleado.nuevo"></spring:message></a>
	</section>
	<section>
		<!-- Listo los empleados -->
		<c:forEach items="${empleados}" var="empleado">
			<article>
				<!-- Muestro UN empleado -->
				<header>
					<p>${empleado.persona.nombre} ${empleado.persona.apellido}</p>
					<p>Legajo: ${empleado.legajo}</p>
					<p>
						Tipo:
						<spring:message code="label.tipoEmpleado${empleado.tipo}"></spring:message>
					</p>
				</header>
				<p>
					<a href="./empleados/${empleado.id}"><spring:message
							code="label.empleado.masdatos"></spring:message></a>
				<p>
			</article>
		</c:forEach>
	</section>
	<footer>
		<p>
			<spring:message code="label.footer"></spring:message>
		</p>
	</footer>
</body>

</html>