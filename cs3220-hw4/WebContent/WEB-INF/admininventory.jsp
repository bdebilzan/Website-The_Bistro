<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="admin-header.tld" prefix= "myTag"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="app.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Bistro - Inventory</title>
</head>
<body>

<myTag:AdminHeader/>
<h2>Existing Food Items</h2>
<table>
<thead>
<tr>
<th>Created</th>
<th>Item</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items = "${items}" var="item">
<tr>
<td><fmt:formatDate value="${date}" type="time" /></td>
<td> <img src="${item.imageUrl}" width="100" height="100"> <br> ${item.name}</td>
<td><form method="get"> <button name="Submit" value="${item.id}">Delete</button></form></td>
</tr>
</c:forEach>
</tbody>
</table>
<form method="post">
<button>Add New Food</button>
</form>

</body>
</html>