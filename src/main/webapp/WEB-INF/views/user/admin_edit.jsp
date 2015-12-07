<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../fragments/adminHeader.jsp"></jsp:include>	



    <div class="  col-md-offset-5">
			<h1><spring:message code="user.profil"/></h1>
		</div>
<br><br><br>
	<div class="container">
		
		<div class=" form-group">
		<table class="table table-responsive">
			<form:form method="post" enctype= "multipart/form-data" class="form-horizontal" action="${pageContext.request.contextPath}/app/me/edit" modelAttribute="user"> 
				
			
				<tr class="form-group">
				<td><label><spring:message code="user.form.new.label.email"/></label></td>
				<td> <form:input path="email" class="form-control" type="email" value ="${user.email }" /></td>
				<td><p class="bg-danger"><form:errors path="email"/></p></td>
				</tr>
					
				<tr class="form-group">
				<td><label><spring:message code="user.form.new.label.password"/> </label></td>
				<td><form:input path="password" class="form-control" type="password" value ="${user.password }"   /></td>
				<td><p class="bg-danger"><form:errors path="password"/></p></td>
				</tr>
					
				<tr class="form-group">
				<td><label><spring:message code="user.form.new.label.num_tel"/> </label></td>
				<td><form:input path="num_tel" class="form-control" type="text" value ="${user.num_tel }"  /></td>
				<td><p class="bg-danger"><form:errors path="num_tel"/></p></td>
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