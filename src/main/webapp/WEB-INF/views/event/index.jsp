
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../fragments/headeru.jsp"></jsp:include>	
<div class="  col-md-offset-5">
			<h1><spring:message code="event.list"/></h1>
		</div>
<br><br><br>
	<div class="container">



  <!-- foreach evenet -->
  <c:forEach var="item" items="${events }">
       

        <div class="row">
            <div class="col-md-3 image-responsive">
              
           <img src="${item.img }" class="img-responsive img-thumbnail" width="100%" height ="100%" />
            </div>
            <div class="col-md-8">
                <h3>${item.label }</h3>
                <h4>${item.categorie.label }</h4>
               <p>${item.description }&nbsp;</p>
                <a href=" <spring:url value="/app/events/show/${item.id }"/>"><button class="btn btn-primary"><spring:message code="event.btn.afficher" /> </button></a>
            </div>
        </div>

        <br>
  <!-- end foreach evenet -->
  </c:forEach>
  
  
   
  
  
  </div>
  
  
  
  
  
  
  
  
 
  <jsp:include page="../fragments/footer.jsp"></jsp:include>	