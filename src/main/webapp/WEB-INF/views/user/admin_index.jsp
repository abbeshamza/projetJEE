<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../fragments/adminHeader.jsp"></jsp:include>	

<div class="container">
<h1><spring:message code="admin.users.gestion"></spring:message></h1>












<div class="container">
 <div class="  col-md-offset-5">
			<h1><spring:message code="user.form.new.title"/></h1>
		</div>
<br><br><br>
	<div class="container">
		
		<div class=" form-group">
		<table class="table table-responsive">
			<form:form method="post" enctype= "multipart/form-data" class="form-horizontal" action="${pageContext.request.contextPath}/app/admin/user/add" modelAttribute="user"> 
				
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

<div class="table-responsive">
<table class="table table-hover ">
<thead>
<th><spring:message code="admin.user.form.new.label.username"/> </th> 
<th><spring:message code="admin.user.form.new.label.email"/> </th> 
<th><spring:message code="admin.user.form.new.label.num_tel"/> </th> 
<th><spring:message code="admin.user.form.new.label.role"/> </th> 
<th><spring:message code="admin.user.form.new.label.nb_points"/> </th> 
<th><spring:message code="admin.user.form.new.label.img"/> </th>  
<th> <spring:message code="admin.action"/></th>
</thead>

<tbody>

<c:forEach var="item" items="${users }">
<tr>
<div class="table-responsive">
<td> ${item.username } </td>
<td> ${item.email } </td>
<td> ${item.num_tel } </td>
<td> ${item.role } </td>
<td> ${item.nb_points } </td>
<td class="col-md-3 image-responsive"> <img src="${item.img }" class="img-responsive img-thumbnail" width="100%" height ="100%" /></td>
<td> <a href='<spring:url value="/app/admin/user/delete/${item.id }"/>'><button type="button" class="btn btn-danger"><spring:message code="admin.action.delete"/></button></a>  
   <a href='<spring:url value="/app/admin/user/edit/${item.id }"/>'><button type="button" class="btn btn-warning"><spring:message code="admin.action.update"/></button></a>  
    </td>
</div>
</tr>
</c:forEach>

</tbody></table>


</div>


















</div>
<jsp:include page="../fragments/footer.jsp"></jsp:include>	