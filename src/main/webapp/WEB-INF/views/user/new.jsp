<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

    <div class="container">
    
         <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Event</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
             <li><a href="<spring:url value="/login" />"><spring:message code="user.nav.login"/></a></li>
              <li><a href="<spring:url value="/register"/>" ><spring:message code="user.nav.register"/></a></li>
              </ul>
              </div>
              </div>
              </nav>
    </div>
    <div class="  col-md-offset-5">
			<h1><spring:message code="user.form.new.title"/></h1>
		</div>
<br><br><br>
	<div class="container">
		
		<div class=" form-group">
		<table class="table table-responsive">
			<form:form method="post" enctype= "multipart/form-data" class="form-horizontal" action="${pageContext.request.contextPath}/register" modelAttribute="user"> 
				
				<tr class="form-group">
				<td><label><spring:message code="user.form.new.label.username"/> </label></td>
				<td><form:input path="username" class="form-control"  type="text"  /></td>
				<td ><p class="bg-danger"><form:errors path="username"/></p></td>
				</tr>
				
				<tr class="form-group">
				<td><label><spring:message code="user.form.new.label.email"/></label></td>
				<td> <form:input path="email" class="form-control" type="email"  /></td>
				<td><p class="bg-danger"><form:errors path="email"/></p></td>
				</tr>
					
				<tr class="form-group">
				<td><label><spring:message code="user.form.new.label.password"/> </label></td>
				<td><form:input path="password" class="form-control" type="password"  /></td>
				<td><p class="bg-danger"><form:errors path="password"/></p></td>
				</tr>
					
				<tr class="form-group">
				<td><label><spring:message code="user.form.new.label.num_tel"/> </label></td>
				<td><form:input path="num_tel" class="form-control" type="text"  /></td>
				<td><p class="bg-danger"><form:errors path="num_tel"/></p></td>
				</tr>
			
				<tr class="form-group">
				<td><label><spring:message code="user.form.new.label.img"/></label></td>
				<td> <input type="file" name="image"/></td>
				<td><p class="bg-danger"><form:errors path="img"/></p></td>
				</tr>
				
				<tr class="form-group">
				<td></td>
				<td><input type="submit" value=<spring:message code="user.form.new.submit"/> class="btn btn-info">
				<td/>
				</tr>
			</form:form>
			</table>
		</div>
	</div>
	<jsp:include page="../fragments/footer.jsp"></jsp:include>	