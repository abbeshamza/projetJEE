<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Bibilothèque | Ajouter nouveau client</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<a href="?Languages=en">English</a><a href="?Languages=fr">French</a>
	<spring:message code="welcome"/>
	<div class="row large-12">
		<div class="large-12">
			<h3>Ajouter un nouveau client</h3>
		</div>
		<div class="large-6">
			<form:form method="post" action="${pageContext.request.contextPath}/new" modelAttribute="user"> 
				<div class="row">
					<div class="large-12 columns">
						<label>Nom et prénom <form:input path="username" type="text" />
						</label>
						<form:errors path="username"/>
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
						<input type="submit" value="Ajouter nouveau" class="button tiny">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>

</script>
</html>