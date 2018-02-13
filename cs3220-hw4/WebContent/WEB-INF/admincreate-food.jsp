
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
<title>The Bistro - Create Food</title>
</head>
<body>
<myTag:AdminHeader/>
<h2>Add New Food</h2>
<form method="post">
<label for="name">Name: </label> <br>
<input name="name" id="name" type="text"><br>
<label for="url">Image Link: </label><br>
<input name="url" id="url" type="text"><br>
<label for="description">Description: </label><br>
<input name="description" id="description"></input> <br>
<label for="price">Price: </label><br>
<input name="price" id="price" type="text"><br>
<button name="Submit" value="Submit">Add food</button>
</form>
</body>
</html>