<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
    <title>Add product</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1>Add product</h1>
<form action="/auth/add-product" method="post">
    <label for="name">Name</label>
    <input id="name" type="text" name="pName">
    <label for="content">Content</label>
    <input id="content" type="text" name="pContent">
    <label for="productCategory">Sélectionnez une catégorie</label>
    <select name="category" id="productCategory">
        <option value="">Veuillez choisir une option :</option>


    </select>

    <label for="price">Price</label>
    <input id="price" type="number" name="pPrice">
    <button type="submit">Add</button>
</form>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
