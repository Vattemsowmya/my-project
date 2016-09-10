<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en-US">
<head><title>Spring 4 MVC + Hibernate</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  
</head>
<body>
  <c:url var="addAction" value="addComponent" ></c:url>

<form:form action="${addAction}" modelAttribute="component" id="btn-add">
   
	  
	  <table>
	  
	  <tr>  
	  <td> Id:</td> <td><form:input  path="id"/></td> 
	  <tr> <td> Name:</td> <td><form:input  path="name"/></td> 
	  <tr> <td>Description:</td> <td><form:input path="description"/> </td> 
	  <tr> <td>Price: </td> <td><form:input path="price"/></td> 
		
  
	    <tr> <td colspan="2">
    	        <c:if test="${component.id==0}">
			      <input type="submit" value="Add" id="btn-add"> 
	         </c:if>
	         <c:if test="${component.id!=0}">
			      <input type="submit" value="Update" id="btn-update"> 
	         </c:if>
		</td> 
		<tr> <td colspan="2" class="success-msg">
		   <c:out value="${msg}"/>
		</td> 
		<h3>
                    <c:if test="$(component.id==0}">
		       Add New Component
	            </c:if>
	            <c:if test="${!empty Component.id}">
		      Update Item for Id: <c:out value="${component.id}"/>
		     <%--  <form:hidden path="id"/> --%>
	            </c:if>
      </h3>   
	  </table>
	  <table border="4">   
		 <tr>		 <td> ID </td>
		        	 <td> Name </td>
				 <td> Description</td>
				 <td> Price </td>
				 <td colspan="2"> City </td>
	      	</tr>
    	      <c:forEach items="${allData}" var="obj">
		      <tr>
		                 <td> <c:out value="${obj.id}"/> </td>
		                 <td> <c:out value="${obj.name}"/> </td>
				 <td> <c:out value="${obj.description}"/> </td>
				 <td> <c:out value="${obj.price}"/> </td>
				
				 <td> <a href="deleteById/${obj.id}">Delete </a> |
				     <a href="ComponentById/${obj.id}">Edit</a> 
				 </td>
		      </tr>
	      </c:forEach>
         </table>
 </form:form>

</body>
</html> 
