
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../fragments/adminHeader.jsp"></jsp:include>






<div class="container col-md-11">
	<div class="row">
		<div class="col-md-5">

			<img src="${event.img }" class="img-responsive img-thumbnail"
				width="100%" height="100%" /> &nbsp;
		</div>

		<div class="col-md-offset-1">
			<h3>${event.label }</h3>
			<div class="table-responsive">
				<table class="table-rsponsive ">
					<tr>
						<td><spring:message code="event.form.new.label.label" /></td>
						<td>${event.label} &nbsp;</td>
					</tr>
					<tr>
						<td><spring:message code="event.form.new.label.description" />
							:</td>
						<td><p>${event.description } &nbsp;</p></td>
					</tr>
					<tr>
						<td><spring:message code="event.form.new.label.categorie" /></td>
						<td>${event.categorie.label } &nbsp;</td>
					</tr>
					<tr>
						<td><spring:message code="event.form.new.label.user" /></td>
						<td>${event.user.username }</td>
					</tr>
					<tr>
						<td><spring:message code="event.form.new.label.date" /></td>
						<td>${event.date } &nbsp;</td>
					</tr>
					<tr>
						<td><spring:message code="event.form.new.label.lieu" /> :</td>
						<td>${event.lieu } &nbsp;</td>
					</tr>
					<tr>
						<td><spring:message
								code="event.form.new.label.nb_participant" /> :</td>
						<td>${event.nbr_participant }&nbsp;</td>
					</tr>

					<tr>
						<td><spring:message code="event.form.new.label.prix" /> :</td>
						<td>${event.prix } &nbsp;</td>
					</tr>

					<tr>
					</tr>
				</table>


				<form:form method="post" class="form-horizontal"
					action="${pageContext.request.contextPath}/app/reservation/new"
					modelAttribute="reservation">

					<table class="table-rsponsive ">
						<tr>
							<td><h4>
									<spring:message code="event.add.panier" />
								</h4></td>
								</tr>
								<tr>
							<td><spring:message
									code="reservation.form.new.label.nbr_place" /></td>
									
							<input type="hidden" name="even" value="${event.id}" />
							
							<td><form:input path="nbr_place" type="text" class="form-control" /> </td>
							</tr>
							<tr>
							<td></td><td>  <input type="submit" value=<spring:message code="form.submit"/> class="btn btn-info">   </td></tr>
							
							</form:form>
						
					</table>
			</div>


		</div>
	</div>
















	<jsp:include page="../fragments/footer.jsp"></jsp:include>