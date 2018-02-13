<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="customer-header.tld" prefix= "myTag"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="app.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Bistro - Menu</title>
</head>
<body>
<form>
<myTag:CustomerHeader/>
<h2>Food Menu</h2>
 <table>
<thead><tr><th>Item</th><th>Price</th><th>Description</th><th>Quantity</th></tr></thead>
<tbody>
<c:forEach items = "${items}" var="item">
<tr>
<td> <img src="${item.getImageUrl()}" width="100" height="100"> <br> ${item.getName()} </td>
<td> $${item.getPrice()}0 </td>
<td> ${item.getDescription()} </td>
			    <td> <input type = 'text' width= '7px' name= 'fooditem_id' value="0" /> 
			         <input type='hidden' name='fid' value="${item.getId()}">
</td>
</tr>
</c:forEach>
</tbody>
</table>
<button>Add to Cart</button>
</form>
</body>
<p>&copy; 2017 The Bistro Inc., All Rights Reserved</p>
</html>