<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
    <div class="container">
    
         <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<spring:url value="/app"></spring:url>'>Event</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href='<spring:url value="/app"/>'><spring:message code="user.nav.home"/></a></li>
              <li class="dropdown">
          			
          			<a href="#" class="dropdown-toggle" 
          				data-toggle="dropdown" role="button" 
          				aria-expanded="false">Events <span class="caret"></span></a>
          	
          			<ul class="dropdown-menu" role="menu">
            			<li><a href="<spring:url value="/app/events/new"/>"><spring:message code="user.nav.event.add"/></a></li>
            			<li><a href="<spring:url value="/app/events/index"/>"><spring:message code="user.nav.event.find"/></a></li>
          			</ul>
          			
        		</li>
        		<li><a href="<spring:url value="/app/about"/>"><spring:message code="user.nav.about"/></a></li>
        		</ul>
        		
        		
        		<ul class=" nav navbar-nav pull-right">
        			<li><a href="<spring:url value="/app/reservation/index"/>"><spring:message code="user.nav.card"/></a></li>
    			<li class="dropdown">
          		
          			<a href="#" class="dropdown-toggle" 
          				data-toggle="dropdown" role="button" 
          				aria-expanded="false"><spring:message code="user.nav.profil"/> <span class="caret"></span></a>
          		
          			<ul class="dropdown-menu" role="menu">
            			<li><a href=' <spring:url value="/app/me"/> '><spring:message code="profil.label"></spring:message></a></li>
            			<li><a href=' <spring:url value="/app/me/edit"/> '><spring:message code="profil.edit" ></spring:message>t</a></li>
            			<li><a href='<spring:url value="/app/events/eventme"/>'><spring:message code="event.me"/></a></li>
            			<li><a href='<spring:url value="/logout"/>'><spring:message code="user.nav.logout"/></a></li>
          			</ul>
        		
        		</li>
        		
    		</ul>
             
              </div>
              </div>
              </nav>
    </div>	
		