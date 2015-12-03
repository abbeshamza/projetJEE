<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
	
	<jsp:include page="../views/fragments/header.jsp"></jsp:include>			

	<div class="container">
		
		
						
							<c:forEach var="client" items="${clients}">
								<tr>
									<td>${client.id}</td>
									<td>${client.username}</td>
									<td ><a href="${pageContext.request.contextPath}/update/${client.id}" class="button tiny btnicon secondary" data-tooltip title="Modifier"><i
											class="fa fa-pencil"></i></a> 
											<a href="${pageContext.request.contextPath}/delete/${client.id}" data-tooltip title="Supprimer"><i class="fa fa-times"></i></a></td>
								</tr>
							</c:forEach>
						
					
		
	</div>
</body>
</html>