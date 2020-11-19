<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>

<div class="login-page">
  <div class="form">
    <form class="login-form" action="LoginAction.action">
      <input type="text" placeholder="username" required="" name="userName" />
      <input type="password" placeholder="password" required="" name="password"/>
      <input id="button" type="submit" value="Log in" />
    </form>
  </div>
</div>

</body>
</html>