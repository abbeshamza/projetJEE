<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../fragments/headeru.jsp"></jsp:include>	



    <div class="  col-md-offset-5">
			<h1><spring:message code="reservation.user.label"/></h1>
		</div>
<br><br><br>



<div class="container ">
  <table class="table table-responsive">
       <thead>
    <th><spring:message code="reservation.form.index.event" /></th>
    <th><spring:message code="reservation.form.index.event.title" /> </th>
    <th>   <spring:message code="reservation.form.index.event.prix" /></th>
    <th>   <spring:message code="reservation.form.new.label.nbr_place" /></th>
    <th> <spring:message code="reservation.form.index.event.statut" /></th>
    <th><spring:message code="reservation.form.index.event.supprimer" /></th>
    <th><spring:message code="reservation.form.index.event.payer" /></th>
    </thead>
    <tbody>
	
    <c:forEach var="item" items="${reservations }">
  
    
     <tr
            <c:if test="${item.statut == 'oui'}"> class="info" </c:if>
       <c:if test="${item.statut == 'non'}"> class="danger" </c:if> 
    >
    <td class="col-md-2">
   
   
  <a href="#"> <img src="${item.event.img }" class="img-responsive img-responsive img-rounded"  / ></a>
   
    </td>
    <th>
          ${item.event.label} &nbsp;
          </th>
     <th>
      ${item.event.prix} &nbsp;
      </th>
    <th>
    ${item.nbr_place} &nbsp;
    </th>
    <td>
    ${item.statut} &nbsp;
    </td>
    <td>

    <div class='btn btn-danger'>
    <a href=' <spring:url value="/app/reservation/delete/${item.id }" />' > <button class="btn btn-danger"> <spring:message code="reservation.form.index.event.supprimer" /></button></a>
    </div>
    </td>

    <td>

     <!-- Button trigger modal -->
     <button type="button" class="btn btn-success " data-toggle="modal"
      <c:if test="${item.statut == 'oui'}">disabled  </c:if>
     data-target="#myModal${item.id }">
      Payer
     </button>

     <!-- Modal -->
     <div class="modal fade" id="myModal${item.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
       <div class="modal-dialog" role="document">
         <div class="modal-content">
           <div class="modal-header">
             <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
             <h4 class="modal-title" id="myModalLabel">Carte de crédit</h4>
           </div>
           <div class="modal-body">
           <form:form method="post" class="form-horizontal" action="${pageContext.request.contextPath}/app/reservation/payer/${item.id}" > 
             <label><spring:message code="carte.form.new.label.numero" /> </label>
             <input type="numero" placeholder=" ----------" name="num">
             <label><spring:message code="carte.form.new.label.password"> </spring:message> </label>
             <input type="password" placeholder="*********" name="pass">
            
           </div>
           <div class="modal-footer">
             <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
             <button type="submit" class="btn btn-primary">payer</button>
             </form:form>
           </div>
         </div>
       </div>
     </div>
    </td>

    </tr>

   </c:forEach>
    </tbody>
  </table>
  </div>


    










<jsp:include page="../fragments/footer.jsp"></jsp:include>	