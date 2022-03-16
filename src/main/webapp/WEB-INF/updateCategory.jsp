<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mise à jour</title>
</head>
<body>

<form method ="post" action ="update-category">
	<input type="text" name="id" value="${category.id }">
	<input type="text" name="lib" value="${category.libelee}">
	<input type="submit" value="Mettre à jour">
</form>

</body>
</html>