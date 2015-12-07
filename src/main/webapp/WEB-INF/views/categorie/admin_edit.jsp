<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../fragments/adminHeader.jsp"></jsp:include>	

<div class="container">
<h1><spring:message code="admin.users.gestion"></spring:message></h1>





<div class="  col-md-offset-5">
			<h1><spring:message code="categorie.for.edit.title"/></h1>
		</div>
<br><br><br>
	<div class="container">
		
		<div class=" form-group">
		<table class="table table-responsive">
			<form:form method="post" class="form-horizontal" action="${pageContext.request.contextPath}/app/admin/categorie/edit" modelAttribute="categorie"> 
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
	


</div>
<jsp:include page="../fragments/footer.jsp"></jsp:include>	