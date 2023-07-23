<!DOCTYPE html>
<html xmlns:th="http:/www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Login - Company ABC</title>
</head>
<body>
<div>
<form th:action="@{/doLogin}" method="post" style="max-width: 400px; margin: 0 auto;">
    <p>
        E-mail: <input type="email" name="username" required />  
    </p>
    <p>
        Password: <input type="password" name="password" required />
    </p>
    <p>
        <input type="submit" value="Login" />
    </p>
</form>
</div>
</body>
</html>