<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1>Category list</h1>


<c:if test="${empty categoryList}">
    <p>no category yet.</p>
    <a href="/auth/add-category">Add category</a>
</c:if>

<table>
    <c:forEach items="${categoryList}" var="category">
        <thead>
        <tr>
            <th>ID</th>
            <th>Libelle</th>
            <th colspan="2">Actions</th>
        </tr>
        </thead>
        <tr>
            <td>${category.id}</td>
            <td>${category.libelee}</td>

            <td>
            	<form action="/update-category?id=${category.id}" method="get">
            		<input type hidden name="categoryId" value="${category.id}">
            		<button type="submit">update</button>
            	</form>
            </td>
            <td>
                <form action="/auth/removeCategory" method="post">
                    <input hidden name="categoryId" value="${category.id}">
                    <button type="submit">Remove</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
