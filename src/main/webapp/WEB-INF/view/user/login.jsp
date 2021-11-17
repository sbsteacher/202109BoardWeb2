<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <div>
        <form action="/user/login" method="post">
            <div><input type="text" name="uid" placeholder="user id"></div>
            <div><input type="password" name="upw" placeholder="user password"></div>
            <div>
                <input type="submit" value="login">
            </div>
        </form>
        <div>
            <a href="/user/join">join</a>
        </div>
    </div>
</body>
</html>