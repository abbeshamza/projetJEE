<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../fragments/adminHeader.jsp"></jsp:include>	

<div class="container">
<h1><spring:message code="admin.stat"></spring:message></h1>

<h1> <spring:message code="admin.stat.solde" />  <p> ${profit } $</p></h1>



<h1><spring:message code="admin.stat.user.actif"/> </h1>

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


<tr>
<div class="table-responsive">
<td> ${useractif.username } </td>
<td> ${useractif.email } </td>
<td> ${useractif.num_tel } </td>
<td> ${useractif.role } </td>
<td> ${useractif.nb_points } </td>
<td class="col-md-3 image-responsive"> <img src="${useractif.img }" class="img-responsive img-thumbnail" width="100%" height ="100%" /></td>
<td> <a href='<spring:url value="/app/admin/user/delete/${useractif.id }"/>'><button type="button" class="btn btn-danger"><spring:message code="admin.action.delete"/></button></a>  
   <a href='<spring:url value="/app/admin/user/edit/${useractif.id }"/>'><button type="button" class="btn btn-warning"><spring:message code="admin.action.update"/></button></a>  
    </td>
</div>
</tr>

</tbody></table>


</div>



<h1><spring:message code="admin.stat.user.fidele"/> </h1>

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


<tr>
<div class="table-responsive">
<td> ${userfidele.username } </td>
<td> ${userfidele.email } </td>
<td> ${userfidele.num_tel } </td>
<td> ${userfidele.role } </td>
<td> ${userfidele.nb_points } </td>
<td class="col-md-3 image-responsive"> <img src="${userfidele.img }" class="img-responsive img-thumbnail" width="100%" height ="100%" /></td>
<td> <a href='<spring:url value="/app/admin/user/delete/${userfidele.id }"/>'><button type="button" class="btn btn-danger"><spring:message code="admin.action.delete"/></button></a>  
   <a href='<spring:url value="/app/admin/user/edit/${userfidele.id }"/>'><button type="button" class="btn btn-warning"><spring:message code="admin.action.update"/></button></a>  
    </td>
</div>
</tr>

</tbody></table>


</div>
















<h1><spring:message code="admin.stat.categorie.prix"/> </h1>

<div class="table-responsive">
<table class="table table-hover ">
<thead>
<th><spring:message code="admin.stat.categorie"/> </th> 
<th><spring:message code="admin.stat.prix"/> </th> 

</thead>

<tbody>
<c:forEach var="item" items="${l }">

<tr>
<div class="table-responsive">
<td> ${item[1].label } </td>
<td> ${item[0]} </td>

</div>
</tr>
</c:forEach>
</tbody></table>


</div>




































<h1><spring:message code="admin.stat.event.categorie"/> </h1>

<div class="table-responsive">
<table class="table table-hover ">
<thead>

<th><spring:message code="admin.stat.categorie"/> </th> 
<th><spring:message code="admin.stat.event"/> </th> 

</thead>

<tbody>
<c:forEach var="item" items="${m }">

<tr>
<div class="table-responsive">
<td> ${item[1].label } </td>
<td> ${item[0]} </td>

</div>
</tr>
</c:forEach>
</tbody></table>


</div>













































</div>
<jsp:include page="../fragments/footer.jsp"></jsp:include>	