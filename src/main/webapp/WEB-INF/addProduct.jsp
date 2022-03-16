<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1>Add product</h1>
<form class="form" action="/auth/add-product" method="post">
    <label for="name">Name</label>
    <input id="name" type="text" name="pName">

    <label for="content">Content</label>
    <input id="content" type="text" name="pContent">

    <label for="productCategory">Sélectionnez une catégorie</label>
    <select name="pCategory" id="productCategory">
        <option value="">Veuillez choisir une option :</option>

<c:forEach items="${categoryList}" var="category">
    <option value="${category.id}">${category.libelee}</option>
</c:forEach>

    </select>

    <label for="price">Price</label>
    <input id="price" type="number" name="pPrice">
    <button type="submit">Add</button>
</form>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
