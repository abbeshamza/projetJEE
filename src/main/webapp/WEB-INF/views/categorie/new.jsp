<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../fragments/adminHeader.jsp"></jsp:include>	






<div class="  col-md-offset-5">
			<h1><spring:message code="categorie.form.new.title"/></h1>
		</div>
<br><br><br>
	<div class="container">
		
		<div class=" form-group">
		<table class="table table-responsive">
			<form:form method="post" class="form-horizontal" action="${pageContext.request.contextPath}/app/admin/categorie/index" modelAttribute="categorie"> 
				<tr class="form-group">
				<td><label><spring:message code="categorie.form.new.label.label"/> </label></td>
				<td><form:input path="label" class="form-control"  type="text"  /></td>
				<td ><p class="bg-danger"><form:errors path="label"/></p></td>
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
	
	<div class="container">
	
	<table classe="table">
	<thead>
	<th><spring:message code="categorie.form.label"/></th>
	<th><spring:message code="admin.action"/></th>
	</thead>
	<tbody>
	
	<c:forEach var="item" items="${categories }">
	
	<tr>
	<td>${item.label}</td>
	<td> <a href='<spring:url value="/app/admin/categorie/edit/${item.id }"/>'><button type="button" class="btn btn-warning"><spring:message code="admin.action.update"/></button></a>  </td>
	</tr>
	
	</c:forEach>
	
	
	</tbody>
	
	</table>
	
	
	
	</div>
	
	
	
	<jsp:include page="../fragments/footer.jsp"></jsp:include>	