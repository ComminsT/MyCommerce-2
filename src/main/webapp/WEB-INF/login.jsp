<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body class="container">

<jsp:include page="header.jsp"></jsp:include>
<div class="row">
<div class="col-6">
<h1>Login</h1>
<form action="login" method="post">
    <div class="row">
    <label for="usernameInput"></label>
    <input placeholder="Nom de compte" id="Mot de passe" type="text" name="username">
    </div>
    <div class="row-1">
    <label for="pwd"></label>
    <input placeholder="Mot de passe" id="pwd" type="text" name="pwd">
    </div>
    <button class="btn-success"  type="submit">Login</button>
</form>
</div >

<div class="col-6">
    <h1>Inscription</h1>
    <form action="registration" method="post">
        <label for="usernameInput"></label>
        <input id="usernameInput" type="text" name="username">

        <label for="newPwd">Mot de passe</label>
        <input placeholder="Mot de passe" id="newPwd" type="text" name="pwd">
        <button value="registration" class="btn-success" type="submit">Registration</button>
    </form>

</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
