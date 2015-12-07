<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="../fragments/headeru.jsp"></jsp:include>	
    <div class="  col-md-offset-5">
			<h1><spring:message code="carte.form.new.title"/></h1>
		</div>
<br><br><br>
	<div class="container">
		
		<div class=" form-group">
		<table class="table table-responsive">
			<form:form method="post" class="form-horizontal" action="${pageContext.request.contextPath}/carte/new" modelAttribute="carte"> 
				
				<tr class="form-group">
				<td><label><spring:message code="carte.form.new.label.numero"/> </label></td>
				<td><form:input path="numero" class="form-control"  type="text"  /></td>
				<td ><p class="bg-danger"><form:errors path="numero"/></p></td>
				</tr>
				
				<tr class="form-group">
				<td><label><spring:message code="carte.form.new.label.password"/></label></td>
				<td> <form:input path="password" class="form-control" type="password"  /></td>
				<td><p class="bg-danger"><form:errors path="password"/></p></td>
				</tr>
				
				
				<tr class="form-group">
				<td></td>
				<td><input type="submit" value=<spring:message code="form.submit"/> class="btn btn-info">
				<td/>
				</tr>
			</form:form>
			</table>
		</div>
	</div>
	<jsp:include page="../fragments/footer.jsp"></jsp:include>	