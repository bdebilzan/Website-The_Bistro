<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="admin-header.tld" prefix= "myTag"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="app.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Bistro - Order Statuses</title>
</head>
<body>
<myTag:AdminHeader/>
<h2>Order Statuses</h2>
<table>
<thead>
<tr>
<th>Created</th>
<th>Item</th>
<th>Customer</th>
<th>Status</th>
</tr>
</thead>
<tbody>
<c:forEach items = "${items}" var="item">
<tr>
<td><fmt:formatDate value="${date}" type="time" /></td>
<td> <img src="${item.getImageUrl()}" width="100" height="100"> <br> ${item.getName()}</td>
<td>Bryce</td>
<td><form name="status" method="get" action="#">
       <select>
           <option>In Queue</option>
           <option>Completed</option>
           <option>In Progress</option>   
           
       </select>
    </form> 
</td>
</tr>
</c:forEach>
</tbody>
</table>
<button>Update Statuses</button>
</body>
</html>