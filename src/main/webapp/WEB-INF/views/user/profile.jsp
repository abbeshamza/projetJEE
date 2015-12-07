<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../fragments/headeru.jsp"></jsp:include>	



<div class="container">
<h2><spring:message code="user.profil"/></h2>
<table class="table table-responsive">
			
				<tr class="form-group">
				<td><spring:message code="user.form.new.label.username"/> </td>
				<td >${userC.username} </td>
				</tr>
				
				<tr class="form-group">
				<td><spring:message code="user.form.new.label.email"/></td>
				<td> ${userC.email}</td>
				
				</tr>
					
					
				<tr class="form-group">
				<td><spring:message code="user.form.new.label.num_tel"/> </td>
				<td>${userC.num_tel}</td>
				
				</tr>
			
				<tr class="form-group">
				<td><spring:message code="user.form.new.label.img"/></td>
				<td> <img src=' ${userC.img}'/></td>
				
				</tr>
				
				
			</table>
</div>


<jsp:include page="../fragments/footer.jsp"></jsp:include>	