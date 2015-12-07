<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../fragments/headeru.jsp"></jsp:include>	
<div class="  col-md-offset-5">
			<h1><spring:message code="event.form.new.title"/></h1>
		</div>
<br><br><br>
	<div class="container">
		
		<div class=" form-group">
		<table class="table table-responsive">
			<form:form method="post" enctype= "multipart/form-data" class="form-horizontal" action="${pageContext.request.contextPath}/app/events/new" modelAttribute="event"> 
				
				<tr class="form-group">
				<td><label><spring:message code="event.form.new.label.label"/> </label></td>
				<td><form:input path="label" class="form-control"  type="text"  /></td>
				<td ><p class="bg-danger"><form:errors path="label"/></p></td>
				</tr>
				
				<tr class="form-group">
				<td><label><spring:message code="event.form.new.label.categorie"/> </label></td>
				<td>
				<select name="categoriee">
				<c:forEach  var="item" items="${categories}">
				<option value="${item.label}"> ${item.label } </option>
				</c:forEach>
				</select>
				
				
				
				</td>
				
				
				<td ><p class="bg-danger"><form:errors path="categorie"/></p></td>
				</tr>
				
				<tr class="form-group">
				<td><label><spring:message code="event.form.new.label.description"/></label></td>
				<td> <form:textarea path="description" class="form-control"   /></td>
				<td><p class="bg-danger"><form:errors path="description"/></p></td>
				</tr>
					
				<tr class="form-group">
				<td><label><spring:message code="event.form.new.label.lieu"/> </label></td>
				<td>
				<select name="lieu">
				<option>Tunis</option>
				<option>Bizert</option>
				<option>Ben Arous</option>
				<option>Ariana</option>
				<option>Manouba</option>
				<option>Sidi Bou Said</option>
				<option>La marsa</option>
				<option>La goulette</option>
				<option>Kram</option>
				<option>Hamam Lif</option>
				<option>Rades</option>
				</select>
		
				</td>
				<td><p class="bg-danger"><form:errors path="lieu"/></p></td>
				</tr>
					
				<tr class="form-group">
				<td><label><spring:message code="event.form.new.label.date"/> </label></td>
				<td><form:input  path="date"  class="form-control" type="text"  /></td>
				<td><p class="bg-danger"><form:errors path="date"/></p></td>
				</tr>
				<tr class="form-group">
				<td><label><spring:message code="event.form.new.label.prix"/> </label></td>
				<td><form:input path="prix" class="form-control" type="text"  /></td>
				<td><p class="bg-danger"><form:errors path="prix"/></p></td>
				</tr>
				<tr class="form-group">
				<td><label><spring:message code="event.form.new.label.nb_participant"/> </label></td>
				<td><form:input path="nbr_participant" class="form-control" type="text"  /></td>
				<td><p class="bg-danger"><form:errors path="nbr_participant"/></p></td>
				</tr>
				
				<tr class="form-group">
				<td><label><spring:message code="event.form.new.label.img"/></label></td>
				<td> <input type="file" name="image"/></td>
				<td></td>
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