<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h2>Login</h2>
    <h2 style="color: red;">${fail}</h2>
    <form method="post" action="login">
        <input type="text" name="username">
        <input type="password" name="pass">
        <input type="submit" value="submit">
    </form>
</body>
</html>