<%--
  Created by IntelliJ IDEA.
  User: Thoma
  Date: 16/03/2022
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Nouvelles catégories</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<form action="/auth/add-category" method="post">
    <label for="libelee">Libelee</label>
    <input id="libelee" name="cLibelee" type="text">
    <button type="submit">Valider</button>

</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
