<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Onlie-Zone</title>
    <style>
        /* @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@700&display=swap'); */
    </style>
    <!-- <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/onlinezone.com/asset/frontassets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/onlinezone.com/asset/frontassets/css/onlinezone.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/onlinezone.com/asset/frontassets/css/profile.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/onlinezone.com/asset/frontassets/css/style.css">
    <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" referrerpolicy="no-referrer" /> -->
</head>
<body>
    <!-- <div class="container-fluid"> -->
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top bg-dark">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/onlinezone.com/">Navbar</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                  
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                      <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                          <a class="nav-link" href="${pageContext.request.contextPath}/onlinezone.com/">Home</a>
                        </li>
                        <li class="nav-item active">
						    <%  if( session.getAttribute("USER_EMAIL")!=null &&   !session.getAttribute("USER_EMAIL").equals("")) {
						    }else{%>
	                   				<a href="${pageContext.request.contextPath}/onlinezone.com/login" class="nav-link">Login</a>
						    <%
						    }
						    %>                    
                        </li>
                        <li class="nav-item active">
                        	 <%  if( session.getAttribute("USER_EMAIL")!=null &&   !session.getAttribute("USER_EMAIL").equals("")) {
						    }else{%>
	                   				 <a class="nav-link" href="${pageContext.request.contextPath}/onlinezone.com/register">Register</a>
						    <%
						    }
						    %>     
                        
                         
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/onlinezone.com/question">Questions</a>
                        </li>
                         <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/onlinezone.com/add-question">Add Question</a>
                        </li>
                        <li class="nav-item active">
                          <a class="nav-link" href="${pageContext.request.contextPath}/onlinezone.com/profile">Profile</a>
                      </li>
                       <li class="nav-item active">
                       		 <%  if( session.getAttribute("USER_EMAIL")!=null &&   !session.getAttribute("USER_EMAIL").equals("")) {
                       			 %>
	                   				<a class="nav-link" href="${pageContext.request.contextPath}/onlinezone.com/logout">Logout</a>
						    <%}%>
                      </li>
                      </ul>
                    </div>
                  </nav>