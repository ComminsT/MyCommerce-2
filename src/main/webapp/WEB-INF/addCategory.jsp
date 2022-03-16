<%--
  Created by IntelliJ IDEA.
  User: Thoma
  Date: 16/03/2022
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
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
