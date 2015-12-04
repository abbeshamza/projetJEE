<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
<nav class="navbar navbar-default">
		<div class="container-fluid">
		
			<div class="navbar-header">
      			<a class="navbar-brand" href="#">Event</a>
    		</div>
    		
    		<ul class="nav navbar-nav">
    		
    			<li><a href="#"><spring:message code="user.nav.home"/></a></li>
    		
    			<li class="dropdown">
          			
          			<a href="#" class="dropdown-toggle" 
          				data-toggle="dropdown" role="button" 
          				aria-expanded="false">Events <span class="caret"></span></a>
          	
          			<ul class="dropdown-menu" role="menu">
            			<li><a href="<spring:url value="/project/add"/>"><spring:message code="user.nav.event.add"/></a></li>
            			<li><a href="<spring:url value="/project/find"/>"><spring:message code="user.nav.event.find"/></a></li>
          			</ul>
          			
        		</li>
        		<li><a href="#"><spring:message code="user.nav.about"/></a></li>
        		<li><a href="#"><spring:message code="user.nav.contact"/></a></li>
        		</ul>
        		<ul class=" nav navbar-nav pull-right">
        			<li><a href="#"><spring:message code="user.nav.card"/></a></li>
    			<li class="dropdown">
          		
          			<a href="#" class="dropdown-toggle" 
          				data-toggle="dropdown" role="button" 
          				aria-expanded="false"><spring:message code="user.nav.profil"/> <span class="caret"></span></a>
          		
          			<ul class="dropdown-menu" role="menu">
            			<li><a href="<spring:url value="/resource/add"/>"><spring:message code="user.nav.logout"/></a></li>
            			<li><a href="#">Find</a></li>
          			</ul>
        		
        		</li>
        		
    		</ul>
    		
		</div>
</nav>
</div>