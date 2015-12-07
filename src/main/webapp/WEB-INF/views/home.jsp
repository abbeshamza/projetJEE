<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="fragments/headeru.jsp"></jsp:include>	



    <div class="  col-md-offset-5">
			<h1><spring:message code="user.profil"/></h1>
		</div>
<br><br><br>
	<div class="container">
	
	
	<pre>
	<spring:message code="about.message"/>
	
	</pre>
	
	</div>
	
	
	
	
	
	
	<jsp:include page="fragments/footer.jsp"></jsp:include>	