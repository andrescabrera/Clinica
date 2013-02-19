<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>

<title><spring:message code="label.personas.title"/></title>
<link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css"/>
</head>

<body>
	<header>
		<h1><spring:message code="label.personas.title"></spring:message></h1>
	</header>
	<nav>
		<ul>
			<li><a><spring:message code="label.personas.title"></spring:message></a>
				<ul>
					<li><a><spring:message code="label.pacientes.title"></spring:message></a></li>
					<li><a><spring:message code="label.empleados.title"></spring:message></a>
						<ul>
							<li><a><spring:message code="label.medicos"></spring:message></a></li>
							<li><a><spring:message code="label.secretarias"></spring:message></a></li>
							<li><a><spring:message code="label.administrativos"></spring:message></a></li>
						</ul></li>
				</ul></li>
			<li><a href="/personas/alta.html"><spring:message code="label.personas.nueva"></spring:message></a></li>
		</ul>
	</nav>
	<section>
		<!-- Listo las personas -->
		<c:forEach items="${personas}" var="persona">
			<article>
				<!-- Muestro UNA persona -->
				<header>
					<p>${persona.nombre} ${persona.apellido}</p>
				</header>
				<details title="Ver detalles">
					<p>${persona.id}</p>
					<p>${persona.documento}</p>
					<p>${persona.fechaBaja}</p>
					<div>
						<a href="/personas/editar.html?id=${p.id}"><spring:message code="label.editar"></spring:message></a> <a
							href="/personas/borrar.html?id=${p.id}"><spring:message code="label.borrar"></spring:message></a>
					</div>
				</details>
			</article>
		</c:forEach>
	</section>
	<footer>
		<p><spring:message code="label.footer"></spring:message></p>
	</footer>
</body>

</html>